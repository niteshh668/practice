package com.eshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOJDBCImpl extends BaseDAO implements ProductsDAO {

	@Override
	public List<Product> getByOrderId(int orderId) throws DAOException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Product> products = new ArrayList<Product>();
		try {
			conn = getConnection();
			String sql = "select p.PRODUCT_ID,p.PRODUCT_TYPE,p.PRODUCT_NAME,p.PRICE from PRODUCTs p, ORDER_DETAILS od where p.PRODUCT_ID=od.PRODUCT_ID and order_id=?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, orderId);
			rs = stmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("PRODUCT_ID");
				String type = rs.getString("PRODUCT_TYPE");
				String name = rs.getString("PRODUCT_NAME");
				double price = rs.getDouble("PRICE");
				Product p = new Product(id, type, name, price);
				products.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DAOException("This is a new error from retriving products from an orderID ", e);
		} finally {
			closeResources(rs, stmt, conn);
		}
		return products;
	}

	@Override
	public List<Product> getAllProducts() throws DAOException {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<Product> products = new ArrayList<Product>();
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from products");
			while (rs.next()) {
				int id = rs.getInt("PRODUCT_ID");
				String type = rs.getString("PRODUCT_TYPE");
				String name = rs.getString("PRODUCT_NAME");
				double price = rs.getDouble("PRICE");
				Product p = new Product(id, type, name, price);
				products.add(p);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DAOException("This is a new error from selcting ", e);
		} finally {
			closeResources(rs, stmt, conn);
		}

		return products;
	}

	@Override
	public Product findByPrimaryKey(int productId) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Product p = null;
		try {
			String sql = "select * from products where PRODUCT_ID=?";
			conn = getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, productId);
			rs = stmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("PRODUCT_ID");
				String type = rs.getString("PRODUCT_TYPE");
				String name = rs.getString("PRODUCT_NAME");
				double price = rs.getDouble("PRICE");
				p = new Product(id, type, name, price);
				
			}
		} catch (SQLException exp) {
			exp.printStackTrace();
			throw new DAOException("this is a exp from retriveing one customer by primary key", exp);
		} finally {
			closeResources(rs, stmt, conn);
		}
		return p;
	}

}
