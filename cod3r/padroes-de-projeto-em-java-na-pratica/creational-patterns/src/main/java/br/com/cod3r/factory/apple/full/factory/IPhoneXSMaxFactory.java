package br.com.cod3r.factory.apple.full.factory;

import br.com.cod3r.factory.apple.full.model.IPhone;
import br.com.cod3r.factory.apple.full.model.IPhoneXSMax;

public class IPhoneXSMaxFactory extends IPhoneFactory{
    @Override
    protected IPhone createIphone() {
        return new IPhoneXSMax();
    }
}
