package org.javaproject.util;

import org.javaproject.dao.ProductDAO;
import org.javaproject.dao.ProductImpl;
import org.javaproject.models.Product;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class BuiltInFunctionalInterfaces {
    public static void main(String[] args){
        ProductDAO productDAO = new ProductImpl();
        for(int i =0;i<100;i++)
            productDAO.addProduct(ComparatorLambdaDemo.createProduct());
//Using stream to filter those product which has the cost between 5$ to 10$
//        productDAO.getAllProduct().stream()
//                .filter(cost->cost.getCost()>5 && cost.getCost()<10)
//                .forEach(System.out::println);

        //Filter product >10& using function

//        Function<List<Product>,List<String>> function= (productList)->{
//            return productList.stream()
//                    .filter(cost->cost.getCost()>10)
//                    .map(t->t.getName())
//                    .collect(Collectors.toList());
//        };
        //find the list of product that starts with 'b'

        Function<List<Product>, List<String>> function = productList -> {
            return productList.stream()
                    .filter(str->str.getName().startsWith("b"))
                    .map(str->str.getName())
                    .collect(Collectors.toList());
        };
        //invoke the function
        function.apply(productDAO.getAllProduct()).stream().forEach(System.out::println);
    }

}
