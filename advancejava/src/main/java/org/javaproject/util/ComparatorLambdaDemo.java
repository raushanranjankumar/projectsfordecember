package org.javaproject.util;

import com.github.javafaker.Faker;
import org.javaproject.dao.ProductDAO;
import org.javaproject.dao.ProductImpl;
import org.javaproject.models.Product;

import java.util.Locale;

public class ComparatorLambdaDemo {

    public static void main(String[] args){

        ProductDAO productDAO =new ProductImpl();
        for(int i =0;i<100;i++){
            productDAO.addProduct(createProduct());
        }
        for(Product product : productDAO.getAllProduct()){
            System.out.println(product);
        }
    }
    static Product createProduct(){
        Faker faker = new Faker();
        return new Product(faker.random().nextLong(10000),
                faker.food().fruit().toLowerCase(),
                faker.random().nextInt(10000),
                faker.food().measurement(),
                Double.parseDouble(faker.commerce().price()));
    }
}
