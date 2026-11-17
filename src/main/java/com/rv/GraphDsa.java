package com.rv;

import com.rv.infosys.LRUCache;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class GraphDsa {

    public static void  main(String args[]) {

        ExecutorService executor = Executors.newFixedThreadPool(2);

        for ( int i = 0; i < 5; i++) {
            final int taskId = i;

            executor.submit(() -> {
                String threadName = Thread.currentThread().getName();
                System.out.println("TaskId: " + taskId + " started execution on ThreadName: " + threadName);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        executor.shutdown();
    }


}
