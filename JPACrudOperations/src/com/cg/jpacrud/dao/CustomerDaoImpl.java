package com.cg.jpacrud.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import com.cg.jpacrud.entities.CustomerBean;



public class CustomerDaoImpl  {
	
	private EntityManager entityManager;

	public CustomerDaoImpl() {
		entityManager = JPAUtil.getEntityManager();
	}
	
	
	public void addCustomer(CustomerBean customer) {
		entityManager.persist(customer);
	}
	
	
	public CustomerBean getCustomerById(int id) {
		CustomerBean customer = entityManager.find(CustomerBean.class, id);
		return customer;
	}


	public void updateCustomer(CustomerBean customer) {
		entityManager.merge(customer);
		
	}
	public void removeCustomer(CustomerBean customer) {
		entityManager.remove(customer);
		
	}
	
	public CustomerBean getCustomerByPhone(int phone) {
		entityManager.getTransaction().begin();
		
		String qStr = "SELECT cust FROM CustomerBean cust WHERE phone  = :phone";
		TypedQuery<CustomerBean> query = entityManager.createQuery(qStr, CustomerBean.class);
		query.setParameter("phone", phone);
		CustomerBean customer = query.getSingleResult();
		entityManager.getTransaction().commit();
		return customer;
	}
	
	public List<CustomerBean> getCustomerByPhone1(int phone1) {
		entityManager.getTransaction().begin();
		
		String qStr = "SELECT cust FROM CustomerBean cust WHERE phone  = :phone";
		TypedQuery<CustomerBean> query = entityManager.createQuery(qStr, CustomerBean.class);
		query.setParameter("phone", phone1);
		List<CustomerBean> customer = query.getResultList();
		entityManager.getTransaction().commit();
		return customer;
	}
	public void beginTransaction() {
		entityManager.getTransaction().begin();
	}

	
	public void commitTransaction() {
		entityManager.getTransaction().commit();
	}


	public List<CustomerBean> getAllCustomer() {
		Query query = entityManager.createNamedQuery("getAllCustomer");
		@SuppressWarnings("unchecked")
		List<CustomerBean> bookList = query.getResultList();
		return bookList;
	}


	public List<CustomerBean> getCustomerIds() {
		// TODO Auto-generated method stub
		
		Query query = entityManager.createNamedQuery("getAllCustomerIds");
		@SuppressWarnings("unchecked")
		List<CustomerBean> idList = query.getResultList();
		return idList;
	}


	
	
	
}
	
	

	
	


