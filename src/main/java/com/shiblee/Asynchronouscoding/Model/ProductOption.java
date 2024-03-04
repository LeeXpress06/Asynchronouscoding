package com.shiblee.Asynchronouscoding.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductOption {
    private Integer productOptionId;
    private String color;
    private double price;
    private String size;
    private Inventory inventory;

    public ProductOption(Integer productOptionId, String color, double price, String size) {
        this.productOptionId = productOptionId;
        this.color = color;
        this.price = price;
        this.size = size;
    }
}
