package com.zh.service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class TestService {

    static Object obj1 = new Object();
    static Object obj2 = new Object();

    public static void sleepTest() {
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static Map<String, String> deadLockTest() {
        AsyncService service = new AsyncService();

        MyThreadExecutor myThreadExecutor = new MyThreadExecutor();
        Future<String> f1 = myThreadExecutor.submit(() -> service.testMethod(true, obj1, obj2));
        Future<String> f2 = myThreadExecutor.submit(() -> service.testMethod(false, obj1, obj2));
        Future<String> f3 = myThreadExecutor.submit(() -> service.testMethod(true, obj1, obj2));
        HashMap<String, String> resultMap = new HashMap<>();

        long start = System.currentTimeMillis();
        try {
            resultMap.put("f1", f1.get());
            resultMap.put("f2", f2.get());
            resultMap.put("f3", f3.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("=============总耗时==========" + (end - start));
        return resultMap;
    }

    public static Map<String, String> multiThreadTest() {
        AsyncService service = new AsyncService();
        MyThreadExecutor myThreadExecutor = new MyThreadExecutor();
        Future<String> f1 = myThreadExecutor.submit(service::testMethod1);
        Future<String> f2 = myThreadExecutor.submit(service::testMethod2);
        Future<String> f3 = myThreadExecutor.submit(service::testMethod3);
        Future<String> f4 = myThreadExecutor.submit(service::testMethod4);
        Future<String> f5 = myThreadExecutor.submit(() -> service.testMethod5("n"));
        HashMap<String, String> resultMap = new HashMap<>();

        long start = System.currentTimeMillis();
        try {
            resultMap.put("f1", f1.get());
            resultMap.put("f2", f2.get());
            resultMap.put("f3", f3.get());
            resultMap.put("f4", f4.get());
            resultMap.put("fn", f5.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("=============总耗时==========" + (end - start));
        return resultMap;
    }
}
