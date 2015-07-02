package com.hackathon.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hackathon.dao.CustomerDAO;
import com.hackathon.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService{

	private CustomerDAO customerDAO;

	public void setCustomerDAO(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}

	@Override
	@Transactional
	public void addCustomer(Customer customer) {
		this.customerDAO.addCustomer(customer);
	}

	@Override
	@Transactional
	public void updateCustomer(Customer customer) {
		this.customerDAO.updateCustomer(customer);
	}

	@Override
	@Transactional
	public List<Customer> listCustomers() {
		return this.customerDAO.listCustomers();
	}

	@Override
	@Transactional
	public Customer getCustomerById(int id) {
		return this.customerDAO.getCustomerById(id);
	}

	@Override
	@Transactional
	public void removeCustomer(int id) {
		this.customerDAO.removeCustomer(id);
	}

}
