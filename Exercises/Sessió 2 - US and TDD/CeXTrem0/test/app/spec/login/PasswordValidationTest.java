/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.spec.login;


import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;
import app.Login; // system under design


@RunWith(ConcordionRunner.class)

public class PasswordValidationTest  {

public boolean isValidTest(String username, String password) {

    Login login = new Login();

    return login.validatePassword(username, password);

}

}