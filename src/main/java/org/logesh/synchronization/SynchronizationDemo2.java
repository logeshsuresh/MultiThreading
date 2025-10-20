package org.logesh.synchronization;

public class SynchronizationDemo2 {

    public static void main(String[] args) throws InterruptedException {
        int threadCount = 100000;
        Thread[] threads = new Thread[threadCount];
        AtomicCounter  atomicCounter = new AtomicCounter();
        for (int i = 0; i < threadCount; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    atomicCounter.incrementCount();
                }
            });
            threads[i].start();
        }

        for (int i = 0; i < threadCount; i++) {
            threads[i].join();
        }

        System.out.printf("Count Value :" + atomicCounter.getCount());

    }

}
