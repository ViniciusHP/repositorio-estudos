package br.com.cod3r.strategy.worker.jobs;

import br.com.cod3r.strategy.worker.strategies.eat.EatStrategy;
import br.com.cod3r.strategy.worker.strategies.eat.MeatFoodStrategy;
import br.com.cod3r.strategy.worker.strategies.transportation.CarStrategy;
import br.com.cod3r.strategy.worker.strategies.transportation.TransportationStrategy;
import br.com.cod3r.strategy.worker.strategies.work.DeveloperStrategy;
import br.com.cod3r.strategy.worker.strategies.work.WorkStrategy;

public class Developer extends Person {


	public Developer() {
		super(new MeatFoodStrategy(), new CarStrategy(), new DeveloperStrategy());
	}
}
