package org.javaproject.util;

import lombok.extern.slf4j.Slf4j;
import org.javaproject.dao.ProductDAO;
import org.javaproject.dao.ProductImpl;
import org.javaproject.models.Product;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
public class StreamCollectorsDemo {
    public static void main(String[] args){
        log.info("Create hashMap product that contains only ID and Names from List of product::");
        ProductDAO productDAO = new ProductImpl();
        for(int i=0;i<100;i++){
            productDAO.addProduct(ComparatorLambdaDemo.createProduct());
        }
        Map<Long,String> map = productDAO.getAllProduct()
                .stream().collect(Collectors.toMap(x->x.getProductId(),y->y.getName()));
        System.out.println("\n"+map);
        //Try with entryset

        map.entrySet().stream()
                .forEach(key-> System.out.println(key.getKey()+ " : "+key.getValue()));

    }
}
