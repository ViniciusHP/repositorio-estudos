package br.com.cod3r.observer.party.subject;

import br.com.cod3r.observer.party.characters.Observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject<T> {

    private final List<Observer<T>> observers;
    protected T lastEvent;

    protected Subject() {
        this.observers = new ArrayList<>();
    }

    public void addObserver(Observer<T> observer) {
        this.observers.add(observer);
    }

    protected void notifyAllObservers(T event) {
        if(event != lastEvent) {
            lastEvent = event;
            this.observers.forEach(o -> o.update(lastEvent));
        }
    }
}
