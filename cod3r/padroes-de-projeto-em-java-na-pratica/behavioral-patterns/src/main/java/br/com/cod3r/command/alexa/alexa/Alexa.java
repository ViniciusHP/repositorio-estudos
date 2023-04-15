package br.com.cod3r.command.alexa.alexa;

import java.util.HashMap;
import java.util.Map;

import br.com.cod3r.command.alexa.command.Command;
import br.com.cod3r.command.alexa.command.TurnLightOnCommand;
import br.com.cod3r.command.alexa.lights.PhillipsHueLight;
import br.com.cod3r.command.alexa.lights.XiaomiLight;

public class Alexa {
	private Map<String, Command> integrations;
	private AlexaAI ai;

	public Alexa() {
		integrations = new HashMap<>();
		ai = new AlexaAI();
	}

	public void addIntegration(String key, Command command, String... keywords) {
		integrations.put(key, command);
		ai.addAssociation(key, keywords);
	}

	public void sendRequest(String request) {
		Command command = findCommand(request);

		if(command == null) {
			System.out.println("Sorry, I can't perform your request!");
			return;
		}

		System.out.println("Send a generic command as you saved in my configurations");
		command.execute();
	}

	private Command findCommand(String request) {
		Command command = integrations.get(request);

		if(command != null) {
			return command;
		}

		String key = ai.getFindAssociations(request);
		command = integrations.get(key);

		return command;
	}
}
