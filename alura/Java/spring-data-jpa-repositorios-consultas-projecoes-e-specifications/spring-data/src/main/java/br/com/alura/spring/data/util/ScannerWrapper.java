package br.com.alura.spring.data.util;

import java.math.BigDecimal;
import java.util.Scanner;

public class ScannerWrapper {

    private final Scanner scanner;

    private boolean hasToReadNextLineIfString = false;

    public ScannerWrapper(Scanner scanner) {
        this.scanner = scanner;
    }

    public long nextLong() {
        setHasToReadNextLineIfString(true);
        return scanner.nextLong();
    }

    public BigDecimal nextBigDecimal() {
        setHasToReadNextLineIfString(true);
        return scanner.nextBigDecimal();
    }

    public int nextInt() {
        setHasToReadNextLineIfString(true);
        return scanner.nextInt();
    }

    public String nextLine() {
        if(hasToReadNextLineIfString) {
            scanner.nextLine();
            setHasToReadNextLineIfString(false);
        }

        return scanner.nextLine();
    }

    public String next() {
        setHasToReadNextLineIfString(true);
        return scanner.next();
    }

    public void close() {
        scanner.close();
    }

    private void setHasToReadNextLineIfString(boolean state) {
        this.hasToReadNextLineIfString = state;
    }
}
