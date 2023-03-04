package br.com.cod3r.factory.apple.halfSimple.factory;

import br.com.cod3r.factory.apple.model.IPhone;
import br.com.cod3r.factory.apple.model.IPhoneX;
import br.com.cod3r.factory.apple.model.IPhoneXSMax;

public class IPhoneXFactory extends IPhoneFactory {
    @Override
    protected IPhone createIphone(String level) {
        if ("standard".equals(level)) {
            return new IPhoneX();
        } else if ("highEnd".equals(level)) {
            return new IPhoneXSMax();
        }
        return null;
    }
}
