package org.logesh.problems.printNumbers;

public class PrintNumbersDriver {
    public static void main(String[] args) {
        int n = 10;
        State state = new State(PrinterType.ODD);
        Thread oddThread = new Thread(new Printer(1, 2, state, PrinterType.ODD, PrinterType.EVEN, n));
        Thread evenThread = new Thread(new Printer(2, 2, state, PrinterType.EVEN, PrinterType.ODD, n));
        oddThread.start();
        evenThread.start();
    }
}
