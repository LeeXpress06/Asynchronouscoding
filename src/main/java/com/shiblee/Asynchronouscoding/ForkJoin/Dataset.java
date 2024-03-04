package com.shiblee.Asynchronouscoding.ForkJoin;

import org.apache.commons.lang3.time.StopWatch;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class Dataset {

    public static  void main(String[ ]ars){

        StopWatch stopWatch = new StopWatch();

        stopWatch.start();
        List<Integer> result = new ArrayList<>();
        List<String> input = new ArrayList<>(List.of("Shiblee","Orthee","Jannat","Ferdous","Mir","AbuHuraira","MirMdAbu"));

          input.forEach(
                  s -> {
                  Integer m =    s.length();
                      result.add(m);
                  }
          );
          stopWatch.stop();
          System.out.println(stopWatch.getTime());
        System.out.println(result);

    }




}
