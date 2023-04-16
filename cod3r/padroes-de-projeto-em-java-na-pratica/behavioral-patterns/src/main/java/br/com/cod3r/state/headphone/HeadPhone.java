package br.com.cod3r.state.headphone;

import br.com.cod3r.state.headphone.states.HeadPhoneState;
import br.com.cod3r.state.headphone.states.OffState;

public class HeadPhone {
	private HeadPhoneState state;
	
	public HeadPhone() {
		state = OffState.getInstance();
	}
	
	public void onLongClick() {
		System.out.println("Long Click Pressed...");
		state.onLongClick(this);
	}
	
	public void onClick() {
		System.out.println("Click Pressed...");
		state.onClick(this);
	}

	public void setState(HeadPhoneState newState) {
		System.out.println(String.format("Changing from %s to %s",
				this.state.getClass().getSimpleName(),
				newState.getClass().getSimpleName()));
		this.state = newState;
	}
}
