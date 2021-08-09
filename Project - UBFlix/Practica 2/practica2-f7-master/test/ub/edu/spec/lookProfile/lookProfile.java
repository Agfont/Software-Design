package ub.edu.spec.lookProfile;

import org.concordion.api.BeforeExample;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;
import ub.edu.controller.Controller;

@RunWith(ConcordionRunner.class)
public class lookProfile {
    private Controller controlador;

    @BeforeExample
    public void init() {
        controlador = new Controller();
        controlador.iniCarteraClients();
    }

    public String informationProfile(String username){ return controlador.getInformationProfile(username);}
}