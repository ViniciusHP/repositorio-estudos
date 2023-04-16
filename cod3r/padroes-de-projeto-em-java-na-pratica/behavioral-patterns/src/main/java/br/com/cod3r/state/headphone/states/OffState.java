package br.com.cod3r.state.headphone.states;

import br.com.cod3r.state.headphone.HeadPhone;

public class OffState implements HeadPhoneState{

    private static final OffState instance = new OffState();

    private OffState() {}

    public static HeadPhoneState getInstance() {
        return instance;
    }

    @Override
    public void onClick(HeadPhone hp) {
        // Do nothing
    }

    @Override
    public void onLongClick(HeadPhone hp) {
        System.out.println("> Turning On");
        hp.setState(OnState.getInstance());
    }
}
