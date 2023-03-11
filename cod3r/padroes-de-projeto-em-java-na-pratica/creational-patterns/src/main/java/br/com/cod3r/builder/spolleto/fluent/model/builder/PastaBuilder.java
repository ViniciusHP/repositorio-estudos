package br.com.cod3r.builder.spolleto.fluent.model.builder;

import br.com.cod3r.builder.spolleto.fluent.model.Pasta;
import br.com.cod3r.builder.spolleto.fluent.model.Size;

public class PastaBuilder extends MealBuilder<Pasta, PastaBuilder> {

    public PastaBuilder(Size size) {
        super(size);
    }

    @Override
    protected PastaBuilder getThis() {
        return this;
    }

    @Override
    public Pasta now() {
        return new Pasta(toppings, sauces, size, cheese, pepper);
    }
}
