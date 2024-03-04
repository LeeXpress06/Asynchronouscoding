package com.shiblee.Asynchronouscoding.Service;

import com.shiblee.Asynchronouscoding.Model.Product;
import com.shiblee.Asynchronouscoding.Model.ProductInfo;
import com.shiblee.Asynchronouscoding.Model.Review;
import org.apache.commons.lang3.time.StopWatch;

import java.sql.SQLOutput;

public class ProductService {

    private ProductInfoService productInfoService;
    private ReviewServiceinfo reviewServiceinfo;


    public ProductService(ProductInfoService productInfoService, ReviewServiceinfo reviewServiceinfo) {
        this.productInfoService = productInfoService;
        this.reviewServiceinfo = reviewServiceinfo;

    }

    public Product retrieveProduct( Integer productId) throws InterruptedException {
        StopWatch stopWatch = new StopWatch();

        stopWatch.start();

        ProductInfo productinfo = productInfoService.getProductInfo(productId);
        Review reviewSinfo =  reviewServiceinfo.retriveReview(productId);
        stopWatch.stop();
       System.out.println( stopWatch.getTime());
       return new Product(productId,productinfo, reviewSinfo);
    }

    public static void main(String[ ]args) throws InterruptedException {
        ProductInfoService productInfoService = new ProductInfoService();
        ReviewServiceinfo reviewServiceinfo = new ReviewServiceinfo();
        ProductService productService = new ProductService(productInfoService,reviewServiceinfo);
        Product product = productService.retrieveProduct(1);
        System.out.println(product);



    }







}
