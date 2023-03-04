package br.com.cod3r.factory.apple.full.factory;

import br.com.cod3r.factory.apple.model.IPhone;

public abstract class IPhoneFactory {

	public IPhone orderIphone() {
        IPhone device = createIphone();

        device.getHardware();
        device.assemble();
        device.certificates();
        device.pack();
        return device;
    }

    protected abstract IPhone createIphone();
}
