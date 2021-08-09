package ub.edu.controller;

import ub.edu.model.*;
import ub.edu.resources.service.AbstractFactoryData;
import ub.edu.resources.service.DataService;
import ub.edu.resources.service.FactoryMOCK;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    private AbstractFactoryData factory;      // Origen de les dades
    private DataService dataService;         // Connexio amb les dades
    private CarteraClients carteraClients;   // Model
    private CatalegSeries catalegSeries;


    public Controller() {
        factory = new FactoryMOCK();
        dataService = new DataService(factory);
        iniCarteraClients();
        initCatalegSeries();
    }

    public boolean validateClient(String username, String password) {
        return dataService.getClientByUsuariAndPassword(username, password) != null;
    }

    public boolean iniCarteraClients() {
        List<Client> l = dataService.getAllClients();
        if (l!=null) {
            carteraClients = new CarteraClients(l);
            return true;
        }
        else  return false;
    }
    private boolean initCatalegSeries() {
        List<Serie> l = dataService.getAllSeries();
        if (l!=null) {
            catalegSeries = new CatalegSeries(l);
            return true;
        }
        else  return false;
    }

    public String isValidNameClient(String username) {
        Client client = carteraClients.find(username);
        if (client!=null) return "Valid Client";
        else return "Client Unknown";
    }

    public String getInformationClient(String username) {
        return carteraClients.getInformationClient(username);
    }

    public String createClient(String username, String password) {

        return carteraClients.addClient(username, password);
    }
    public String createUser(String clientname, String username) {
        Client client = carteraClients.find(clientname);
        if (client!=null) return client.addUser(username);
        else return "Client Unknown";
    }
    public boolean isValidUser(String clientname, String username){
        Client client = carteraClients.find(clientname);
        if (client!=null) return client.exist((username));
        else return false;
    }
    public String getInformationProfile (String username){
        Client client = carteraClients.find(username);
        String info;
        if (client != null) {
            info = client.toString();
        }
        else {
            info = "Client Unknown";
        }
        return info;
    }

    public ArrayList<String> llistarCataleg() {
        List<Serie> l = dataService.getAllSeries();
        ArrayList<String> sortida = new ArrayList<>();
        if(l.isEmpty()) return null;
        else {
            for(Serie s : l) sortida.add(s.toString());
            return sortida;
        }
    }

    public ArrayList<String> detallsSerie(String idSerie) {
        if(catalegSeries.getSerie(idSerie)==null) {
            return null;
        }
        Serie s = catalegSeries.getSerie(idSerie);
        ArrayList<String> datos = new ArrayList<>();
        datos.add(s.getTitol());
        datos.add(s.getDescripcio());
        datos.add(s.getArtists().toString());
        datos.add(s.getProductora().toString());
        datos.add(s.getAllTemporades().toString());
        return datos;

    }

    public Usuari getUser(String clientName, String userName) {
        return carteraClients.getUser(clientName, userName);
    }

    public boolean afegirSerieMyList(String clientName, String userName, String idSerie) {
        int i = 0;
        Client c = carteraClients.find(clientName);
        if(c != null){
            Usuari u = getUser(clientName, userName);
            if (u != null) {
                Serie serie = catalegSeries.getSerie(idSerie);
                if (serie != null) {
                    u.afegirMyList(serie);
                    return true;
                }
            }
        }
        return false;
    }

    public ArrayList<Serie> getWatchedList(String clientName, String userName) {
        Usuari u = getUser(clientName, userName);
        if (u != null) {
            return u.getWatchedList();
        }
        else{
            return null;
        }
    }

    public ArrayList<Serie> getContinueWatchingList(String clientName, String userName) {
        Usuari u = getUser(clientName, userName);
        if (u != null) {
            return u.getContinueWatchingList();
        }
        else{
            return null;
        }
    }

    public ArrayList<Serie> getMyList(String clientName, String userName) {
        Usuari u = getUser(clientName, userName);
        if (u != null) {
            return u.getMyList();
        }
        else{
            return null;
        }
    }

    public boolean valorarEpisodi(String serie, String temporada, String titolEpisodi, String clientName, String username, int valoracio) {
        Serie s = catalegSeries.getSerie(serie);
        if(s != null) {
            Temporada temp = s.getTemporada(temporada);
            if(temp != null) {
                Episodi ep = temp.getEpisodi(titolEpisodi);
                if (ep != null) {
                    Usuari usuari = getUser(clientName, username);
                    if (usuari != null) {
                        catalegSeries.getSerie(serie).getTemporada(temporada).getEpisodi(titolEpisodi).addValoracio(valoracio, username);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean visualitzarEpisodi(String serie, String temporada, String titolEpisodi, String clientName, String username) {
        Serie s = catalegSeries.getSerie(serie);
        if(s != null) {
            Temporada temp = s.getTemporada(temporada);
            if(temp != null) {
                Episodi ep = temp.getEpisodi(titolEpisodi);
                if (ep != null) {
                    Usuari usuari = getUser(clientName, username);
                    if (usuari != null) {
                        ep.play(clientName, username, new VisualitzacioEpisodi());
                        return true;
                    }
                }
            }
        }
        return false;
    }
}