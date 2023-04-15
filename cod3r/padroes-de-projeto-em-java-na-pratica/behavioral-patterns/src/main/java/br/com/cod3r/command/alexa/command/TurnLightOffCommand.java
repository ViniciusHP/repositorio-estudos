package br.com.cod3r.command.alexa.command;

import br.com.cod3r.command.alexa.lights.GenericLight;

public class TurnLightOffCommand implements Command {

    private final GenericLight genericLight;

    public TurnLightOffCommand(GenericLight genericLight) {
        this.genericLight = genericLight;
    }

    @Override
    public void execute() {
        genericLight.turnOff();
    }
}
