package com.shiblee.Asynchronouscoding.ForkJoin;

import org.apache.commons.lang3.time.StopWatch;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class DatasetUsingFork extends RecursiveTask<List<Integer>> {
    private List<String> inputlist;

    public DatasetUsingFork(List<String> inputlist) {
        this.inputlist = inputlist;
    }

    public static  void main(String[ ]ars){

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        List<String> input = new ArrayList<>(List.of("Shiblee","Orthee","Jannat","Ferdous","Mir","AbuHuraira","MirMdAbu"));
        DatasetUsingFork datafork = new DatasetUsingFork(input);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
       List <Integer> resultList = forkJoinPool.invoke(datafork);
          stopWatch.stop();
          System.out.println(stopWatch.getTime());
        System.out.println(resultList);
    }


    @Override
    protected List<Integer> compute() {

        // if the size is smaller enough then add it

        if(inputlist.size() <= 1) {
            List<Integer> finalresult = new ArrayList<>();

            inputlist.forEach(s ->

             finalresult.add(s.length() ));
            return finalresult;

        }

        // find the mid point of the task
        int midpoint = inputlist.size()/2;

        // divide the tasl into two sub task using the class extends recursive task
        DatasetUsingFork leftTask = new DatasetUsingFork(inputlist.subList(0, midpoint));
        DatasetUsingFork rightTask = new DatasetUsingFork(inputlist.subList(midpoint,inputlist.size()));

        // now fork the left side and put into another thread
          ForkJoinTask <List<Integer>> leftTaskFork =  leftTask.fork();
        // now do the right task mannually
        // Incorrect recursive call fixed
        List<Integer> rightTaskresult = rightTask.compute();


        // the left task is joining
        List<Integer> leftresult = leftTaskFork.join();
        leftresult.addAll(rightTaskresult);
        return leftresult;

    }
}
