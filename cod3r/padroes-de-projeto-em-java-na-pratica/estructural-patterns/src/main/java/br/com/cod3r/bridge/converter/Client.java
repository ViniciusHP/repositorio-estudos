package br.com.cod3r.bridge.converter;

import br.com.cod3r.bridge.converter.converters.CSVConverter;
import br.com.cod3r.bridge.converter.converters.Converter;
import br.com.cod3r.bridge.converter.converters.JsonConverter;
import br.com.cod3r.bridge.converter.converters.XMLConverter;
import br.com.cod3r.bridge.converter.employees.Employee;
import br.com.cod3r.bridge.converter.employees.ITGuy;
import br.com.cod3r.bridge.converter.employees.ProjectManager;

public class Client {

	public static void main(String[] args) {
		Converter csvConverter = new CSVConverter();
		Converter jsonConverter = new JsonConverter();
		Converter xmlConverter = new XMLConverter();

		Employee itGuy = new ITGuy("Jack Bauer", 52, 5000d);
		ProjectManager projectManager = new ProjectManager("Jen Barber", 40, 6000d);

		System.out.println(csvConverter.getEmployeeFormated(itGuy));
		System.out.println(jsonConverter.getEmployeeFormated(itGuy));
		System.out.println(xmlConverter.getEmployeeFormated(itGuy));

		System.out.println();

		System.out.println(csvConverter.getEmployeeFormated(projectManager));
		System.out.println(jsonConverter.getEmployeeFormated(projectManager));
		System.out.println(xmlConverter.getEmployeeFormated(projectManager));
	}
}
