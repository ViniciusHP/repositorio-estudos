package br.com.cod3r.builder.spolleto.classic.model.builder;

import br.com.cod3r.builder.spolleto.classic.model.Size;

import java.util.List;

public interface MealBuilder {
    void setToppings(List<String> toppings);
    void setSauces(List<String> sauces);
    void setSize(Size size);
    void setCheese(boolean cheese);
    void setPepper(boolean pepper);
}
