package ub.edu.spec.signUp;

import org.concordion.api.BeforeExample;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;
import ub.edu.controller.Controller;

@RunWith(ConcordionRunner.class)
public class signUp {
    private Controller controlador;

    @BeforeExample
    public void init() {
        controlador = new Controller();
        controlador.iniCarteraClients();
    }

    public String createClient(String username, String password) {return controlador.createClient(username, password);}
}
