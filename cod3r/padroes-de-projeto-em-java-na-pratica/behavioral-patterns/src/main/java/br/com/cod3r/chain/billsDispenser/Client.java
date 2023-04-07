package br.com.cod3r.chain.billsDispenser;

public class Client {

	public static void main(String[] args) {
		Dispenser atm = new Dispenser();
		atm.withdraw(230);
		System.out.println("-----------");
		atm.withdraw(66);

		Dispenser atmBase2 = new Dispenser(
			new Bill(128),
			new Bill(64),
			new Bill(32),
			new Bill(16),
			new Bill(8),
			new Bill(4),
			new Bill(2),
			new Bill(1));

		atmBase2.withdraw(230);
		System.out.println("-----------");
		atmBase2.withdraw(66);
	}
}
