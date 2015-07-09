package com.hackathon.service;

import java.util.List;

import com.hackathon.model.Customer;
import com.hackathon.model.MonthlyUsageDetails;

public interface CustomerService {

	public void addCustomer(Customer customer);
	public void updateCustomer(Customer customer);
	public List<Customer> listCustomers();
	public Customer getCustomerById(int id);
	public void removeCustomer(int id);
	
	public List<MonthlyUsageDetails> listUsageDetails();
	public List<MonthlyUsageDetails> listUsageDetails(int smartMeterId);
	
	public List<Integer> listSmtIds();
	
	public List<MonthlyUsageDetails> getInvoiceByBillDate();
	public List<MonthlyUsageDetails> getInvoiceByFilter(String[] ids, String month);
	
}
