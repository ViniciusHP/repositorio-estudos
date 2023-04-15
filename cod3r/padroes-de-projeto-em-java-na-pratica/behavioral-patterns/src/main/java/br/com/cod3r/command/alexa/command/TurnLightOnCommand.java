package br.com.cod3r.command.alexa.command;

import br.com.cod3r.command.alexa.lights.GenericLight;

public class TurnLightOnCommand implements Command {

    private final GenericLight genericLight;

    public TurnLightOnCommand(GenericLight genericLight) {
        this.genericLight = genericLight;
    }

    @Override
    public void execute() {
        genericLight.turnOn();
    }
}
