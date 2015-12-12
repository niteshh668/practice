package com.eshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eshop.dao.Customer;
import com.eshop.dao.CustomerDAO;
import com.eshop.dao.CustomerDAOJDBCImpl;

@Service
public class CustomersService {
	@Autowired
	private CustomerDAO dao;

	public List<Customer> getCustomers() {

		List<Customer> customers = dao.getAllCustomers();
		return customers;

	}
}
