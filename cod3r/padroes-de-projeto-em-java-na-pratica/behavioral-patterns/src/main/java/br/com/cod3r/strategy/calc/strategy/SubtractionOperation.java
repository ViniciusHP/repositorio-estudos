package br.com.cod3r.strategy.calc.strategy;

public class SubtractionOperation implements OperationStrategy{
    @Override
    public int calculate(int n1, int n2) {
        return n1 - n2;
    }
}
