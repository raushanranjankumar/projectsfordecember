package org.javaproject.dao;

import org.javaproject.models.Product;

import java.util.List;

public interface ProductDAO {
    Product addProduct(Product product);
    List<Product> getAllProduct();
}
