package ub.edu.spec.veureMyList;
import org.concordion.api.BeforeExample;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;
import ub.edu.controller.Controller;
import ub.edu.model.Serie;

import java.util.ArrayList;

@RunWith(ConcordionRunner.class)
public class veureMyList {
    private Controller controlador;

    @BeforeExample
    public void init() {
        controlador = new Controller();
    }

    public ArrayList<String> showMyList(String clientName, String userName) {
        ArrayList<Serie> list;
        ArrayList<String> finalList = new ArrayList<String>();
        list = controlador.getMyList(clientName, userName);
        if (list == null){
            finalList.add("");
        }else {
            for (Serie serie : list) {
                finalList.add(serie.toString());
            }
        }
        return finalList;
    }
}