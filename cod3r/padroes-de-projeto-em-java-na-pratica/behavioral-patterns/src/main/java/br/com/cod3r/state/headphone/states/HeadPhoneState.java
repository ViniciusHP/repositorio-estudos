package br.com.cod3r.state.headphone.states;

import br.com.cod3r.state.headphone.HeadPhone;

public interface HeadPhoneState {
    void onClick(HeadPhone hp);
    void onLongClick(HeadPhone hp);
}
