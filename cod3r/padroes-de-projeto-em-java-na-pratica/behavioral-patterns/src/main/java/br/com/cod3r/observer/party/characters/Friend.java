package br.com.cod3r.observer.party.characters;

public class Friend implements Observer<Boolean>{

    public void sendGift() {
        System.out.println("Look, I bought your favorite beer!");
    }

    @Override
    public void update(Boolean isArrived) {
        if(isArrived) {
            sendGift();
        } else {
            System.out.println("Sleep...");
        }
    }
}
