package br.com.cod3r.abstractfactory.apple.factory.abstractFactory;

import br.com.cod3r.abstractfactory.apple.model.certificate.Certificate;
import br.com.cod3r.abstractfactory.apple.model.certificate.USCertificate;
import br.com.cod3r.abstractfactory.apple.model.packing.Packing;
import br.com.cod3r.abstractfactory.apple.model.packing.USPacking;

public class USRulesAbstractFactory implements CountryRulesAbstractFactory{
    @Override
    public Certificate getCertificates() {
        return new USCertificate();
    }

    @Override
    public Packing getPacking() {
        return new USPacking();
    }
}
