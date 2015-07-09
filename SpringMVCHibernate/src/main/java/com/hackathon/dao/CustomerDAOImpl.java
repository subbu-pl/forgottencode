package com.hackathon.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.jmx.access.InvalidInvocationException;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hackathon.dto.MonthlyUsageDto;
import com.hackathon.dto.UsageSlabDto;
import com.hackathon.model.Customer;
import com.hackathon.model.MonthlyUsageDetails;
import com.hackathon.model.SmartMeterInvoice;

@Repository
public class CustomerDAOImpl implements CustomerDAO{

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	public void addCustomer(Customer customer) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(customer);
	}

	public void updateCustomer(Customer customer) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(customer);
	}

	@SuppressWarnings("unchecked")
	public List<Customer> listCustomers() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Customer> customersList = session.createQuery("from Customer").list();
		return customersList;
	}
	
	@SuppressWarnings("unchecked")
	public List<Integer> listSmtIds() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Integer> smtIdList = session.createQuery("select smartMeterId from Customer").list();
		return smtIdList;
	}
	
	public Customer getCustomerById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Customer customer = (Customer) session.load(Customer.class, new Integer(id));
		return customer;
	}

	public void removeCustomer(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Customer customer = (Customer) session.load(Customer.class, new Integer(id));
		if(null != customer){
			session.delete(customer);
		}
	}

	public List<MonthlyUsageDetails> listUsageDetails() {
		Session session = this.sessionFactory.getCurrentSession();
		List<MonthlyUsageDetails> usageDetailsList = session.createQuery("from MonthlyUsageDetails").list();
		for(MonthlyUsageDetails usage:usageDetailsList){
			System.out.println(usage);
		}
		System.out.println(usageDetailsList.size());
		return usageDetailsList;
	}

	public List<MonthlyUsageDetails> listUsageDetails(int smartMeterId) {
		Session session = this.sessionFactory.getCurrentSession();
		List<MonthlyUsageDetails> usageDetailsList = session.createQuery("from MonthlyUsageDetails where smartMeterId="+smartMeterId+"").list();
		for(MonthlyUsageDetails usage:usageDetailsList){
			System.out.println(usage);
		}
		System.out.println(usageDetailsList.size());
		return usageDetailsList;
	}
	
	public List<MonthlyUsageDetails> getInvoiceByBillDate() {
		Session session = this.sessionFactory.getCurrentSession();
		List<MonthlyUsageDetails> monDetailsList = new ArrayList<MonthlyUsageDetails>();
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		int dateNo = cal.get(Calendar.DATE);
		 cal.add(Calendar.DAY_OF_MONTH,20);
		List<Customer> smartIds = session.createQuery("from Customer where billingDate="+dateNo).list();
		for(Customer cust:smartIds){
			String sqlStartMeter = "select mtr_start from monthly_usage_tr where date(Start_time) = "+
				"(select min(date(Start_time)) from monthly_usage_tr where date(Start_time) between (DATE_SUB(curdate(), INTERVAL 31 DAY))"+ 
				"and curdate()) and SMART_METER_ID="+cust.getSmartMeterId();
			SQLQuery queryStartMeter = session.createSQLQuery(sqlStartMeter);
			List resultsStartMeter = queryStartMeter.list();
			System.out.println(resultsStartMeter.size());
			System.out.println("resultsStartMeter.toString()-->"+resultsStartMeter.toString());
			int startMeterId = 0;
			if (resultsStartMeter != null && resultsStartMeter.size() >0) {
				startMeterId = (Integer) resultsStartMeter.get(0);
			}
			
			String sqlEndMeter = "select mtr_end from monthly_usage_tr where date(end_time) ="+ 
					"(select max(date(end_time)) from monthly_usage_tr where date(end_time) between (DATE_SUB(curdate(), INTERVAL 31 DAY))"+ 
					"and curdate()) and SMART_METER_ID="+cust.getSmartMeterId();
			SQLQuery queryEndMeter = session.createSQLQuery(sqlEndMeter);
			List resultsEndMeter = queryEndMeter.list();
			int endMeterId = 0;
			if (resultsEndMeter != null && resultsEndMeter.size() > 0) {
				endMeterId = (Integer) resultsEndMeter.get(0);
			}
			if (endMeterId-startMeterId > 0) {
				List<UsageSlabDto> usSlbDtoLst = getUsageSlab();
				
				MonthlyUsageDto mtDto = new MonthlyUsageDto();
				mtDto.setAmount(0);
				mtDto.setMtrStart(startMeterId);
				mtDto.setMtrEnd(endMeterId);
				mtDto = calculateBill(usSlbDtoLst,mtDto);
				SmartMeterInvoice invoice = new SmartMeterInvoice();
				invoice.setAmount(mtDto.getAmount());
				invoice.setSmartMeterId(cust.getSmartMeterId());
				invoice.setUnits(endMeterId - startMeterId);
				invoice.setDueDate(cal.getTime());
				invoice.setCreateddate(new Date());
				
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				String dateString = format.format(new Date());
				
				Query query = session.createQuery("from SmartMeterInvoice where smartMeterId="+cust.getSmartMeterId());
				List<SmartMeterInvoice> smiList = query.list();
				SmartMeterInvoice smInv = new SmartMeterInvoice();
				if(smiList.size() <= 0){
					session.persist(invoice);
					mtDto.setInvoiceNumber(String.valueOf(invoice.getInvoiceNumber()));
				}else {
					smInv = smiList.get(0);
					mtDto.setInvoiceNumber(String.valueOf(smInv.getInvoiceNumber()));
				}
				
				
				MonthlyUsageDetails monthUsgDtls = new MonthlyUsageDetails();
				
				monthUsgDtls.setAmount(mtDto.getAmount());
				
			     monthUsgDtls.setDueDate(cal.getTime());
				monthUsgDtls.setInvoiceNumber(mtDto.getInvoiceNumber());
				monthUsgDtls.setSmartMeterId(invoice.getSmartMeterId());
				monthUsgDtls.setReading(invoice.getUnits());
				monDetailsList.add(monthUsgDtls);	
			}
			
		}
			
		return monDetailsList;
	}

	@SuppressWarnings("unchecked")
	public List<SmartMeterInvoice> listSmartMeterInvoices() {
		Session session = this.sessionFactory.getCurrentSession();
		List<SmartMeterInvoice> smartMeterInvoicesList = session.createQuery("from Invoice").list();
		return smartMeterInvoicesList;
	}
	
	public List<MonthlyUsageDetails> getInvoiceByFilter(String[] ids, String month) {
		Session session = this.sessionFactory.getCurrentSession();
		List<MonthlyUsageDetails> monDetailsList = new ArrayList<MonthlyUsageDetails>();
		Calendar calendar = Calendar.getInstance();
		 calendar.add(Calendar.DAY_OF_MONTH,20);
		for (String smartMeterId : ids) {
				String sqlStartMeter = "select mtr_start from monthly_usage_tr where date(Start_time) = "+
					"(select min(date(Start_time)) from monthly_usage_tr where date(Start_time) between (DATE_SUB(curdate(), INTERVAL 31 DAY))"+ 
					"and curdate()) and SMART_METER_ID="+smartMeterId;
				SQLQuery queryStartMeter = session.createSQLQuery(sqlStartMeter);
				List resultsStartMeter = queryStartMeter.list();
				System.out.println(resultsStartMeter.size());
				System.out.println("resultsStartMeter.toString()-->"+resultsStartMeter.toString());
				int startMeterId = 0;
				if (resultsStartMeter != null && resultsStartMeter.size() >0) {
					startMeterId = (Integer) resultsStartMeter.get(0);
				}
				
				String sqlEndMeter = "select mtr_end from monthly_usage_tr where date(end_time) ="+ 
						"(select max(date(end_time)) from monthly_usage_tr where date(end_time) between (DATE_SUB(curdate(), INTERVAL 31 DAY))"+ 
						"and curdate()) and SMART_METER_ID="+smartMeterId;
				SQLQuery queryEndMeter = session.createSQLQuery(sqlEndMeter);
				List resultsEndMeter = queryEndMeter.list();
				int endMeterId = 0;
				if (resultsEndMeter != null && resultsEndMeter.size() > 0) {
					endMeterId = (Integer) resultsEndMeter.get(0);
				}
				
				if (endMeterId-startMeterId > 0) {
					List<UsageSlabDto> usSlbDtoLst = getUsageSlab();
					
					MonthlyUsageDto mtDto = new MonthlyUsageDto();
					mtDto.setAmount(0);
					mtDto.setMtrStart(startMeterId);
					mtDto.setMtrEnd(endMeterId);
					mtDto = calculateBill(usSlbDtoLst,mtDto);
					SmartMeterInvoice invoice = new SmartMeterInvoice();
					invoice.setAmount(mtDto.getAmount());
					invoice.setSmartMeterId(Integer.parseInt(smartMeterId));
					invoice.setUnits(endMeterId - startMeterId);
					invoice.setDueDate(calendar.getTime());
					invoice.setCreateddate(new Date());
					session.persist(invoice);
					mtDto.setInvoiceNumber(String.valueOf(invoice.getInvoiceNumber()));
					
					MonthlyUsageDetails monthUsgDtls = new MonthlyUsageDetails();
					
					monthUsgDtls.setAmount(mtDto.getAmount());
					
				     monthUsgDtls.setDueDate(calendar.getTime());
					monthUsgDtls.setInvoiceNumber(mtDto.getInvoiceNumber());
					monthUsgDtls.setSmartMeterId(invoice.getSmartMeterId());
					monthUsgDtls.setReading(invoice.getUnits());
					monDetailsList.add(monthUsgDtls);	
				}
				
		}
		return monDetailsList;
	}
	

	public MonthlyUsageDto calculateBill(List<UsageSlabDto> slabRef,
			MonthlyUsageDto billing) {
		System.out.println("Inside Calculate Bill MOdule");
		
		Map<Integer, Double> slbMp = new HashMap<Integer, Double>();
		if (slabRef != null) {
			for (UsageSlabDto slb : slabRef) {
				slbMp.put(slb.getSlabId(),slb.getRatePerUnit());
			}
		}
		System.out.println("billing.getAmount()--->"+billing.getAmount());
		if (billing != null) {
			billing.setAmount(calBillAmt(billing.getMtrEnd() - billing.getMtrStart(), slbMp));
			billing.setAmount(calFinalAmt(billing.getAmount()));
		}
		System.out.println("billing.getAmount()after--->"+billing.getAmount());
		System.out.println("Exit Calculate Bill MOdule");
		return billing;
	}

	private double calFinalAmt(double amt) {
		return amt+(amt/10);
	}
	
	private double calPrice(double amt, int unt, double price) {
		return  amt+(unt*price);
	}

	private double calBillAmt(int diffUnts, Map<Integer,Double> slbMp) {
		int slbCnt = diffUnts/300;
		double amt = 0;
		System.out.println("diffUnts-->"+diffUnts);
		System.out.println("slbCnt-->"+slbCnt);
		int bal = diffUnts%300;
		for (int i=0;i< slbCnt;i++) {
			if (i==0) {
				if (i == slbCnt-1 && bal > 0) {
					amt=(calPrice(amt, bal, slbMp.get(2)));
				}
				amt = ((calPrice(amt, 300, slbMp.get(1))));
			} else if (i==1) {
				if (i == slbCnt-1 && bal > 0) {
					amt = ((calPrice(amt, bal, slbMp.get(3))));	
				}
				amt = ((calPrice(amt, 300, slbMp.get(2))));
				
			} else if (i==2) {
				if (i == slbCnt-1 && bal > 0) {
					amt = ((calPrice(amt, bal, slbMp.get(4))));
				}
				amt = ((calPrice(amt, 300, slbMp.get(3))));	
			} else if (i>=3) {
				amt = ((calPrice(amt, diffUnts-900, slbMp.get(4))));
				break;
			}
		}
		System.out.println("Amt before tax--->"+amt);
		return amt;
	}

	public List<UsageSlabDto> getUsageSlab() {
		Session session = this.sessionFactory.getCurrentSession();
		List<UsageSlabDto> usageSlab = session.createQuery("from UsageSlabDto").list();
		return usageSlab;
	}

}
