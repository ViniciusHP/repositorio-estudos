package br.com.cod3r.builder.spolleto.functional.model;

import br.com.cod3r.builder.spolleto.functional.model.builder.MealBuilder;

import java.util.List;

public class Pasta extends Meal {
    public Pasta(List<String> toppings, List<String> sauces, Size size, boolean cheese, boolean pepper) {
        super(toppings, sauces, size, cheese, pepper);
    }

    @Override
    public String toString() {
        return "Pasta{" +
                "toppings=" + toppings +
                ", sauces=" + sauces +
                ", size=" + size +
                ", cheese=" + cheese +
                ", pepper=" + pepper +
                '}';
    }

    public static class Builder extends MealBuilder<Pasta, Builder> {

        public Builder(Size size) {
            super(size);
        }

        @Override
        public Pasta now() {
            return new Pasta(toppings, sauces, size, cheese, pepper);
        }

        @Override
        protected Builder getThis() {
            return this;
        }
    }
}
