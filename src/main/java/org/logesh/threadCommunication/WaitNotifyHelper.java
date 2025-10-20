package org.logesh.threadCommunication;

public class WaitNotifyHelper {

    private final Object lock = new Object();

    private boolean conditionMet = false;

    public void doWait() {
        synchronized (lock) {
            while (!conditionMet) {
                try {
                    System.out.println(Thread.currentThread().getName() + " waiting");
                    lock.wait();
                } catch (Exception e) {
                    Thread.currentThread().interrupt();
                    System.out.println(Thread.currentThread().getName() + " was interrupted!");
                }
                System.out.println(Thread.currentThread().getName() + " resumed execition");
            }
        }
    }

    public void doNotify() {
        synchronized (lock) {
            conditionMet = true;
            System.out.println(Thread.currentThread().getName() + " called notify");
            lock.notify();
        }
    }

    public void doNotifyAll() {
        synchronized (lock) {
            conditionMet = true;
            System.out.println(Thread.currentThread().getName() + " called notifyAll");
            lock.notifyAll();
        }
    }

}
