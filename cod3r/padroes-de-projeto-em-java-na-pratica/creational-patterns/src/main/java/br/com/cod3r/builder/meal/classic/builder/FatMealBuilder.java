package br.com.cod3r.builder.meal.classic.builder;

public class FatMealBuilder extends FastFoodMealBuilder{
    @Override
    public void buildDrink() {
        meal.setDrink("MilkShake");
    }

    @Override
    public void buildMain() {
        meal.setMain("TripleCheddarBaconBurguer");
    }

    @Override
    public void buildSide() {
        meal.setSide("Onion Rings");
    }

    @Override
    public void buildDessert() {
        meal.setDessert("Large IceCream");
    }

    @Override
    public void buildGift() {
        meal.setToy("Hospital pass");
    }
}
