package ub.edu.spec.login;

import org.concordion.api.BeforeExample;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;
import ub.edu.controller.Controller;

@RunWith(ConcordionRunner.class)
public class login {
    private Controller controlador;

    @BeforeExample
    public void init() {
        controlador = new Controller();
        controlador.iniCarteraClients();
    }

    public boolean isValidLogin(String username, String password) {
        return controlador.validateClient(username, password);
    }

    public String isValidClient(String username) {
        return controlador.isValidNameClient(username);
    }
    /* Borrar abajo*/
    public String informationClient(String username){ return controlador.getInformationClient(username);}
}
