package org.javaproject.util;

import com.github.javafaker.Faker;
import org.javaproject.dao.ProductDAO;
import org.javaproject.dao.ProductImpl;
import org.javaproject.models.Product;

import java.util.Comparator;
import java.util.Locale;

public class ComparatorLambdaDemo {

    public static void main(String[] args){

        ProductDAO productDAO =new ProductImpl();
        for(int i =0;i<100;i++){
            productDAO.addProduct(createProduct());
        }

        // how to Compare without stream
        Comparator<Product> comparetor = (val1, val2) ->{
            if(val1.getCost() > val2.getCost())
                return 1;
            else if(val1.getCost() < val2.getCost()){
                return -1;
            }
            else return 0;
        };
        productDAO.getAllProduct().sort(comparetor.reversed());
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
