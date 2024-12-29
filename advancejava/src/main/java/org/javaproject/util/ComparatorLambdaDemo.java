package org.javaproject.util;

import com.github.javafaker.Faker;
import org.javaproject.dao.ProductDAO;
import org.javaproject.dao.ProductImpl;
import org.javaproject.models.Product;

import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class ComparatorLambdaDemo {

    public static void main(String[] args){

        ProductDAO productDAO =new ProductImpl();
        for(int i =0;i<100;i++){
            productDAO.addProduct(createProduct());
        }

        // how to Compare without stream
//        Comparator<Product> comparetor = (val1, val2) ->{
//            if(val1.getCost() > val2.getCost())
//                return 1;
//            else if(val1.getCost() < val2.getCost()){
//                return -1;
//            }
//            else return 0;
//        };
//        productDAO.getAllProduct().sort(comparetor.reversed());
//        for(Product product : productDAO.getAllProduct()){
//            System.out.println(product);
//        }

        // Using stream for comparision one way
//        List<Product> productList = productDAO.getAllProduct().stream()
//                .sorted(Comparator.comparingDouble(Product::getCost)).collect(Collectors.toList());
//        productList.forEach(product -> System.out.println(product));

        //// Using stream for comparision another way
        productDAO.getAllProduct().stream()
                .sorted((a,b)-> {
                    if(a.getCost()>b.getCost())
                        return -1;
                    if(a.getCost()<b.getCost())
                        return 1;
                    else return 0;

                }).forEach(System.out::println);

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
