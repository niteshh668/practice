package com.eshop.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.eshop.dao.Product;
import com.eshop.dao.ProductDAOJDBCImpl;
import com.eshop.dao.ProductsDAO;
import com.eshop.service.ProductsService;

/**
 * Servlet implementation class ShoppingCartServlet
 */
public class ShoppingCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShoppingCartServlet() {
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
		int id = Integer.parseInt(request.getParameter("productId"));
		HttpSession session = request.getSession();
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		ProductsService service = context.getBean(ProductsService.class);
		Product product = service.getById(id);
		if ((session.getAttribute("ShoppingCart")) == null) {
			List<Product> products = new ArrayList<Product>();
			products.add(product);
			session.setAttribute("ShoppingCart", products);
		} else {
			List<Product> products = (List<Product>) session.getAttribute("ShoppingCart");
			products.add(product);
			// session.setAttribute("ShoppingCart", products);
		}
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/shopping_cart.jsp");
		rd.forward(request, response);
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
