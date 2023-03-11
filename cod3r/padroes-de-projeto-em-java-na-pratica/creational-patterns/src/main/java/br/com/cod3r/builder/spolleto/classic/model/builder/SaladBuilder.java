package br.com.cod3r.builder.spolleto.classic.model.builder;

import br.com.cod3r.builder.spolleto.classic.model.Salad;
import br.com.cod3r.builder.spolleto.classic.model.Size;

import java.util.List;

public class SaladBuilder implements MealBuilder {

    protected List<String> toppings;
    protected List<String> sauces;
    protected Size size;
    protected boolean cheese;
    protected boolean pepper;

    @Override
    public void setToppings(List<String> toppings) {
        this.toppings = toppings;
    }

    @Override
    public void setSauces(List<String> sauces) {
        this.sauces = sauces;
    }

    @Override
    public void setSize(Size size) {
        this.size = size;
    }

    @Override
    public void setCheese(boolean cheese) {
        this.cheese = cheese;
    }

    @Override
    public void setPepper(boolean pepper) {
        this.pepper = pepper;
    }

    public Salad getResult() {
        return new Salad(toppings, sauces, size, cheese, pepper);
    }
}
