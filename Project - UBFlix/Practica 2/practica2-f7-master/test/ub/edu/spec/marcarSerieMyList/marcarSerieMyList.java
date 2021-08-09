package ub.edu.spec.marcarSerieMyList;

import org.concordion.api.BeforeExample;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;
import ub.edu.controller.Controller;

@RunWith(ConcordionRunner.class)
public class marcarSerieMyList {
    private Controller controlador;

    @BeforeExample
    public void init() {
            controlador = new Controller();
            controlador.iniCarteraClients();
    }

    public boolean marcarSerieMyList(String clientName, String userName, String idSerie){
        return controlador.afegirSerieMyList(clientName, userName, idSerie);
    }














}








