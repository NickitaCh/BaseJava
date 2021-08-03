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
            System.out.println(Thread.currentThread().getName() + " Waits for " + lockFirst);
            synchronized (lockFirst) {
                System.out.println(Thread.currentThread().getName() + " Takes " + lockFirst);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " Waits for " + lockSecond);
                synchronized (lockSecond) {
                    System.out.println(Thread.currentThread().getName() + " Takes " + lockSecond);
                }
            }
        }).start();
    }
}