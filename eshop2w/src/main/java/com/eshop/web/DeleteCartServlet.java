package com.eshop.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.eshop.dao.Product;
import com.eshop.dao.ProductDAOJDBCImpl;
import com.eshop.dao.ProductsDAO;

/**
 * Servlet implementation class DeleteCartServlet
 */
public class DeleteCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteCartServlet() {
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
		ProductsDAO dao = new ProductDAOJDBCImpl();
		Product p = dao.findByPrimaryKey(id);
		if ((session.getAttribute("ShoppingCart")) != null) {
			List<Product> products = (List<Product>) session.getAttribute("ShoppingCart");
			products.remove(p);
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
