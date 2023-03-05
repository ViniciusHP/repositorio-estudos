package br.com.cod3r.builder.meal.classic.director;

import br.com.cod3r.builder.meal.classic.builder.FastFoodMealBuilder;
import br.com.cod3r.builder.meal.classic.model.FastFoodMeal;

public class MealDirector {

    private FastFoodMealBuilder builder;

    public MealDirector(FastFoodMealBuilder builder) {
        this.builder = builder;
    }

    public void constructCombo() {
        this.builder.buildDrink();
        this.builder.buildMain();
        this.builder.buildSide();
        this.builder.buildDessert();
        this.builder.buildGift();
    }

    public FastFoodMeal getCombo() {
        return this.builder.getMeal();
    }
}
