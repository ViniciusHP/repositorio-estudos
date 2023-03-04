package br.com.cod3r.abstractfactory.app.service.factory;

import br.com.cod3r.abstractfactory.app.service.services.CarRestService;
import br.com.cod3r.abstractfactory.app.service.services.CarService;
import br.com.cod3r.abstractfactory.app.service.services.UserRestService;
import br.com.cod3r.abstractfactory.app.service.services.UserService;

public class RestServicesAbstractFactory implements ServicesAbstractFactory{
    @Override
    public CarService getCarService() {
        return new CarRestService();
    }

    @Override
    public UserService getUserService() {
        return new UserRestService();
    }
}
