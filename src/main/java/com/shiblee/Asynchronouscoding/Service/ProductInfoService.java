package com.shiblee.Asynchronouscoding.Service;


import com.shiblee.Asynchronouscoding.Model.ProductInfo;
import com.shiblee.Asynchronouscoding.Model.ProductOption;


import java.util.List;



public class ProductInfoService {

    public ProductInfo getProductInfo(Integer productId) throws InterruptedException {

        Thread.sleep(1000);

        List<ProductOption> productOptions = List.of( new ProductOption(1,"Green",
                        78.98,"Large"),
                new ProductOption(2, "Black", 34.23, "Small"));

        return ProductInfo.builder()
                .productId(productId)
                .productOptions(productOptions)
                .build();
    }

}
