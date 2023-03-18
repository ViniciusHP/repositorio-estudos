package br.com.cod3r.adapter.hexagonal.application;

import br.com.cod3r.adapter.hexagonal.core.model.User;
import br.com.cod3r.adapter.hexagonal.core.usecases.UserService;
import br.com.cod3r.adapter.hexagonal.infrastructure.UserMemoryDatabaseAdapter;

import java.util.List;
import java.util.Map;

public class UserRest {

	public UserService userFacade;
	
	public UserRest() {
		this.userFacade = new UserService(new UserMemoryDatabaseAdapter());
	}

	public Integer post(Map<String, String> values) {

		try {
			User user = new User(values.get("name"), values.get("email"), values.get("password"));
			userFacade.saveUser(user);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return 400;
		}

		return 201;
	}
	
	public Integer get() {
		List<User> users = userFacade.getUsers();
		users.stream().forEach(System.out::println);
		return 200;
	}
}
