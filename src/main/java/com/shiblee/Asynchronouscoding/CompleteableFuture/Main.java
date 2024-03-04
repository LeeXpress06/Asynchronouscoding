package com.shiblee.Asynchronouscoding.CompleteableFuture;

import java.util.concurrent.CompletableFuture;

public class Main {

    public static void main(String[] args) {

        HelloWorldService helloWorldService = new HelloWorldService();

        CompletableFuture.supplyAsync(( ) ->
                 helloWorldService.helloWorld()
                ).thenAccept(
                        s -> System.out.println("s")
        ).join();

        System.out.println("this willl be done here");


    }
}
