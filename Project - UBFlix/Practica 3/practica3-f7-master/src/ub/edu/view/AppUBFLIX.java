package ub.edu.view;
/*
Autors:
* Juan Cano Pradas
* Nil Ballus Riu
* David Rial Fígols
 */

//TODO A moltes classes de la vista, més enllà d'afegir codi on estigui indicat, és probable que hagueu d'implementar nous mètodes. Sort amb la pràctica!

import ub.edu.controller.Controller;

public class AppUBFLIX {
    static Controller control;
    public static void main(String[] args) {
        //TODO Cal crear la GUI a Controller, i aqui tenir instanciat el Controller
        Controller control = Controller.getInstance(); // --- Singleton Pattern
    }

    public static Controller getControl() { return control; }
}
