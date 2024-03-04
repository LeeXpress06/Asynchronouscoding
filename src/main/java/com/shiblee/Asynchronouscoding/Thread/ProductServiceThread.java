package com.shiblee.Asynchronouscoding.Thread;

import com.shiblee.Asynchronouscoding.Model.Product;
import com.shiblee.Asynchronouscoding.Model.ProductInfo;
import com.shiblee.Asynchronouscoding.Model.Review;
import com.shiblee.Asynchronouscoding.Service.ProductInfoService;
import com.shiblee.Asynchronouscoding.Service.ReviewServiceinfo;
import org.apache.commons.lang3.time.StopWatch;

public class ProductServiceThread {

    private ProductInfoService productInfoService;
    private ReviewServiceinfo reviewServiceinfo;


    public ProductServiceThread(ProductInfoService productInfoService, ReviewServiceinfo reviewServiceinfo) {
        this.productInfoService = productInfoService;
        this.reviewServiceinfo = reviewServiceinfo;

    }

    public Product retrieveProduct(Integer productId) throws InterruptedException {
        StopWatch stopWatch = new StopWatch();

        ProductinfoRunnable productinfoRunnable = new ProductinfoRunnable(productId);
        ReviewinfoRunnable reviewinfoRunnable = new ReviewinfoRunnable(productId);


        Thread productinfoThread = new Thread(productinfoRunnable);
        Thread reviewinfoThread = new Thread(reviewinfoRunnable);

        stopWatch.start();
        productinfoThread.start();
        reviewinfoThread.start();

        productinfoThread.join();
        reviewinfoThread.join();

        stopWatch.stop();
        System.out.println(stopWatch.getTime());
        return new Product(productId,productinfoRunnable.getProductInfo(),reviewinfoRunnable.getReview());
    }

    public static void main(String[] args) throws InterruptedException {
        ProductInfoService productInfoService = new ProductInfoService();
        ReviewServiceinfo reviewServiceinfo = new ReviewServiceinfo();
        ProductServiceThread productService = new ProductServiceThread(productInfoService, reviewServiceinfo);
        Product product = productService.retrieveProduct(1);
        System.out.println(product);
    }

    private class ProductinfoRunnable implements Runnable {
        private ProductInfo productInfo;
        private Integer productId;
        public ProductinfoRunnable(Integer productId) {
            this.productId = productId;
        }

        public ProductInfo getProductInfo( ){
            return productInfo;
        }

        @Override
        public void run() {
            try {
                ProductInfo productInfo = productInfoService.getProductInfo(productId);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private class ReviewinfoRunnable implements Runnable {
        private Integer productid;
        private Review review;
        public ReviewinfoRunnable(Integer productId) {
            this.productid = productId;
        }

        public Review getReview( ){
            return review;
        }


        @Override
        public void run() {
           Review review;
            try {
                review = reviewServiceinfo.retriveReview(productid);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }


    }


}

