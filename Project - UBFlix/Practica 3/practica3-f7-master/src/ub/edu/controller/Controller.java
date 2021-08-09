package ub.edu.controller;

import ub.edu.model.*;
import ub.edu.resources.service.AbstractFactoryData;
import ub.edu.resources.service.DataService;
import ub.edu.resources.service.FactoryMOCK;
import ub.edu.view.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Controller {

    private AbstractFactoryData factory;      // Origen de les dades
    private DataService dataService;         // Connexio amb les dades
    private CarteraClients carteraClients;   // Model
    private CatalegSeries catalegSeries;     // Model
    private UBFLIX ubflix;   // -- GUI (JFrame)
    private String currentClient;
    private String currentUser;

    private volatile static Controller uniqueInstance; // --- Singleton Pattern

    public Controller() { }

    public static Controller getInstance() {
        if (uniqueInstance == null) {
            synchronized (Controller.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new Controller();
                    uniqueInstance.factory = new FactoryMOCK();
                    uniqueInstance.dataService = new DataService(uniqueInstance.factory);
                    uniqueInstance.iniCarteraClients();
                    uniqueInstance.initCatalegSeries();
                    uniqueInstance.ubflix = new UBFLIX(uniqueInstance);
                }
            }
        }
        return uniqueInstance;
    }

    public boolean validateClient(String username, String password) {
        return dataService.getClientByUsuariAndPassword(username, password) != null;
    }
    public boolean canCreateUsers(String clientname,String pass){
        Client c = dataService.getClientByUsuariAndPassword(clientname, pass);
        if(c.getNumUsers() < 5) return true;
        return false;
    }

    public String getCurrentClient() { return currentClient; }

    public String[] getMostWatchedSeries() {
        Map<String, Integer> seriesWatched = new  HashMap<String, Integer>();
        List<Client> clients = carteraClients.getAllClients();
        String topSerie = null;
        String[] topSeries = new String[10];
        for(Client c : clients) {
            List<Usuari> users = c.getAllUsers();
            for(Usuari u : users) {
                List<Serie> watchedSeries = u.getWatchedList();
                for(Serie s : watchedSeries) {
                    if (seriesWatched.containsKey(s.toString())){
                        seriesWatched.put(s.toString(), seriesWatched.get(s.toString()) + 1);
                    }else {
                        seriesWatched.put(s.toString(), 1);
                    }
                }
            }
        }
        int views;
        for(int i = 0; i<10; i++){
            views = 0;
            for (Map.Entry<String, Integer> entry : seriesWatched.entrySet()) {
                if (entry.getValue() > views) {
                    views = entry.getValue();
                    topSerie = entry.getKey();
                }
            }
            seriesWatched.remove(topSerie);
            topSeries[i] = topSerie;
        }
        return topSeries;
    }

    public String[] getMostLikedSeries() {
        Map<String, Integer> seriesLiked = new  HashMap<String, Integer>();
        List<Client> clients = carteraClients.getAllClients();
        String topSerie = null;
        Integer numEps;
        String[] topSeries = new String[10];
        for(Serie s : catalegSeries.getSeries()) {
            numEps = 0;
            List<Temporada> temporades = s.getAllTemporades();
            for(Temporada t : temporades) {
                List<Episodi> episodis = t.getAllEpisodis();
                for(Episodi e : episodis) {
                    if (seriesLiked.containsKey(s.toString())){
                        seriesLiked.put(s.toString(), seriesLiked.get(s.toString()) + e.getValoracioMitja());
                        numEps += 1;
                    }else {
                        seriesLiked.put(s.toString(), e.getValoracioMitja());
                        numEps += 1;
                    }
                }
            }
            seriesLiked.put(s.toString(), seriesLiked.get(s.toString())/numEps);
        }
        int valoracio;
        for(int i = 0; i<10; i++){
            valoracio = 0;
            for (Map.Entry<String, Integer> entry : seriesLiked.entrySet()) {
                if (entry.getValue() > valoracio) {
                    valoracio = entry.getValue();
                    topSerie = entry.getKey();
                }
            }
            seriesLiked.remove(topSerie);
            topSeries[i] = topSerie;
        }
        return topSeries;
    }

    public void setCurrentClient(String currentClient) { this.currentClient = currentClient; }

    public void setCurrentUser(String currentUser) { this.currentUser = currentUser; }

    public String getCurrentUser() { return this.currentUser; }

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

    public String isValidNameClient(String username) { return carteraClients.isValidNameClient(username); }

    public String getInformationClient(String username) {
        return carteraClients.getInformationClient(username);
    }

    public String createClient(String username, String password) { return carteraClients.addClient(username, password); }

    public String createUser(String clientname, String username) { return carteraClients.createUser(clientname, username); }

    public boolean isValidUser(String clientname, String username){ return carteraClients.isValidUser(clientname, username); }

    public String getInformationProfile (String username){ return carteraClients.getInformationProfile(username); }

    public ArrayList<String> llistarCataleg() {
        List<Serie> l = dataService.getAllSeries();
        ArrayList<String> sortida = new ArrayList<>();
        if(l.isEmpty()) return null;
        else {
            for(Serie s : l) sortida.add(s.toString());
            return sortida;
        }
    }

    public ArrayList<String> getTemporades(String idSerie) {
        Serie s = catalegSeries.getSerie(idSerie);
        ArrayList<Temporada> temps = s.getAllTemporades();
        ArrayList<String> sortida = new ArrayList<>();
        if(temps == null) {
            return null;
        }
        else {
            for(Temporada t : temps) sortida.add(t.toString());
            return sortida;
        }
    }

    public Serie getSerie(String idSerie) {
        return catalegSeries.getSerie(idSerie);
    }

    public ArrayList<String> getEpisodis(String titolSerie, String idTemp) {
        Serie s = catalegSeries.getSerie(titolSerie);
        Temporada temp = s.getTemporada(idTemp);
        ArrayList<Episodi> episodis = temp.getAllEpisodis();
        ArrayList<String> sortida = new ArrayList<>();
        if(episodis == null) {
            return null;
        }
        else {
            for(Episodi e : episodis) sortida.add(e.getTitol());
            return sortida;
        }
    }


    public ArrayList<String> detallsSerie(String idSerie) {
        Serie s = catalegSeries.getSerie(idSerie);
        if(s == null) {
            return null;
        }
        ArrayList<String> datos = new ArrayList<>();
        datos.add(s.getTitol());
        datos.add(s.getDescripcio());
        datos.add(s.getArtists().toString());
        datos.add(s.getProductora().toString());
        datos.add(s.getAllTemporades().toString());
        return datos;

    }

    public Usuari getUser(String clientName, String userName) { return carteraClients.getUser(clientName, userName); }

    public ArrayList <String> getUsers(String clientName) { return carteraClients.getUsers(clientName); }


    public boolean afegirSerieMyList(String clientName, String userName, String idSerie) {
        Usuari u = carteraClients.getUser(clientName, userName);
        Serie s = catalegSeries.getSerie(idSerie);
        if (u != null && s != null) {
            u.afegirMyList(s);
            return true;
        }
        else return false;
    }

    public ArrayList<String> getWatchedList(String clientName, String userName) {
        Usuari u = getUser(clientName, userName);
        if (u != null) {
            ArrayList<Serie> l = u.getWatchedList();
            ArrayList<String> sortida = new ArrayList<>();
            for(Serie s: l) sortida.add(s.toString());
            return sortida;
        }
        else return null;
    }

    public ArrayList<String> getContinueWatchingList(String clientName, String userName) {
        Usuari u = getUser(clientName, userName);
        if (u != null) {
            ArrayList<Serie> l = u.getContinueWatchingList();
            ArrayList<String> sortida = new ArrayList<>();
            for(Serie s: l) sortida.add(s.toString());
            return sortida;
        }
        else return null;
    }

    public ArrayList<String> getMyList(String clientName, String userName) {
        Usuari u = getUser(clientName, userName);
        if (u != null) {
            ArrayList<Serie> l = u.getMyList();
            ArrayList<String> sortida = new ArrayList<>();
            for(Serie s: l) sortida.add(s.toString());
            return sortida;
        }
        else return null;
    }

    public boolean valorarEpisodi(String serie, String temporada, String titolEpisodi, String clientName, String username, int valoracio) {
        Episodi ep =  catalegSeries.findEpisodi(serie, temporada, titolEpisodi);
        Usuari usuari = getUser(clientName, username);
        if (ep != null && usuari != null) {
            ep.addValoracio(valoracio,username);
            return true;
        }
        else return false;
    }

    public boolean visualitzarEpisodi(String serie, String temporada, String titolEpisodi, String clientName, String username) {
        Episodi ep =  catalegSeries.findEpisodi(serie, temporada, titolEpisodi);
        Usuari usuari = getUser(clientName, username);
        if (ep != null && usuari != null) {
            ep.play(clientName, username, new VisualitzacioEpisodi());
            return true;
        }
        else return false;
    }
}