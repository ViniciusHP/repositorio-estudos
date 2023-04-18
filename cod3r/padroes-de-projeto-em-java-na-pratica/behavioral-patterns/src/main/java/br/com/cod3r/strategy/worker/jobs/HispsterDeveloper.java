package br.com.cod3r.strategy.worker.jobs;

import br.com.cod3r.strategy.worker.strategies.eat.VeggieFoodStrategy;
import br.com.cod3r.strategy.worker.strategies.transportation.BikeStrategy;
import br.com.cod3r.strategy.worker.strategies.work.DeveloperStrategy;

public class HispsterDeveloper extends Person {

	public HispsterDeveloper() {
		super(new VeggieFoodStrategy(), new BikeStrategy(), new DeveloperStrategy());
	}
}
