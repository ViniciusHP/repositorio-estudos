package br.com.cod3r.factory.apple.full.factory;

import br.com.cod3r.factory.apple.full.model.IPhone;
import br.com.cod3r.factory.apple.full.model.IPhone11;

public class IPhone11Factory extends  IPhoneFactory{
    @Override
    protected IPhone createIphone() {
        return new IPhone11();
    }
}
