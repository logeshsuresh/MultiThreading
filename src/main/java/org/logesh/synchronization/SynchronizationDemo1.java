package org.logesh.synchronization;

public class SynchronizationDemo1 {

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        int numberOfThreads = 1000;
        Thread[] threads = new Thread[numberOfThreads];
        for (int i = 0; i < numberOfThreads; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    counter.incrementCount();
                }
            });
            threads[i].start();
        }
        for (int i = 0; i < numberOfThreads; i++) {
            try {
                threads[i].join();
            } catch (Exception e) {
                System.out.printf("ERROR: {}", e.getMessage());
            }
        }
        System.out.println("Final Count :" + counter.getCount());
    }

}
