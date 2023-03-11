package br.com.cod3r.builder.spolleto.functional;

import br.com.cod3r.builder.spolleto.functional.model.Pasta;
import br.com.cod3r.builder.spolleto.functional.model.Salad;
import br.com.cod3r.builder.spolleto.functional.model.Size;

public class Client {
    public static void main(String[] args) {
        Pasta p1 = new Pasta.Builder(Size.LARGE).now();
        System.out.println(p1);

        Salad p2 = new Salad.Builder(Size.SMALL)
                .withToppings("Bacon", "Broccoli")
                .withSauces("Ceasar")
                .withCheese()
                .now();
        System.out.println(p2);

        Pasta p3 = new Pasta.Builder(Size.STANDARD)
                .withToppings("Garlic")
                .withSauces("Funghi", "Cheese")
                .withCheese()
                .withPepper()
                .now();
        System.out.println(p3);
    }
}
