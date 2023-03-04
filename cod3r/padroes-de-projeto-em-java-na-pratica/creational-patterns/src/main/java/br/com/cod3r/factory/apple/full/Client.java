package br.com.cod3r.factory.apple.full;

import br.com.cod3r.factory.apple.full.factory.IPhone11ProFactory;
import br.com.cod3r.factory.apple.full.factory.IPhoneFactory;
import br.com.cod3r.factory.apple.full.factory.IPhoneXFactory;
import br.com.cod3r.factory.apple.full.model.IPhone;

public class Client {
	
	public static void main(String[] args) {
		IPhoneFactory iphoneXFactory = new IPhoneXFactory();
		IPhoneFactory iphone11ProFactory = new IPhone11ProFactory();


		System.out.println("### Ordering an iPhone X");
		IPhone iphoneX = iphoneXFactory.orderIphone();
		System.out.println(iphoneX);

		System.out.println("\n\n### Ordering an iPhone 11 HighEnd");
		IPhone iphone11 = iphone11ProFactory.orderIphone();
		System.out.println(iphone11);
	}
}
