package com.shiblee.Asynchronouscoding.Service;
import com.shiblee.Asynchronouscoding.Model.Review;
public class ReviewServiceinfo {
    public Review retriveReview (Integer productId ) throws InterruptedException {
        Thread.sleep(1000);
        return new Review(2,3.4);
    }
}
