package com.hackathon.controller;



import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hackathon.dto.UsageSlabDto;
import com.hackathon.model.Customer;
import com.hackathon.model.MonthlyUsageDetails;
import com.hackathon.service.CustomerService;


@Controller
public class CustomerController {
	
private CustomerService customerService;
	
	@Autowired(required=true)
	@Qualifier(value="customerService")
	public void setCustomerService(CustomerService cs){
		this.customerService = cs;
	}
	
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String loadHome(Model model) {
		return "welcome";
	}
	
	@RequestMapping(value = "/customers", method = RequestMethod.GET)
	public String listCustomers(Model model) {
		model.addAttribute("customer", new Customer());
		model.addAttribute("listCustomers", this.customerService.listCustomers());
		return "customer";
	}
	
	@RequestMapping(value = "/usage", method = RequestMethod.GET)
	public String listUsage(Model model) {
		model.addAttribute("customer", new Customer());
		model.addAttribute("listSmtIds", this.customerService.listSmtIds());
		model.addAttribute("listUsageDetails", this.customerService.getInvoiceByBillDate());
		return "usage";
	}
	
	@RequestMapping("/remove/{id}")
    public String removeCustomer(@PathVariable("id") int id){
		
        this.customerService.removeCustomer(id);
        return "redirect:/customers";
    }
 
    @RequestMapping("/edit/{id}")
    public String editCustomer(@PathVariable("id") int id, Model model){
        model.addAttribute("customer", this.customerService.getCustomerById(id));
        model.addAttribute("listCustomers", this.customerService.listCustomers());
        return "customer";
    }
	
    @RequestMapping(value = "/usageDetails", method = RequestMethod.GET)
	public String listUsageDetails(Model model) {
    	model.addAttribute("customer", new Customer());
    	model.addAttribute("listCustomers", this.customerService.listCustomers());
   		model.addAttribute("listUsageDetails", this.customerService.listUsageDetails());
		return "customer";
	}
    
    @RequestMapping(value = "/usageDetailsById/{id}", method = RequestMethod.GET)
   	public String listUsageDetailsBySmartMeterId(@PathVariable("id") int id, Model model) {
    	model.addAttribute("customer", new Customer());
    	model.addAttribute("listCustomers", this.customerService.listCustomers());
   		model.addAttribute("listUsageDetails", this.customerService.listUsageDetails(id));
   		return "customer";
   	}
    
   /* @RequestMapping(value = "/invoiceDetailsById", method = RequestMethod.GET)
   	public String getInvoiceByBillDate(Model model) {
    	model.addAttribute("customer", new Customer());
    	model.addAttribute("listCustomers", this.customerService.listCustomers());
   		model.addAttribute("listUsageDetails", this.customerService.getInvoiceByBillDate());
   		return "welcome";
   	}*/
    
    @RequestMapping(value= "/fetchInvoiceData")
	public String getInvoiceByFilter(HttpServletRequest request, Model model){
		model.addAttribute("customer", new Customer());
		model.addAttribute("listSmtIds", this.customerService.listSmtIds());
		String[] reqObj = request.getParameterValues("meterId");
		String reqObj2 = request.getParameter("month");
		//System.out.println(reqObj[0]+"-----"+reqObj[1]);
		System.out.println(reqObj2);
		model.addAttribute("listUsageDetails", this.customerService.getInvoiceByFilter(reqObj, reqObj2));
		
		return "usage";
	}
    
    @RequestMapping(value= "/customer/add", method = RequestMethod.POST)
	public String addCustomer(@ModelAttribute("customer") Customer customer){
		
		if(customer.getSmartMeterId() == 0){
			this.customerService.addCustomer(customer);
		}else{
			this.customerService.updateCustomer(customer);
		}
		return "redirect:/customers";
	}
}
