/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

/**
 *
 * @author anna
 */
public class Login {
    public boolean validatePassword(String username, String password) {
        return username.equals("johndoe") && password.equals("123abc!@#");
    }
}
