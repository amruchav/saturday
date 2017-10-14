package com.cg.jpacrud.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



@Entity
@Table(name="Customer")
@NamedQueries(
		{
			@NamedQuery(name = "getAllCustomer", query = "SELECT cust FROM CustomerBean cust"),
			@NamedQuery(name = "getAllCustomerIds", query = "SELECT cust.Id FROM CustomerBean cust")
})
public class CustomerBean implements Serializable {
		
		private static final long serialVersionUID = 1L;
		@Id
		@Column (name="cust_id")
		@GeneratedValue(strategy=GenerationType.AUTO, generator="my_seq_gen")
		@SequenceGenerator(name="my_seq_gen", sequenceName="CUST_ID_SEQ")
		private int Id;
		@Column(name="custname")
		private String name;
		@Column(name="cust_phone")
		private int phone;
		@Column(name="cust_email")
		private String email;
		@Column(name="DOB")
		private Date custDob;
		
		
		public int getId() {
			return Id;
		}
		public void setId(int id) {
			Id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getPhone() {
			return phone;
		}
		public void setPhone(int phone) {
			this.phone = phone;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public Date getCustDob() {
			return custDob;
		}
		public void setCustDob(Date custDob) {
			this.custDob = custDob;
		}
		@Override
		public String toString() {
			return "\nCustomer Id=" + Id + ", Customer name=" + name + ", Customer phone="
					+ phone + ",Customer email=" + email + ",Customer Dob=" + custDob + "]";
		}
		
		
		
}







