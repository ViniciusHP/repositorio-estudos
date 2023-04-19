package br.com.cod3r.template.persist.models;

public class UserModel extends ModelPersist{

    protected String username;
    protected String password;

    public UserModel(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public void preSave() {
        System.out.println("Checking if there is another user with the same username");
        System.out.println("Generating UUID...");
    }

    @Override
    public void prePersist() {
        if(username == null) throw new RuntimeException("Username is mandatory.");
        if(password == null) throw new RuntimeException("password is mandatory.");
    }

    @Override
    public void postSave() {
        System.out.println("Creating user roles");
    }
}
