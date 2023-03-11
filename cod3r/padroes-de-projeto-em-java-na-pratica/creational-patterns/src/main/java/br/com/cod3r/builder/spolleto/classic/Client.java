package br.com.cod3r.builder.spolleto.classic;

import br.com.cod3r.builder.spolleto.classic.model.Pasta;
import br.com.cod3r.builder.spolleto.classic.model.Salad;
import br.com.cod3r.builder.spolleto.classic.model.Size;
import br.com.cod3r.builder.spolleto.classic.model.builder.PastaBuilder;
import br.com.cod3r.builder.spolleto.classic.model.builder.SaladBuilder;

import java.util.Arrays;

public class Client {
    public static void main(String[] args) {
        PastaBuilder pastaBuilder = new PastaBuilder();
        pastaBuilder.setSize(Size.LARGE);
        Pasta p1 = pastaBuilder.getResult();
        System.out.println(p1);

        SaladBuilder saladBuilder = new SaladBuilder();
        saladBuilder.setSize(Size.SMALL);
        saladBuilder.setToppings(Arrays.asList("Bacon", "Broccoli"));
        saladBuilder.setSauces(Arrays.asList("Ceasar"));
        saladBuilder.setCheese(true);
        Salad p2 = saladBuilder.getResult();
        System.out.println(p2);

        pastaBuilder = new PastaBuilder();
        pastaBuilder.setSize(Size.STANDARD);
        pastaBuilder.setToppings(Arrays.asList("Garlic"));
        pastaBuilder.setSauces(Arrays.asList("Funghi", "Cheese"));
        pastaBuilder.setCheese(true);
        pastaBuilder.setPepper(true);
        Pasta p3 = pastaBuilder.getResult();
        System.out.println(p3);
    }
}
