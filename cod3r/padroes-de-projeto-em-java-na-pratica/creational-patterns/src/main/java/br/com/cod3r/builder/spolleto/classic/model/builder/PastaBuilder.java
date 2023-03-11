package br.com.cod3r.builder.spolleto.classic.model.builder;

import br.com.cod3r.builder.spolleto.classic.model.Pasta;

public class PastaBuilder extends DefaultMealBuilder<Pasta>{

    @Override
    public Pasta getResult() {
        return new Pasta(toppings, sauces, size, cheese, pepper);
    }
}
