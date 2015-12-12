package com.eshop.service;

import java.util.List;

import com.eshop.dao.Customer;
import com.eshop.dao.CustomerDAO;
import com.eshop.dao.CustomerDAOJDBCImpl;

public class CustomersService {
public List<Customer> getCustomers()
{
	CustomerDAO dao= new  CustomerDAOJDBCImpl();
	List<Customer> customers = dao.getAllCustomers();
	return customers;
	
}
}
