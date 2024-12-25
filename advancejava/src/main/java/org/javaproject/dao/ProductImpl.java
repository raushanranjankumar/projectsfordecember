package org.javaproject.dao;

import org.javaproject.models.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductImpl implements  ProductDAO{
    List<Product> productList;
    public ProductImpl(){
        productList = new ArrayList<>();
    }
    @Override
    public Product addProduct(Product product) {
        this.productList.add(product);
        return product;
    }

    @Override
    public List<Product> getAllProduct() {
        return productList;
    }
}
