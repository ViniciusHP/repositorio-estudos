package br.com.cod3r.builder.spolleto.fluent.model.builder;

import br.com.cod3r.builder.spolleto.fluent.model.Meal;
import br.com.cod3r.builder.spolleto.fluent.model.Salad;
import br.com.cod3r.builder.spolleto.fluent.model.Size;

public class SaladBuilder extends MealBuilder<Salad, SaladBuilder> {

    public SaladBuilder(Size size) {
        super(size);
    }

    @Override
    protected SaladBuilder getThis() {
        return this;
    }

    @Override
    public Salad now() {
        return new Salad(toppings, sauces, size, cheese, pepper);
    }
}
