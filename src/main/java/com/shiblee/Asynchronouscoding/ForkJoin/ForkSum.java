package com.shiblee.Asynchronouscoding.ForkJoin;

import java.util.List;
import java.util.concurrent.RecursiveTask;

public class ForkSum extends RecursiveTask<Integer> {
      private List<Integer> sumlist;

    public ForkSum(List<Integer> sumlist) {
        this.sumlist = sumlist;
    }

    @Override
    protected Integer compute() {

        if( sumlist.size() >=2){
            Integer sum = 0;
            return sumlist.stream().mapToInt(Integer::intValue).sum();   //this is providing the data in right side

        }

        int m = sumlist.size()/2;
        List<Integer> leftlist = sumlist.subList(0, m);
        List<Integer>rightlist = sumlist.subList(m, sumlist.size());

        ForkSum left = new ForkSum(leftlist);
        ForkSum right = new ForkSum(rightlist);

        left.fork();

        Integer rightResult = right.compute();   // it will get the data from if statement

        Integer leftResult = left.join();

        return rightResult + leftResult;
    }



}
