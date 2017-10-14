package com.cg.jpacrud.client;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.cg.jpacrud.entities.CustomerBean;
import com.cg.jpacrud.service.CustomerServiceImpl;


public class CustomerClient {
	

	public static void main(String[] args) {

	
	CustomerBean customer=null;   //bean class object
	CustomerServiceImpl service=new CustomerServiceImpl();  //service class object
	
		while(true)
		{
			System.out.println("1.Add customer details");
			System.out.println("2.View all customer details");
			System.out.println("3.Find customer details by ID");
			System.out.println("4.Update customer details");
			System.out.println("5.Find single customer details by Mobile number");
			System.out.println("6.Find multiple customer details by Mobile number");
			System.out.println("7.Delete customer details");
			Scanner sc=new Scanner(System.in);
			
			int choice=sc.nextInt();
			
			switch(choice)
			{
			case 1:
			//Inserting data into table
			customer=new CustomerBean();
	//		System.out.println("\nEnter customer ID:");
	//		int Id=sc.nextInt();
			System.out.println("\nEnter customer Name:");
			String name=sc.next();
			System.out.println("\nEnter customer Phone Number:");
			int phone=sc.nextInt();
			System.out.println("\nEnter customer Email Id:");
			String email=sc.next();
			System.out.println("\nEnter customer birth date:");
			String d = sc.next();
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
				try {
					Date custDob = sdf.parse(d);
					customer.setCustDob(custDob);
					
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			//customer.setId(Id);
			customer.setName(name);
			customer.setPhone(phone);
			customer.setEmail(email);
			
			service.addCustomer(customer);   //passing bean object to service layer using service layer object
			System.out.println("Customer data added successfully");
			break;
			
			case 2:
			//Displaying whole table(All customer details)
			System.out.println("************Listing All Customer*************");
			for(CustomerBean customer1:service.getAllCustomer()) {
				System.out.println(customer1);
			}
			break;
			
			
			case 3:
			//at this breakpoint, we are retrieving single row having entered ID(Primary key)
				
					System.out.println("\nEnter customer ID:");
					int Id1=sc.nextInt();
					customer = service.findCustomerById(Id1);
			        System.out.println(customer);
					//System.out.print("ID:"+customer.getId());
					//System.out.println("\nName:"+customer.getName());
			break;	
				
			case 4:
			//at this breakpoint, we have updated record added in first section	
				List<CustomerBean> idList= service.getCustomerIds();
					
				System.out.println("\nEnter customer ID between "+idList.get(0)+" and "+idList.get(idList.size() - 1));
					
					int Id2=sc.nextInt();
					customer = service.findCustomerById(Id2);
					System.out.println("Enter new name");
					String newName=sc.next();
					customer.setName(newName);
					service.updateCustomer(customer);
					System.out.println("Name updated");
			        System.out.println(customer);
			break;
			
			case 5:
			//Retrieving single row having entered mobile number	
					
					System.out.println("\nEnter mobile number:");
					int phone1=sc.nextInt();
					customer= service.getCustomerByPhone(phone1);
					System.out.println(customer);
				
			break;
			
			case 6:
			//Retrieving multiple row having entered mobile number		
					System.out.println("\nEnter mobile number:");
					int phone2=sc.nextInt();
					List<CustomerBean> list= service.getCustomerByPhone1(phone2);
					for(CustomerBean out:list)
					{
						System.out.println("ID:"+out.getId());
						System.out.println("Name:"+out.getName());
					}
					
			break;	
			
			case 7:
			//at this breakpoint, record is removed from table
					System.out.println("\nEnter customer ID:");
					int Id3=sc.nextInt();
					customer = service.findCustomerById(Id3);
					service.removeCustomer(customer);
					System.out.println("Customer details removed");
			break;
			}
		}	
	}
}
