package br.com.cod3r.abstractfactory.apple;

import br.com.cod3r.abstractfactory.apple.factory.IPhone11Factory;
import br.com.cod3r.abstractfactory.apple.factory.IPhoneFactory;
import br.com.cod3r.abstractfactory.apple.factory.IPhoneXFactory;
import br.com.cod3r.abstractfactory.apple.factory.abstractFactory.BrazilianRulesAbstractFactory;
import br.com.cod3r.abstractfactory.apple.factory.abstractFactory.CountryRulesAbstractFactory;
import br.com.cod3r.abstractfactory.apple.factory.abstractFactory.USRulesAbstractFactory;
import br.com.cod3r.abstractfactory.apple.model.iphone.IPhone;

public class Client {

    public static void main(String[] args) {
//        CountryRulesAbstractFactory rules = new BrazilianRulesAbstractFactory();
        CountryRulesAbstractFactory rules = new USRulesAbstractFactory();
        IPhoneFactory iphone11Factory = new IPhone11Factory(rules);
        IPhoneFactory iphoneXFactory = new IPhoneXFactory(rules);

        System.out.println("### Ordering an iPhone X");
        IPhone iphoneX = iphoneXFactory.orderIPhone("standard");
        System.out.println(iphoneX);

        System.out.println("\n\n### Ordering an iPhone 11 HighEnd");
        IPhone iphone11 = iphone11Factory.orderIPhone("highEnd");
        System.out.println(iphone11);
    }
}
