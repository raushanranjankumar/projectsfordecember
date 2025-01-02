package org.javaproject.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductV1 {
    private long productId;
    private String name;
    private int qty;
    private String unit;
    private Double cost;
    private Location location;


}
