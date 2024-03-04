package com.shiblee.Asynchronouscoding.CheckOutService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    private Long itemId;
    private int number;
    private int price;
    private boolean isExpired;

}
