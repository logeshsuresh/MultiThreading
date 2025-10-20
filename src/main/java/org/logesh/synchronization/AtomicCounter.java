package org.logesh.synchronization;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounter {

    private AtomicInteger count;

    public AtomicCounter() {
        this.count = new AtomicInteger(0);
    }

    public void incrementCount() {
        // Atomically increments and returns the updated value
        count.incrementAndGet();
    }

    public int getCount() {
        return this.count.get();
    }

    public void setCount(AtomicInteger count) {
        this.count = count;
    }
}
