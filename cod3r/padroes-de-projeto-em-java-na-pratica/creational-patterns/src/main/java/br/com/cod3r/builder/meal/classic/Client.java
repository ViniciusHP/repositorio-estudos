package br.com.cod3r.builder.meal.classic;

import br.com.cod3r.builder.meal.classic.builder.*;
import br.com.cod3r.builder.meal.classic.director.MealDirector;
import br.com.cod3r.builder.meal.classic.model.FastFoodMeal;

public class Client {
	
	public static void main(String[] args) {
		FastFoodMeal mealMenu1 = order(new Menu1Builder());
		FastFoodMeal mealMenu2 = order(new Menu2Builder());
		FastFoodMeal mealFat = order(new FatMealBuilder());
		FastFoodMeal mealFries = order(new JustFriesBuilder());

		System.out.println(mealMenu1);
		System.out.println(mealMenu2);
		System.out.println(mealFat);
		System.out.println(mealFries);
	}

	private static FastFoodMeal order(FastFoodMealBuilder builder) {
		MealDirector director = new MealDirector(builder);
		director.constructCombo();
		return director.getCombo();
	}
}
