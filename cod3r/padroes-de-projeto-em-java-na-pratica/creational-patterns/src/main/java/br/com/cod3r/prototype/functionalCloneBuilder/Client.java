package br.com.cod3r.prototype.functionalCloneBuilder;

import br.com.cod3r.prototype.functionalCloneBuilder.model.Address;
import br.com.cod3r.prototype.functionalCloneBuilder.model.User;

public class Client {

	public static void main(String[] args) throws CloneNotSupportedException {
		User user = new User("ToClone", 25, new Address("ABC Street", 1000));
		User cloneUser = user.cloneBuilder().withName("Cloned++").now();
		User anotherClone = cloneUser.cloneBuilder()
						.withAge(100)
						.withAddress(new Address("A Street", 500))
						.now();

		System.out.println(user);
		System.out.println(cloneUser);
		System.out.println(anotherClone);
	}
}
