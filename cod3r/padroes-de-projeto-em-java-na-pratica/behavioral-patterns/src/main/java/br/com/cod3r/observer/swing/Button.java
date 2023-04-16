package br.com.cod3r.observer.swing;

import javax.swing.*;

public class Button extends JButton {

    public Button(String label, Label... labels) {
        super(label);

        addActionListener(e -> {
            for(Label l: labels) {
                l.increment();
            }
        });
    }
}
