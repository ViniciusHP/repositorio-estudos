package br.com.cod3r.command.alexa;

import br.com.cod3r.command.alexa.alexa.Alexa;
import br.com.cod3r.command.alexa.command.TurnLightOffCommand;
import br.com.cod3r.command.alexa.command.TurnLightOnCommand;
import br.com.cod3r.command.alexa.lights.PhillipsHueLight;
import br.com.cod3r.command.alexa.lights.XiaomiLight;

public class Client {

	public static void configureAlexa(Alexa alexa) {
		PhillipsHueLight livingRoom = new PhillipsHueLight();
		XiaomiLight kitchen = new XiaomiLight();

		alexa.addIntegration("Turn on the Living room light", new TurnLightOnCommand(livingRoom), "on", "Living room", "light");
		alexa.addIntegration("Turn off the Living room light", new TurnLightOffCommand(livingRoom), "off", "Living room", "light");

		alexa.addIntegration("Turn on the Kitchen light", new TurnLightOnCommand(kitchen), "on", "Kitchen", "light");
		alexa.addIntegration("Turn off the Kitchen light", new TurnLightOffCommand(kitchen), "off", "Kitchen", "light");
	}

	public static void main(String[] args) {
		Alexa alexa = new Alexa();
		configureAlexa(alexa);

		alexa.sendRequest("Turn on the Living room light");
		alexa.sendRequest("Turn off the Kitchen light");

		alexa.sendRequest("Please, could you Turn off the Living room light?");

		alexa.sendRequest("Please, could you Turn light?");
	}
}
