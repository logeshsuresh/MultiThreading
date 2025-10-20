package org.logesh.problems.printNumbers;

import lombok.SneakyThrows;

public class Printer implements Runnable {

    private final int step;
    private final State state;
    private int currentValue;
    private final PrinterType currentPrinterType;
    private final PrinterType nextPrinterType;
    private final int maxValue;

    public Printer(Integer startValue, int step, State state, PrinterType currentPrinterType, PrinterType nextPrinterType, int maxValue) {
        this.currentValue = startValue;
        this.step = step;
        this.state = state;
        this.currentPrinterType = currentPrinterType;
        this.nextPrinterType = nextPrinterType;
        this.maxValue = maxValue;
    }


    @SneakyThrows
    @Override
    public void run() {
        while (currentValue <= maxValue) {
            synchronized (state) {
                while (this.currentPrinterType != state.getNextToPrint()) {
                    state.wait();
                }
                System.out.println(currentPrinterType.toString() + ": " + currentValue);
                currentValue += step;
                state.setNextToPrint(this.nextPrinterType);
                state.notifyAll();
            }
        }
    }

}
