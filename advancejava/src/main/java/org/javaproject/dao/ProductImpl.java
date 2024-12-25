package org.javaproject.dao;

import org.javaproject.models.Product;

import java.util.List;

public class ProductImpl implements  ProductDAO{
    @Override
    public Product addProduct(Product product) {
        return null;
    }

    @Override
    public List<Product> getAllProduct() {
        return List.of();
    }
}
