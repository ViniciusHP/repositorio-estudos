package br.com.cod3r.template.persist;

import br.com.cod3r.template.persist.models.UserModel;

public class Client {

	public static void main(String[] args) {
		UserModel user = new UserModel("user", "password");
		user.save();

		System.out.println("---------");

		try {
			UserModel invalidUser = new UserModel(null, null);
			invalidUser.save();
		}catch (RuntimeException e) {
			System.err.println(e.getMessage());
		}
	}
}
