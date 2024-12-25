package org.javaproject.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private long productId;
    private String name;
    private int qty;
    private long unit;
    private long cost;

}
