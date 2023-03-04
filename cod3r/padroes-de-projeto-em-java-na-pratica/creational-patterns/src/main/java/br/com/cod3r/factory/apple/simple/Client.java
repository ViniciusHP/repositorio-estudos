package br.com.cod3r.factory.apple.simple;

import br.com.cod3r.factory.apple.model.IPhone;
import br.com.cod3r.factory.apple.simple.factory.IPhoneSimpleFactory;

public class Client {
	
	public static void main(String[] args) {
		System.out.println("### Ordering an iPhone X");
		IPhone iphoneX = IPhoneSimpleFactory.orderIphone("X", "standard");
		System.out.println(iphoneX);

		System.out.println("\n\n### Ordering an iPhone 11 HighEnd");
		IPhone iphone11 =  IPhoneSimpleFactory.orderIphone("11", "highEnd");
		System.out.println(iphone11);
	}
}
