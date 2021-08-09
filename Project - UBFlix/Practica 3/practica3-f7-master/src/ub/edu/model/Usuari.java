package ub.edu.model;

import java.util.ArrayList;

public class Usuari {
    private String client;
    private String nom;
    private ArrayList<Serie> myList;
    private ArrayList<Serie> watchedList;
    private ArrayList<Serie> continueWatchingList;

    public Usuari(String nom) {
        this.nom = nom;
        this.myList = new ArrayList<>();
        this.watchedList = new ArrayList<>();
        this.continueWatchingList = new ArrayList<>();
    }

    public Usuari(String client, String nom) {
        this.client = client;
        this.nom = nom;
        this.myList = new ArrayList<>();
        this.watchedList = new ArrayList<>();
        this.continueWatchingList = new ArrayList<>();
    }

    public String getName() { return nom; }

    public void setName(String nom) {
        this.nom = nom;
    }

    public String getClient() { return client; }

    public void setClient(String client) { this.client = client; }

    public ArrayList<Serie> getMyList() {
        return myList;
    }

    public ArrayList<Serie> getWatchedList() { return watchedList;}

    public ArrayList<Serie> getContinueWatchingList() { return continueWatchingList; }

    public void afegirMyList(Serie serie) { myList.add(serie); }

    public void afegirContinueWatchingList (Serie serie) { continueWatchingList.add(serie); }

    public void afegirWatchedList (Serie serie) { watchedList.add(serie); }

    public void treureMyList (Serie serie) {
        int index = myList.indexOf(serie);
        if (index != -1){
            myList.remove(index);
        }else {
            System.out.println("La serie no està a la llista");
        }
    }

    public void treureContinueWatchingList (Serie serie) {
        int index = continueWatchingList.indexOf(serie);
        if (index != -1){
            continueWatchingList.remove(index);
        }else {
            System.out.println("La serie no està a la llista");
        }
    }

    @Override
    public String toString() {
        return "Nom: " + nom;
    }
}