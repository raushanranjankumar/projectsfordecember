package org.javaproject.util;

import com.github.javafaker.Faker;
import lombok.extern.slf4j.Slf4j;
import org.javaproject.dao.CartDAO;
import org.javaproject.dao.ProductDAO;
import org.javaproject.dao.ProductImpl;
import org.javaproject.models.Product;

import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;
@Slf4j
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

        //input product and discount and results would be the final price

        BiFunction<Product,Double,Double> biFunction = ((product, discount) -> {
            return product.getCost() - product.getCost()*discount;

        });
        Faker faker = new Faker();
        System.out.println(biFunction.apply(
        new Product(faker.random().nextLong(10000),
                faker.food().fruit().toLowerCase(),
                faker.random().nextInt(10000),
                faker.food().measurement(),
                Double.parseDouble(faker.commerce().price())),0.5));

        //Compare product1 unit with product2 unit and say they are same or not

        BiFunction<Product,Product,Boolean> biFunction1  = ((product, product2) -> {
            return product.getUnit().equals(product2.getUnit());
        });
System.out.println("Compare product1 unit with product2 unit and say they are same or not .......................");
        System.out.println(biFunction1.apply(new Product(faker.random().nextLong(10000),
                faker.food().fruit().toLowerCase(),
                faker.random().nextInt(10000),
                faker.food().measurement(),
                Double.parseDouble(faker.commerce().price())),
                new Product(faker.random().nextLong(10000),
                        faker.food().fruit().toLowerCase(),
                        faker.random().nextInt(10000),
                        faker.food().measurement(),
                        Double.parseDouble(faker.commerce().price()))));


        System.out.println("Supplier create the instance");
        Supplier<Product> supplier = Product::new;
        System.out.println(supplier.get().getProductId());

        System.out.println("Generate the OTP to confirm the cart");
        Supplier<Integer> supplier1 = CartDAO::generateOTP;
        System.out.println("OTP :: "+supplier1.get());

        System.out.println("Consumer is the product");
        Consumer<Product> consumer = (product) ->{
            if(product.getCost() > 10){
                System.out.println("High Cost");
                log.info("Logger:: HIgh Costly");
            }
        };
        consumer.accept(new Product(faker.random().nextLong(10000),
                faker.food().fruit().toLowerCase(),
                faker.random().nextInt(10000),
                faker.food().measurement(),
                Double.parseDouble(faker.commerce().price())));
        Product productInstace = new Product(faker.random().nextLong(10000),
                faker.food().fruit().toLowerCase(),
                faker.random().nextInt(10000),
                faker.food().measurement(),
                Double.parseDouble(faker.commerce().price()));
System.out.println("Predicate");
        Predicate<Product> productPredicate = (product)->{
            return product.getName().startsWith("a");
        };
        log.info(" "+productPredicate.test(productInstace));
        log.info("Apply BiPredicate for if cost value for two product are same");
        BiPredicate<Product,Product> biPredicate = (product1, product2)->{
            return product1.getCost() == product2.getCost();
        };
        log.info("Comapring products with the prices:: "+biPredicate.test(productInstace,productInstace));
    }





}
