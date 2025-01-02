package org.javaproject.dao;

import org.javaproject.models.Product;
import org.javaproject.models.ProductV1;

import java.util.ArrayList;
import java.util.List;

public class ProductImpl implements  ProductDAO{
    List<Product> productList;
    List<ProductV1> productV1List;
    public ProductImpl(){
        productList = new ArrayList<>();
        productV1List = new ArrayList<>();
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

    @Override
    public ProductV1 addProductV1(ProductV1 product) {
        this.productV1List.add(product);
        return product;
    }

    @Override
    public List<ProductV1> getAllProductV1() {
        return productV1List;
    }
}
