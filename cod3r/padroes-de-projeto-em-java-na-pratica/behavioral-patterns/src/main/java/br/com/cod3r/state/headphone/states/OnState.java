package br.com.cod3r.state.headphone.states;

import br.com.cod3r.state.headphone.HeadPhone;

public class OnState implements HeadPhoneState{

    private static final OnState instance = new OnState();

    private OnState() {}

    public static HeadPhoneState getInstance() {
        return instance;
    }

    @Override
    public void onClick(HeadPhone hp) {
        System.out.println("> Resume Player");
        hp.setState(PlayingState.getInstance());
    }

    @Override
    public void onLongClick(HeadPhone hp) {
        System.out.println("> Turning Off");
        hp.setState(OffState.getInstance());
    }
}
