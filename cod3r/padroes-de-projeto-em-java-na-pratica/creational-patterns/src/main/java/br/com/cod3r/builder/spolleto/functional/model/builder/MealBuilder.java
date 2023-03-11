package br.com.cod3r.builder.spolleto.functional.model.builder;

import br.com.cod3r.builder.spolleto.functional.model.Meal;
import br.com.cod3r.builder.spolleto.functional.model.Size;

import java.util.Arrays;
import java.util.List;

public abstract class MealBuilder<M extends Meal, B extends MealBuilder<M, B>> {
    protected List<String> toppings;
    protected List<String> sauces;
    protected Size size;
    protected boolean cheese;
    protected boolean pepper;

    public MealBuilder(Size size) {
        this.size = size;
    }

    public B withToppings(String... toppings) {
        this.toppings = Arrays.asList(toppings);
        return getThis();
    }

    public B withSauces(String... sauces) {
        this.sauces = Arrays.asList(sauces);
        return getThis();
    }

    public B withCheese() {
        this.cheese = true;
        return getThis();
    }

    public B withPepper() {
        this.pepper = true;
        return getThis();
    }

    public abstract M now();

    protected abstract B getThis();
}
