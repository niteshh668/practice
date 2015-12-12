package com.eshop.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductDAOTest {
public static void main(String[] args) {
	//ProductsDAO dao = new ProductDAOJDBCImpl();
	/*List<Product> product= dao.getByOrderId(101);
	for (Product product2 : product) {
		System.out.println(product2.getId());
		
		List<Product> p = dao.getAllProducts();
	for (Product product : p) {
		System.out.println(product.getId()+ "   ");
	}
	}
	Product p = dao.findByPrimaryKey(5);
	System.out.println(p.getName());
	OrdersDAO dao = new OrderDAOJDBCImpl();
	List<Product> products= new ArrayList<>();
	Product p1 = new Product(1, "Books", "Gone with the wind", 26.72);
	Product p2 = new Product(2, "Books", "Spring in Action", 32.29);
	products.add(p1);
	products.add(p2);
	Order o1 = new Order(1, "A4", new Date(), 56.0, products);
	dao.createOrder(101, o1);
	
	*/
	OrdersDAO dao = new OrderDAOJDBCImpl();
	List<Order> orders =dao.getOrdersForCustomer(100);
	for (Order order : orders) {
		System.out.println(order.getProducts().toString());
	}
}
}
