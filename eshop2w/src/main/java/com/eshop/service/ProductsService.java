package com.eshop.service;

import java.util.List;

import com.eshop.dao.Product;
import com.eshop.dao.ProductDAOJDBCImpl;
import com.eshop.dao.ProductsDAO;

public class ProductsService {
	ProductsDAO productsDAO;

	public Product getById(int productId) {
		return productsDAO.findByPrimaryKey(productId);
	}

	public List<Product> getAllProducts() {
		return productsDAO.getAllProducts();

	}

	public void setProductsDAO(ProductsDAO productsDAO) {
		this.productsDAO = productsDAO;
	}
	
}
