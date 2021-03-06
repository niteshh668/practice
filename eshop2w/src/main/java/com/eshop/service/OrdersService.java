package com.eshop.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eshop.dao.Order;
import com.eshop.dao.OrderDAOJDBCImpl;
import com.eshop.dao.OrdersDAO;

import oracle.sql.DATE;

@Service
public class OrdersService {
	@Autowired
	OrdersDAO dao;

	public void placeOrder(int customerId, Order order) {

		dao.createOrder(customerId, order);
	}

	public List<Order> getOrdersForTheMonth(int customerId) {
		List<Order> orders = new ArrayList<Order>();
		orders = dao.getOrdersForCustomer(customerId);
		List<Order> ordersForTheMonth = new ArrayList<Order>();
		int currentMonth = new Date().getMonth();
		for (Order order : ordersForTheMonth) {
			if (order.getOrderDate().getMonth() == currentMonth) {
				ordersForTheMonth.add(order);
			}
		}
		return ordersForTheMonth;
	}

	public List<Order> getOrders(int customerId) {
		List<Order> orders = new ArrayList<Order>();
		orders = dao.getOrdersForCustomer(customerId);
		return orders;
	}

}
