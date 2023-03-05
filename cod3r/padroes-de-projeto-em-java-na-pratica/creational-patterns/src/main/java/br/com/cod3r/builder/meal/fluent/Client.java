package br.com.cod3r.builder.meal.fluent;

import br.com.cod3r.builder.meal.classic.builder.*;
import br.com.cod3r.builder.meal.classic.director.MealDirector;
import br.com.cod3r.builder.meal.fluent.model.FastFoodMeal;
import br.com.cod3r.builder.meal.fluent.model.builder.FastFoodMealBuilder;

public class Client {
	
	public static void main(String[] args) {
		FastFoodMeal burguerCombo = new FastFoodMealBuilder("Fries")
				.andMain("CheeseBurguer")
				.forDrink("Coke")
				.thatsAll();
		System.out.println(burguerCombo);

		FastFoodMeal justFriesCombo = new FastFoodMealBuilder("Fries").thatsAll();
		System.out.println(justFriesCombo);

		FastFoodMeal heartAttackCombo = new FastFoodMealBuilder("Large Fries")
				.andMain("Monster Burguer")
				.forDrink("Milk Shake")
				.andDessert("Fudge Cake")
				.andGift("2 Kilograms")
				.thatsAll();
		System.out.println(heartAttackCombo);
	}
}
