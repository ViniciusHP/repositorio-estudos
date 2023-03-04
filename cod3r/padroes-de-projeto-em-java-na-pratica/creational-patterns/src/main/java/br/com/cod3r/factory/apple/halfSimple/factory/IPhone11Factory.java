package br.com.cod3r.factory.apple.halfSimple.factory;

import br.com.cod3r.factory.apple.halfSimple.model.IPhone;
import br.com.cod3r.factory.apple.halfSimple.model.IPhone11;
import br.com.cod3r.factory.apple.halfSimple.model.IPhone11Pro;

public class IPhone11Factory extends IPhoneFactory {
    @Override
    protected IPhone createIphone(String level) {
        if("standard".equals(level)) {
            return new IPhone11();
        } else if("highEnd".equals(level)) {
            return new IPhone11Pro();
        }
        return null;
    }
}
