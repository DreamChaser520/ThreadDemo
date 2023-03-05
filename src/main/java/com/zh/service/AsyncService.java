package com.zh.service;

public class AsyncService {

    public String testMethod1() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("我是异步方法1");
        return "1";
    }

    public String testMethod2() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("我是异步方法2");
        return "2";
    }

    public String testMethod3() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("我是异步方法3");
        return "3";
    }

    public String testMethod4() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("我是异步方法4");
        return "4";
    }

    public String testMethod5(String n) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("我是异步方法" + n);
        return n;
    }

    public String testMethod(boolean flag, Object obj1, Object obj2) {
        try {
            if (flag) {
                synchronized (obj1) {
                    System.out.println(Thread.currentThread().getName() + "---锁住obj1");
                    Thread.sleep(2000);
                    System.out.println(Thread.currentThread().getName() + "---等待释放obj1");
                    synchronized (obj2) {
                        System.out.println(Thread.currentThread().getName() + "---锁住obj2");
                        Thread.sleep(2000);
                    }
                }
            } else {
                synchronized (obj2) {
                    System.out.println(Thread.currentThread().getName() + "---锁住obj2");
                    Thread.sleep(2000);
                    System.out.println(Thread.currentThread().getName() + "---等待释放obj2");
                    synchronized (obj1) {
                        System.out.println(Thread.currentThread().getName() + "---锁住obj1");
                        Thread.sleep(2000);
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("我是异步方法");
        return "testMethod";
    }
}