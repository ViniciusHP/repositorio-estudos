package br.com.cod3r.builder.spolleto.functional.model;

import br.com.cod3r.builder.spolleto.functional.model.builder.MealBuilder;

import java.util.List;

public class Salad extends Meal {
    public Salad(List<String> toppings, List<String> sauces, Size size, boolean cheese, boolean pepper) {
        super(toppings, sauces, size, cheese, pepper);
    }

    @Override
    public String toString() {
        return "Salad{" +
                "toppings=" + toppings +
                ", sauces=" + sauces +
                ", size=" + size +
                ", cheese=" + cheese +
                ", pepper=" + pepper +
                '}';
    }

    public static class Builder extends MealBuilder<Salad, Builder> {
        public Builder(Size size) {
            super(size);
        }

        @Override
        protected Builder getThis() {
            return this;
        }

        @Override
        public Salad now() {
            return new Salad(toppings, sauces, size, cheese, pepper);
        }
    }
}
