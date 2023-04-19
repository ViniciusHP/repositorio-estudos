package br.com.cod3r.template.sales.service.template;

import br.com.cod3r.template.sales.model.Cart;

import java.time.LocalDate;
import java.time.Month;

public class BlackFriday extends BestOfferTemplate{
    public BlackFriday(Cart cart) {
        super(cart);
    }

    @Override
    public boolean isAppliable() {
        LocalDate now = LocalDate.now();
        return now.getMonth().equals(Month.NOVEMBER);
    }

    @Override
    protected void calibrateVariables() {
        priceFactor = 0.75d;
    }
}
