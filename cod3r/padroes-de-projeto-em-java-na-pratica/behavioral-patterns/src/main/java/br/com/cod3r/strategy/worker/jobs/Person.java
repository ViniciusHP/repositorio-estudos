package br.com.cod3r.strategy.worker.jobs;

import br.com.cod3r.strategy.worker.strategies.eat.EatStrategy;
import br.com.cod3r.strategy.worker.strategies.transportation.TransportationStrategy;
import br.com.cod3r.strategy.worker.strategies.work.WorkStrategy;

public class Person implements Worker {

    private EatStrategy eatStrategy;
    private TransportationStrategy transportationStrategy;
    private WorkStrategy workStrategy;

    public Person(EatStrategy eatStrategy, TransportationStrategy transportationStrategy, WorkStrategy workStrategy) {
        this.eatStrategy = eatStrategy;
        this.transportationStrategy = transportationStrategy;
        this.workStrategy = workStrategy;
    }

    @Override
    public void eat() {
        eatStrategy.eat();
    }

    @Override
    public void move() {
        transportationStrategy.move();
    }

    @Override
    public void work() {
        workStrategy.work();
    }
}
