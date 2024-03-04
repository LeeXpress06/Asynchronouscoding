package com.shiblee.Asynchronouscoding.CheckOutService;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Cart {

    private Long cartId;
    private List<Item> itemList;

    public Cart(Long cartId, List<Item> itemList) {
        this.cartId = cartId;
        this.itemList = itemList;
    }
}
