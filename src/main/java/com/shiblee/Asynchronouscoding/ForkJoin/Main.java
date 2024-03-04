package com.shiblee.Asynchronouscoding.ForkJoin;

import org.apache.commons.lang3.time.StopWatch;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ForkJoinPool;

public class Main {

    public static  void main(String[] args) throws InterruptedException {

        // establishing a list to prepare a recursive task
        List<Integer> inputlist = Arrays.asList(1,2,34,23,21,24,45,54);

        StopWatch stopWatch = new StopWatch();
        StopWatch stopWatch1 = new StopWatch();
        stopWatch.start();

        Integer sum = inputlist.stream().reduce(0, Integer::sum);
        Thread.sleep(1000);
        stopWatch.stop();

        System.out.println("Time taken : " +  stopWatch.getTime() + " The result is " + sum);

        stopWatch1.start();
        ForkJoinPool pool = new ForkJoinPool();
        ForkSum task = new ForkSum(inputlist);
        Integer result = pool.invoke(task);
        stopWatch1.stop();
        System.out.print( "The result : " + result + "Time : " + stopWatch1.getTime());



    }


}
