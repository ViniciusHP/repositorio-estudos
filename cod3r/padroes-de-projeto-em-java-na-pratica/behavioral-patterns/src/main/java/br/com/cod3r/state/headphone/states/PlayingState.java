package br.com.cod3r.state.headphone.states;

import br.com.cod3r.state.headphone.HeadPhone;

public class PlayingState implements HeadPhoneState{

    private static final PlayingState instance = new PlayingState();

    private PlayingState() {}

    public static PlayingState getInstance() {
        return instance;
    }

    @Override
    public void onClick(HeadPhone hp) {
        System.out.println("> Stop Player");
        hp.setState(OnState.getInstance());
    }

    @Override
    public void onLongClick(HeadPhone hp) {
        System.out.println("> Turning Off");
        hp.setState(OffState.getInstance());
    }
}
