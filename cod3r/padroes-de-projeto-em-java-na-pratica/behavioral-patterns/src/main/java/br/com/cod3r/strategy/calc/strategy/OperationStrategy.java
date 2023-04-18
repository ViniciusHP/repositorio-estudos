package br.com.cod3r.strategy.calc.strategy;

@FunctionalInterface
public interface OperationStrategy {
    int calculate(int n1, int n2);
}
