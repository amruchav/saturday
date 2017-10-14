##Please run the below DDL query before you execute this application.  

CREATE TABLE students
(studentid NUMBER(6) PRIMARY KEY,
name VARCHAR2(25));


create table Customer(cust_id number primary key,
					  custname varchar2(20),
					  cust_phone number,
					  cust_email varchar2(20),
					  DOB Date);