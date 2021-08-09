package ub.edu.model;

import java.util.ArrayList;

public class Temporada {
    private String id;
    private int numTemporada;
    private ArrayList<Episodi> episodis;
    private int numEpisodis;

    public Temporada(int numTemporada, ArrayList<Episodi> episodis, int numEpisodis, String id) {
        this.numTemporada = numTemporada;
        this.numEpisodis = numEpisodis;
        this.episodis = episodis;
        this.id = id;
    }

    public int getNumTemporada() { return numTemporada; }

    public void setNumTemporada(int numTemporada) { this.numTemporada = numTemporada; }

    public ArrayList<Episodi> getAllEpisodis() { return episodis; }

    public Episodi getEpisodi(String episodi) {
        boolean trobat = false;
        int i = 0;
        Episodi ep = null;
        while (i < episodis.size() && !trobat) {
            if(episodis.get(i).getTitol().equals(episodi)) {
                ep = episodis.get(i);
                trobat = true;
            }else {
                i++;
            }
        }
        return ep;
    }

    public int getNumEpisodis() { return numEpisodis; }

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public String toString() {
        return "Temporada " + this.numTemporada + ": " + " Episodis ["+ this.numEpisodis + "]: " + episodis.toString();
    }
}
