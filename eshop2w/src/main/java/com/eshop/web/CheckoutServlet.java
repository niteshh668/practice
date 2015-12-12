package com.eshop.web;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.eshop.dao.Order;
import com.eshop.dao.OrderDAOJDBCImpl;
import com.eshop.dao.OrdersDAO;
import com.eshop.dao.Product;

/**
 * Servlet implementation class CheckoutServlet
 */
public class CheckoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CheckoutServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		List<Product> products = (List<Product>) session.getAttribute("ShoppingCart");
		String orderNumber = UUID.randomUUID().toString();

		double orderAmount = getOrderAmount(products);
		session.removeAttribute("ShoppingCart");
		Order o = new Order(1, orderNumber, new Date(), orderAmount, products);
		OrdersDAO dao = new OrderDAOJDBCImpl();
		dao.createOrder(101, o);
		request.setAttribute("onum", o);

		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/order_confirmation.jsp");
		rd.forward(request, response);
	}

	private double getOrderAmount(List<Product> products) {
		// TODO Auto-generated method stub
		double sum = 0.0;
		for (Product product : products) {
			sum = sum + product.getPrice();
		}
		return sum;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
