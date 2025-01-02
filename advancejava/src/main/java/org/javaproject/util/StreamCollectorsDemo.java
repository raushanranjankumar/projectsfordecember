package org.javaproject.util;

import com.github.javafaker.Faker;
import lombok.extern.slf4j.Slf4j;
import org.javaproject.dao.CustomerDAO;
import org.javaproject.dao.CustomerImpl;
import org.javaproject.dao.ProductDAO;
import org.javaproject.dao.ProductImpl;
import org.javaproject.models.Customer;
import org.javaproject.models.Location;
import org.javaproject.models.Product;
import org.javaproject.models.ProductV1;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

@Slf4j
public class StreamCollectorsDemo {
    public static void main(String[] args){
        log.info("Create hashMap product that contains only ID and Names from List of product::");
        ProductDAO productDAO = new ProductImpl();
        for(int i=0;i<100;i++){
            productDAO.addProduct(ComparatorLambdaDemo.createProduct());
        }
//        Map<Long,String> map = productDAO.getAllProduct()
//                .stream().collect(Collectors.toMap(x->x.getProductId(),y->y.getName()));
//        System.out.println("\n"+map);
//        //Try with entryset
//
//        map.entrySet().stream()
//                .forEach(key-> System.out.println(key.getKey()+ " : "+key.getValue()));

        //Product with letter 'a' and push to the Map
        System.out.println("Product with letter 'a' and push to the Map");

        Map<Long,String> map1 = productDAO.getAllProduct().stream()
                .filter(prodNmae-> prodNmae.getName().startsWith("a"))
                .collect(Collectors.toMap(x->x.getProductId(),y->y.getName()));
        map1.entrySet().stream().forEach(name->System.out.println(name.getKey()+" : "+name.getValue()));

        //group customer by category

        System.out.println("Group Product by Location");
        for(int i=0;i<100;i++){
            productDAO.addProductV1(createProduct());
        }
        Map<Location, List<ProductV1>> locationListMap = productDAO.getAllProductV1().stream()
                .collect(groupingBy(ProductV1::getLocation));
        locationListMap.entrySet().stream()
                .forEach(x->System.out.println(x.getKey()+" :: "+x.getValue()));


        System.out.println("Collecting and then");
        CustomerDAO customerDAO = new CustomerImpl();
        for(int i =0;i<102;i++){
            customerDAO.addCustomerDetails(createCustomer());
        }
//        for(Customer customer : customerDAO.getAllCustomer()){
//            System.out.println(customer);
//        }
        System.out.println("This is Key value pair of data");
        Map<String, Date> dateMap = customerDAO.getAllCustomer().stream()
                .collect(Collectors.toMap(name->name.getName(),date->date.getDob()));
        dateMap.entrySet().stream().forEach(name->System.out.println(name.getKey()+" :: "+name.getValue()));

        System.out.println("Group Customer by DOB");
        Map<Date,List<Customer>> listMap = customerDAO.getAllCustomer().stream()
                .collect(Collectors.groupingBy(Customer::getDob));
        listMap.entrySet().stream().forEach(date->System.out.println(date.getKey()+" :: "+date.getValue()));


    }

    static ProductV1 createProduct(){
        Faker faker = new Faker();
        return new ProductV1(faker.random().nextLong(10000),
                faker.food().fruit().toLowerCase(),
                faker.random().nextInt(10000),
                faker.food().measurement(),
                Double.parseDouble(faker.commerce().price()),
                new Location(faker.address().city(),faker.address().state()));
    }

    static Customer createCustomer(){
        Faker faker = new Faker();
        return new Customer(faker.name().firstName(),faker.date().birthday());
    }
}
