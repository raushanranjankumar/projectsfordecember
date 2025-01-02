package org.javaproject.dao;

import org.javaproject.models.Product;
import org.javaproject.models.ProductV1;

import java.util.List;

public interface ProductDAO {
    Product addProduct(Product product);
    List<Product> getAllProduct();
    ProductV1 addProductV1(ProductV1 product);
    List<ProductV1> getAllProductV1();
}
