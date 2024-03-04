package com.shiblee.Asynchronouscoding.ExcutorService;

import com.shiblee.Asynchronouscoding.Model.Product;
import com.shiblee.Asynchronouscoding.Model.ProductInfo;
import com.shiblee.Asynchronouscoding.Model.Review;
import com.shiblee.Asynchronouscoding.Service.ProductInfoService;
import com.shiblee.Asynchronouscoding.Service.ReviewServiceinfo;
import org.apache.commons.lang3.time.StopWatch;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ProductServiceExcutor {

    private ProductInfoService productInfoService;
    private ReviewServiceinfo reviewServiceinfo;
    // excutor service is an interface and we can get an implementation of its
    static ExecutorService excutorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());


    public ProductServiceExcutor(ProductInfoService productInfoService, ReviewServiceinfo reviewServiceinfo) {
        this.productInfoService = productInfoService;
        this.reviewServiceinfo = reviewServiceinfo;

    }

    public Product retrieveProduct( Integer productId) throws InterruptedException, ExecutionException {
        StopWatch stopWatch = new StopWatch();
        // stop watch start
        stopWatch.start();
         Future<ProductInfo> productInfoFuture = excutorService.submit(() -> productInfoService.getProductInfo(productId) );
        Future<Review> reviewFuture = excutorService.submit(( )->reviewServiceinfo.retriveReview(productId));
        // they will return the future


        ProductInfo productinfo = productInfoFuture.get();
        Review reviewinfo = reviewFuture.get();
        // then convert future into actual object
        stopWatch.stop();
       System.out.println( stopWatch.getTime());
       return new Product(productId,productinfo, reviewinfo);
    }

    public static void main(String[ ]args) throws InterruptedException, ExecutionException {
        ProductInfoService productInfoService = new ProductInfoService();
        ReviewServiceinfo reviewServiceinfo = new ReviewServiceinfo();
        ProductServiceExcutor productService = new ProductServiceExcutor(productInfoService,reviewServiceinfo);
        Product product = productService.retrieveProduct(1);
        System.out.println(product);
        excutorService.shutdown();
    }







}
