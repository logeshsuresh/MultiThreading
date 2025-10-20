package org.logesh.problems.boundedBlockingQueue.v1;

import java.util.Queue;

public class BlockingQueue {

    private final Queue<Integer> queue;
    private final Integer capacity;

    public BlockingQueue(Queue<Integer> queue, Integer capacity) {
        this.queue = queue;
        this.capacity = capacity;
    }

    public void enqueue(Integer value) throws InterruptedException {
        synchronized (this) {
            while (this.queue.size() == capacity) {
                wait();
            }
            this.queue.offer(value);
            System.out.println("Enqueued value: " + value);
            notifyAll();
        }
    }

    public void dequeue() throws InterruptedException {
        synchronized (this) {
            while (this.queue.isEmpty()) {
                wait();
            }
            Integer valuePolled = this.queue.poll();
            System.out.println("Dequeued value: " + valuePolled);
            notifyAll();
        }
    }

}
