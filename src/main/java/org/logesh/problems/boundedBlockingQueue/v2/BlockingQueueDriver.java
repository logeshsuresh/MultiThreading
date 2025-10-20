package org.logesh.problems.boundedBlockingQueue.v2;

import java.util.LinkedList;

public class BlockingQueueDriver {

    public static void main(String[] args) {
        BlockingQueue blockingQueue = new BlockingQueue(3);
        Thread producerThread1 = new Thread(() -> {
            try {
                blockingQueue.enqueue(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread producerThread2 = new Thread(() -> {
            try {
                blockingQueue.enqueue(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread producerThread3 = new Thread(() -> {
            try {
                blockingQueue.enqueue(3);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread producerThread4 = new Thread(() -> {
            try {
                blockingQueue.enqueue(4);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread producerThread5 = new Thread(() -> {
            try {
                blockingQueue.enqueue(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread consumerThread1 = new Thread(() -> {
            try {
                blockingQueue.dequeue();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread consumerThread2 = new Thread(() -> {
            try {
                blockingQueue.dequeue();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread consumerThread3 = new Thread(() -> {
            try {
                blockingQueue.dequeue();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread consumerThread4 = new Thread(() -> {
            try {
                blockingQueue.dequeue();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        producerThread1.start();
        producerThread2.start();
        producerThread3.start();
        producerThread4.start();
        consumerThread1.start();
        consumerThread2.start();
        consumerThread3.start();
        consumerThread4.start();
    }

}
