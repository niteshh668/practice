package com.eshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eshop.dao.Product;
import com.eshop.dao.ProductDAOJDBCImpl;
import com.eshop.dao.ProductsDAO;

@Service
public class ProductsService {
	@Autowired
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
