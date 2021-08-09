package ub.edu.spec.login;

import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;
import ub.edu.model.Controller;

@RunWith(ConcordionRunner.class)
public class login {
    public boolean isValidLogin(String username, String password) {
        Controller controller = new Controller("SQL");
        return controller.validateUsuari(username, password);
    }

}
