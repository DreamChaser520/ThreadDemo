package com.zh.service;

import java.util.concurrent.*;

public class MyThreadExecutor {
    int corePoolSize = 10;    // 线程池的基本大小
    int maximumPoolSize = 30;  // 线程池最大大小
    int keepAliveTime = 10;  // 线程存活保持时间
    ThreadPoolExecutor executor = new ThreadPoolExecutor(
            corePoolSize,
            maximumPoolSize,
            keepAliveTime,
            TimeUnit.SECONDS,
            new LinkedBlockingQueue<>()
    );

    /**
     * 多线程-获取返回结果
     *
     * @param task 需要运行的任务
     * @param <T>  Future<T>用于取得任务的返回结果
     * @return 可以用 future.get() 方法读取
     */
    public <T> Future<T> submit(Callable<T> task) {
        return executor.submit(task);
    }

}