package ub.edu.model;

import java.util.ArrayList;

public class Serie {
    private String id;
    private String titol;
    private String descripcio;
    private Productora productora;
    private ArrayList<Artist> artists;
    private ArrayList<Temporada> temporades;

    public Serie(String id, String titol, String descripcio, ArrayList<Artist> artists, Productora productora, ArrayList<Temporada> temporades) {
        this.id = id;
        this.titol = titol;
        this.descripcio = descripcio;
        this.artists = artists;
        this.productora = productora;
        this.temporades = temporades;
    }

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public String getTitol() {
        return titol;
    }

    public void setTitol(String titol) {
        this.titol = titol;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    public ArrayList<Artist> getArtists() {
        return artists;
    }

    public Productora getProductora() {
        return productora;
    }

    public void setProductora(Productora productora) {
        this.productora = productora;
    }

    public ArrayList<Temporada> getAllTemporades() {
        return temporades;
    }

    public Temporada getTemporada(String temporada) {
        boolean trobat = false;
        int i = 0;
        Temporada temp = null;
        int numTemporada = Integer.parseInt(temporada);
        while (i < temporades.size() && !trobat) {
            if(temporades.get(i).getNumTemporada() == numTemporada) {
                temp = temporades.get(i);
                trobat = true;
            }else {
                i++;
            }
        }
        return temp;
    }

    public String toString() {
        return titol;
    }

    public Episodi findEpisodi(String temporada, String titolEpisodi) {
        Temporada t = getTemporada(temporada);
        if (t != null) { return t.findEpisodi(titolEpisodi); }
        else return null;
    }
}