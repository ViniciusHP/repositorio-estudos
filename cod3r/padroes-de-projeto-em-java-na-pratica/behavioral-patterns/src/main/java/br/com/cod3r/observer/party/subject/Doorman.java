package br.com.cod3r.observer.party.subject;

import br.com.cod3r.observer.party.characters.Observer;

public class Doorman extends Subject<Boolean>{

	public void setStatus(boolean newStatus) {
		notifyAllObservers(newStatus);
	}
}
