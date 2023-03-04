package br.com.cod3r.abstractfactory.apple.factory.abstractFactory;

import br.com.cod3r.abstractfactory.apple.model.certificate.BrazilianCertificate;
import br.com.cod3r.abstractfactory.apple.model.certificate.Certificate;
import br.com.cod3r.abstractfactory.apple.model.packing.BrazilianPacking;
import br.com.cod3r.abstractfactory.apple.model.packing.Packing;

public class BrazilianRulesAbstractFactory implements CountryRulesAbstractFactory{
    @Override
    public Certificate getCertificates() {
        return new BrazilianCertificate();
    }

    @Override
    public Packing getPacking() {
        return new BrazilianPacking();
    }
}
