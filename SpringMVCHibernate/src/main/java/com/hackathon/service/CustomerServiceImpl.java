package com.hackathon.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hackathon.dao.CustomerDAO;
import com.hackathon.model.Customer;
import com.hackathon.model.MonthlyUsageDetails;

@Service
public class CustomerServiceImpl implements CustomerService{

	private CustomerDAO customerDAO;

	public void setCustomerDAO(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}

	@Transactional
	public void addCustomer(Customer customer) {
		this.customerDAO.addCustomer(customer);
	}

	@Transactional
	public void updateCustomer(Customer customer) {
		this.customerDAO.updateCustomer(customer);
	}

	@Transactional
	public List<Customer> listCustomers() {
		return this.customerDAO.listCustomers();
	}
	@Transactional
	public List<Integer> listSmtIds() {
		return this.customerDAO.listSmtIds();
	}
	
	@Transactional
	public Customer getCustomerById(int id) {
		return this.customerDAO.getCustomerById(id);
	}

	@Transactional
	public void removeCustomer(int id) {
		this.customerDAO.removeCustomer(id);
	}

	@Transactional
	public List<MonthlyUsageDetails> listUsageDetails() {
		// TODO Auto-generated method stub
		return this.customerDAO.listUsageDetails();
	}
	
	@Transactional
	public List<MonthlyUsageDetails> listUsageDetails(int smartMeterId) {
		// TODO Auto-generated method stub
		return this.customerDAO.listUsageDetails(smartMeterId);
	}

	@Transactional
	public List<MonthlyUsageDetails> getInvoiceByBillDate() {
		return this.customerDAO.getInvoiceByBillDate();
	}

	@Transactional
	public List<MonthlyUsageDetails> getInvoiceByFilter(String[] ids, String month) {
		return this.customerDAO.getInvoiceByFilter(ids, month);
	}
	
}
