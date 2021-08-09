package ub.edu.model;

import ub.edu.resources.service.AbstractFactoryData;
import ub.edu.resources.service.DataService;
import ub.edu.resources.service.FactorySQL;

public class Controller {

    private AbstractFactoryData factory;

    public Controller(String name) {
        if (name.equals("SQL"))
            factory = new FactorySQL();
    }

    public boolean validateUsuari(String username, String password) {
        DataService dataService = new DataService(factory);
        return dataService.getClientByUsuariAndPassword(username, password) != null;
    }
}
