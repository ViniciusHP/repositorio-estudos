package br.com.cod3r.strategy.worker.jobs;

import br.com.cod3r.strategy.worker.strategies.eat.EatStrategy;
import br.com.cod3r.strategy.worker.strategies.eat.MeatFoodStrategy;
import br.com.cod3r.strategy.worker.strategies.transportation.AirplaneStrategy;
import br.com.cod3r.strategy.worker.strategies.transportation.TransportationStrategy;
import br.com.cod3r.strategy.worker.strategies.work.PilotStrategy;
import br.com.cod3r.strategy.worker.strategies.work.WorkStrategy;

public class Pilot extends Person {

	public Pilot() {
		super(new MeatFoodStrategy(), new AirplaneStrategy(), new PilotStrategy());
	}
}
