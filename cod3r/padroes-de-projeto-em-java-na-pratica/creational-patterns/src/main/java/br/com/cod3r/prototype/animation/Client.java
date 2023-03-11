package br.com.cod3r.prototype.animation;

import java.util.ArrayList;
import java.util.List;

import br.com.cod3r.prototype.animation.model.Person;
import br.com.cod3r.prototype.animation.model.PersonSamples;

public class Client {
	private static List<Person> frames = new ArrayList<Person>();
	
	public static void animate() throws InterruptedException {
		System.out.println("*********************************");
		System.out.println("* ");
		System.out.println("* Adjust your screen's height!");
		System.out.println("* ");
		System.out.print("*********************************");
		Thread.sleep(3000);
		for(Person frame: frames) {
			frame.draw();
			Thread.sleep(500);
		}
		System.out.println("**********************");
		System.out.println("* ");
		System.out.println("* The End!");
		System.out.println("* ");
		System.out.print("**********************");
	}
	
	public static void main(String[] args) throws CloneNotSupportedException, InterruptedException {
		PersonSamples personSamples = new PersonSamples();
		Person person = personSamples.get("fatMan");
		addFrame(person);

		person = moveTo(person, "left");
		addFrame(person);

		person = moveTo(person, "left");
		addFrame(person);

		person = moveTo(person, "left");
		addFrame(person);

		person = moveTo(person, "left");
		addFrame(person);

		person = moveTo(person, "right");
		addFrame(person);

		person = moveTo(person, "right");
		addFrame(person);

		person = moveTo(person, "right");
		addFrame(person);

		person = moveTo(person, "right");
		addFrame(person);

		animate();
	}

	private static void addFrame(Person person) {
		frames.add(person);
	}

	private static Person moveTo(Person person, String side) throws CloneNotSupportedException {
		Person personClone = (Person) person.clone();

		if("left".equalsIgnoreCase(side)) {
			personClone.left();
		} else if ("right".equalsIgnoreCase(side)) {
			personClone.right();
		}
		return personClone;
	}
}
