package com.hackathon.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.hackathon.model.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO{

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addCustomer(Customer customer) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(customer);
	}

	@Override
	public void updateCustomer(Customer customer) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(customer);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> listCustomers() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Customer> customersList = session.createQuery("from Customer").list();
		return customersList;
	}

	@Override
	public Customer getCustomerById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Customer customer = (Customer) session.load(Customer.class, new Integer(id));
		return customer;
	}

	@Override
	public void removeCustomer(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Customer customer = (Customer) session.load(Customer.class, new Integer(id));
		if(null != customer){
			session.delete(customer);
		}
	}
}
