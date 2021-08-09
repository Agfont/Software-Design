package ub.edu.spec.visualitzarEpisodi;

import org.concordion.api.BeforeExample;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;
import ub.edu.controller.Controller;

@RunWith(ConcordionRunner.class)
public class visualitzarEpisodi {
    private Controller controlador;

    @BeforeExample
    public void init() {
        controlador = new Controller();
        controlador.iniCarteraClients();
    }

    public boolean visualitzarEpisodi(String idserie, String idtemporada, String titolEpisodi,String clientName, String username) {
        return controlador.visualitzarEpisodi(idserie, idtemporada, titolEpisodi, clientName, username);
    }
}
