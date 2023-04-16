package br.com.cod3r.observer.party.characters;

import br.com.cod3r.observer.party.subject.Doorman;

public class Wife implements Observer<Boolean> {

	public void partyTime() {
		System.out.println("Let´s Party! :D");
	}

	@Override
	public void update(Boolean isArrived) {
		if(isArrived) {
			partyTime();
		} else {
			System.out.println("Hold!");
		}
	}
}
