package br.com.cod3r.factory.apple.full.factory;

import br.com.cod3r.factory.apple.full.model.IPhone;
import br.com.cod3r.factory.apple.full.model.IPhone11Pro;

public class IPhone11ProFactory extends IPhoneFactory{
    @Override
    protected IPhone createIphone() {
        return new IPhone11Pro();
    }
}
