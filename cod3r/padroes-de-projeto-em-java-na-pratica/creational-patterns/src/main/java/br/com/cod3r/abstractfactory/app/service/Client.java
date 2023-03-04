package br.com.cod3r.abstractfactory.app.service;

import br.com.cod3r.abstractfactory.app.service.factory.EJBServicesAbstractFactory;
import br.com.cod3r.abstractfactory.app.service.factory.RestServicesAbstractFactory;
import br.com.cod3r.abstractfactory.app.service.factory.ServicesAbstractFactory;
import br.com.cod3r.abstractfactory.app.service.services.CarService;
import br.com.cod3r.abstractfactory.app.service.services.UserService;

public class Client {
    public static void main(String[] args) {

//        ServicesAbstractFactory factory = new RestServicesAbstractFactory();
        ServicesAbstractFactory factory = new EJBServicesAbstractFactory();

        UserService userService = factory.getUserService();
        userService.save("Vinicius");
        userService.delete(10);

        CarService carService = factory.getCarService();
        carService.save("Lancer");
        carService.update("Tesla x");
    }
}
