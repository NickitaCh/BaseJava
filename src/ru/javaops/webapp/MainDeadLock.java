package ru.javaops.webapp;

public class MainDeadLock {
    public static void main(String[] args) {
        final String lockFirst = "FirstLock";
        final String lockSecond = "SecondLock";

        deadLock(lockFirst, lockSecond);
        deadLock(lockSecond, lockFirst);
    }

    private static void deadLock(Object lockFirst, Object lockSecond) {
        new Thread(() -> {
            System.out.println("Wait for " + lockFirst);
            synchronized (lockFirst) {
                System.out.println("Thread 1: takes " + lockFirst);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Wait for " + lockSecond);
                synchronized (lockSecond) {
                    System.out.println("Thread 2: takes " + lockSecond);
                }
            }
        }).start();
    }
}
