package br.com.cod3r.template.sales.service.template;

import br.com.cod3r.template.sales.model.Cart;

public class RegularPrice extends BestOfferTemplate{
    public RegularPrice(Cart cart) {
        super(cart);
    }

    @Override
    public boolean isAppliable() {
        return true;
    }

    @Override
    protected void calibrateVariables() {
        // Do nothing
    }
}
