package com.eshop.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.jdt.internal.compiler.ast.ThrowStatement;

public class OrderDAOJDBCImpl extends BaseDAO implements OrdersDAO {

	@Override
	public void createOrder(int customerId, Order order) throws DAOException {

		Connection conn = null;
		PreparedStatement stmt = null, stmt2 = null;
		ResultSet rs = null;
		int orderId=0;
		try {
			orderId = getNextSequenceValue("orders_seq");
			conn = getConnection();
			String sql = "insert into orders values (?,?,?,?,?)";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, orderId);
			stmt.setInt(2, customerId);
			stmt.setString(3, order.getOrderNumber());
			stmt.setDate(4, new Date(order.getOrderDate().getTime()));
			stmt.setDouble(5, order.getOrderAmount());
			int rowsInserted = stmt.executeUpdate();
			System.out.println("no of rows inserted " + rowsInserted);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DAOException("This is a new error from inserting a order into orders ", e);
		} finally {
			closeResources(rs, stmt, conn);
		}
		insertIntoOrderDetails(orderId, order);
	}
	private void insertIntoOrderDetails(int orderId, Order order) throws DAOException
	{
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn=getConnection();
			String sql = "insert into order_details values (order_details_seq.nextval,?,?)";
			List<Product> products = order.getProducts();
			for (Product product : products) {
				
				stmt = conn.prepareStatement(sql);
				stmt.setInt(1, orderId);
				stmt.setInt(2, product.getId());
				stmt.executeUpdate();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DAOException("This is a new error from inserting a order into orders_details ", e);
		} finally {
			closeResources(rs, stmt, conn);
		}
	}
	@Override
	public List<Order> getOrdersForCustomer(int customerId) throws DAOException {
		// TODO Auto-generated method stub

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Order> orders = new ArrayList<Order>();
		try {
			
			conn = getConnection();
			String sql = "select * from orders where CUSTOMER_ID=?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, customerId);
			rs = stmt.executeQuery();
			while (rs.next()) {
				
				int id = rs.getInt("ORDER_ID");
				String orderNum = rs.getString("ORDER_NUMBER");
				Date d =rs.getDate("ORDER_DATE");
				double amount = rs.getDouble("ORDER_AMOUNT");
				ProductsDAO pdao = new ProductDAOJDBCImpl();
				List<Product> products = pdao.getByOrderId(id);
				Order o =  new Order(id, orderNum, d, amount, products);
				orders.add(o);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DAOException("This is a new error from inserting a order into orders ", e);
		} finally {
			closeResources(rs, stmt, conn);
		}
		return orders;
	}

}
