package ub.edu.spec.valoracioEpisodi;


import org.concordion.api.BeforeExample;
    import org.concordion.integration.junit4.ConcordionRunner;
    import org.junit.runner.RunWith;
    import ub.edu.controller.Controller;

@RunWith(ConcordionRunner.class)
public class valoracioEpisodi {
    private Controller controlador;

    @BeforeExample
    public void init() {
        controlador = new Controller();
        controlador.iniCarteraClients();
    }

    public boolean valorarEpisodi(String idserie, String idtemporada, String titolEpisodi,String clientName, String username, int valoracio) {
        return controlador.valorarEpisodi(idserie, idtemporada, titolEpisodi, clientName, username, valoracio);
    }
}
