package br.com.cod3r.mediator.swing;

import br.com.cod3r.mediator.swing.components.AddButton;
import br.com.cod3r.mediator.swing.components.Label;
import br.com.cod3r.mediator.swing.components.ResetButton;
import br.com.cod3r.mediator.swing.components.State;
import br.com.cod3r.mediator.swing.mediator.Mediator;

import javax.swing.*;
import java.awt.*;

public class Screen {

    private AddButton button;
    private ResetButton reset;
    private Label label;
    private State state;

    private Mediator mediator;

    public Screen() {
        mediator = new Mediator();
        state = new State(mediator);
        label = new Label(mediator);
        button = new AddButton(mediator);
        reset = new ResetButton(mediator);

        mediator.setButton(button);
        mediator.setLabel(label);
        mediator.setState(state);
    }

    public void init() {
        initButtonScreen();
        initCounterScreen();
    }

    public void initButtonScreen() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Button's Screen");
        frame.setLayout(new BorderLayout());

        frame.add(reset, BorderLayout.WEST);
        frame.add(button, BorderLayout.CENTER);

        frame.setSize(400,200);
        frame.setVisible(true);
    }

    public void initCounterScreen() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(label);

        frame.setSize(400,200);
        frame.setVisible(true);
    }
}
