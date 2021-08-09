package ub.edu.spec.llistarCataleg;

import org.concordion.api.BeforeExample;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;
import ub.edu.controller.Controller;

import java.util.ArrayList;

@RunWith(ConcordionRunner.class)

public class llistarCataleg {
    private Controller controlador;

    @BeforeExample
    public void init() {
        controlador = new Controller();
    }

    public ArrayList<String> llistarCatalegSeries() {return controlador.llistarCataleg();}

}