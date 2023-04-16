package br.com.cod3r.observer.swing;

import javax.swing.*;
import java.awt.*;

public class Label extends JLabel {

    private String label;
    private int count = 0;

    public Label(String label) {
        setFont(new Font(getFont().getName(), Font.BOLD, 30));
        this.label = label;
        updateLabel();
    }

    public void increment() {
        count++;
        updateLabel();
    }

    public void updateLabel() {
        setText(String.format("%s: %d", label, count));
    }
}
