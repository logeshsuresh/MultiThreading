package org.logesh.threadCommunication;

public class WaitNotifyDemo {

    public static void main(String[] args) {
        WaitNotifyHelper waitNotifyHelper = new WaitNotifyHelper();
        Thread waiter1 = new Thread(() -> waitNotifyHelper.doWait());
        Thread waiter2 = new Thread(() -> waitNotifyHelper.doWait());
        Thread waiter3 = new Thread(() -> waitNotifyHelper.doWait());
        waiter1.start();
        waiter2.start();
        waiter3.start();
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.printf("ERROR: {}", e.getMessage());
        }
        Thread notifierAll = new Thread(() -> waitNotifyHelper.doNotifyAll());
        notifierAll.start();
        try {
            waiter1.join();
            waiter2.join();
            waiter3.join();
            notifierAll.join();
        } catch (Exception e) {
            System.out.printf("ERROR: {}", e.getMessage());
        }
    }

}
