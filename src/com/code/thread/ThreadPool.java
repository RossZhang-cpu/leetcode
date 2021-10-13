package com.code.thread;

import java.util.concurrent.*;
import java.util.logging.Logger;

public class ThreadPool {

//    private Logger log = new Logger("this.getClass()");

    private static final int CORE_POOL_SIZE = 5;
    private static final int MAX_POOL_SIZE = 10;
    private static final int QUEUE_CAPACITY = 100;
    private static final Long KEEP_ALIVE_TIME = 1L;



    public static void main(String[] args) {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(CORE_POOL_SIZE, MAX_POOL_SIZE, KEEP_ALIVE_TIME, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(QUEUE_CAPACITY),
                new ThreadPoolExecutor.CallerRunsPolicy());
//        pool.execute();
//        pool.submit()
    }


    public void shchedulePrint(){
        //ScheduledExecutorService scheduledExecutorService = new ScheduledThreadPoolExecutor(1, //createThreadFactory("print-thread-pool-status", false));
        //scheduledExecutorService.scheduleAtFixedRate(() -> {
//            log.info("=========================");
//            log.info("ThreadPool Size: [{}]", threadPool.getPoolSize());
//            log.info("Active Threads: {}", threadPool.getActiveCount());
//            log.info("Number of Tasks : {}", threadPool.getCompletedTaskCount());
//            log.info("Number of Tasks in Queue: {}", threadPool.getQueue().size());
//            log.info("=========================");
   //     }, 0, 1, TimeUnit.SECONDS);

    }
}
