package com.shiblee.Asynchronouscoding.ForkJoin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class BookListFork extends RecursiveTask<List<Integer>> {
     private List<String>booklist;
    public BookListFork(List<String> booklist) {
        this.booklist = booklist;
    }

      // here this recursive class will handle computaton
    @Override
    protected List<Integer> compute() {

        int midPoint = booklist.size()/2;

        // break the recursive the task
        if(booklist.size()>=1){

            List<Integer> resultfinal = new ArrayList<>();
             booklist.forEach(
                     s -> resultfinal.add(s.length())
             );
            return resultfinal;
        }

        // divided the recursive task into two points

        BookListFork left = new BookListFork(booklist.subList(0, midPoint));
        BookListFork right = new BookListFork(booklist.subList(midPoint,booklist.size()));

       ForkJoinTask<List<Integer>> leftforktask =    left.fork();
        List<Integer> rightresult  =   right.compute();
        List<Integer> leftresult = leftforktask.join();

        leftresult.addAll(rightresult);

        return leftresult;

    }


    // Main class

    public static void main(String[] args) {
        List<String> booklist = Arrays.asList("Quran","Hadith","FiqhOrLaw","Science","History","Physics");
        // now give the input to Recursive task class
        BookListFork bookListFork = new BookListFork(booklist);

        // now start the process
        ForkJoinPool pool = new ForkJoinPool();
        List<Integer> wordCount = pool.invoke(bookListFork);

        System.out.println(wordCount);



    }

}
