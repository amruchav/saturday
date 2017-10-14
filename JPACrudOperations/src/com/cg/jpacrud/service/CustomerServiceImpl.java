package com.cg.jpacrud.service;


import java.util.List;

import com.cg.jpacrud.dao.CustomerDaoImpl;
import com.cg.jpacrud.entities.CustomerBean;
import com.cg.jpacrud.entities.Student;


public class CustomerServiceImpl {
	
	private CustomerDaoImpl dao;

	public CustomerServiceImpl() {
		dao = new CustomerDaoImpl();
	}
	

	public void addCustomer(CustomerBean customer) {
		dao.beginTransaction();
		dao.addCustomer(customer);
		dao.commitTransaction();
	}
	
	public CustomerBean findCustomerById(int id) {
		//no need of transaction, as it's an read operation
		CustomerBean customer  = dao.getCustomerById(id);
				return customer;
	}


	public void updateCustomer(CustomerBean customer) {
		dao.beginTransaction();
		dao.updateCustomer(customer);
		dao.commitTransaction();
	}


	public void removeCustomer(CustomerBean customer) {
		dao.beginTransaction();
		dao.removeCustomer(customer);
		dao.commitTransaction();
	}

	public CustomerBean  getCustomerByPhone(int phone) {
		return dao.getCustomerByPhone(phone);
	}


	public List<CustomerBean> getCustomerByPhone1(int phone1) {
		return dao.getCustomerByPhone1(phone1);
	}


	public List<CustomerBean> getAllCustomer() {
			return dao.getAllCustomer();
		}


	public List<CustomerBean> getCustomerIds() {
		// TODO Auto-generated method stub
		return dao.getCustomerIds();
	}
	}


	
	

