package org.logesh.problems.boundedBlockingQueue.v2;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Semaphore;

public class BlockingQueue {

    private final Queue<Integer> queue;
    private final Integer capacity;
    private Semaphore emptySlots;
    private Semaphore filledSlots;

    public BlockingQueue(Integer capacity) {
        this.capacity = capacity;
        this.queue = new ConcurrentLinkedQueue<>();
        this.emptySlots = new Semaphore(this.capacity);
        this.filledSlots = new Semaphore(0);
    }

    public void enqueue(Integer val) throws InterruptedException {
        emptySlots.acquire();
        this.queue.offer(val);
        System.out.println("Enqueued val: " + val);
        filledSlots.release();
    }

    public Integer dequeue() throws InterruptedException {
        filledSlots.acquire();
        Integer valuePolled = this.queue.poll();
        emptySlots.release();
        System.out.println("Dequeued val: " + valuePolled);
        return valuePolled;
    }

}
