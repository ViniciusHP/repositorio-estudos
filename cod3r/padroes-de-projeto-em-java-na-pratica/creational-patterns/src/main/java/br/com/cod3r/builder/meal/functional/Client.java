package br.com.cod3r.builder.meal.functional;


import br.com.cod3r.builder.meal.functional.model.FastFoodMeal;

public class Client {
	
	public static void main(String[] args) {
		FastFoodMeal burguerCombo = new FastFoodMeal.Builder("Fries")
				.andMain("CheeseBurguer")
				.forDrink("Coke")
				.thatsAll();
		System.out.println(burguerCombo);

		FastFoodMeal justFriesCombo = new FastFoodMeal.Builder("Fries").thatsAll();
		System.out.println(justFriesCombo);

		FastFoodMeal heartAttackCombo = new FastFoodMeal.Builder("Large Fries")
				.andMain("Monster Burguer")
				.forDrink("Milk Shake")
				.andDessert("Fudge Cake")
				.andGift("2 Kilograms")
				.thatsAll();
		System.out.println(heartAttackCombo);
	}
}
