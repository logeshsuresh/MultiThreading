package org.logesh.synchronization;

public class Counter {

    private volatile int count;

    public Counter() {
        this.count = 0;
    }

    public synchronized void incrementCount() {
        int temp = count; // read
        try {
            Thread.sleep(1); // simulate context switching
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count = temp + 1; // write
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

}
