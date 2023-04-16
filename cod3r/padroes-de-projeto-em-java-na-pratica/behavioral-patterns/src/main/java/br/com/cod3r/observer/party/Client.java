package br.com.cod3r.observer.party;

import br.com.cod3r.observer.party.characters.Friend;
import br.com.cod3r.observer.party.subject.Doorman;
import br.com.cod3r.observer.party.characters.Wife;

public class Client {

	public static void main(String[] args) {
		Doorman reception = new Doorman();
		reception.addObserver(new Wife());
		reception.addObserver(new Friend());

		reception.setStatus(false);
		reception.setStatus(false);

		System.out.println("Husband is comming");
		reception.setStatus(true);
	}
}
