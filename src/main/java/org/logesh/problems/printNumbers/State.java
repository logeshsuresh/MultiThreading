package org.logesh.problems.printNumbers;

import lombok.Data;

@Data
public class State {
    private PrinterType nextToPrint;
    public State(PrinterType nextToPrint) {
        this.nextToPrint = nextToPrint;
    }
}
