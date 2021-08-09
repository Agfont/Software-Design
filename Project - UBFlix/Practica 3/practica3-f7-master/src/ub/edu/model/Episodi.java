package ub.edu.model;


import java.util.ArrayList;
import java.util.HashMap;

public class Episodi {
    private String titol;
    private String descripcio;
    private DurationEpisodi duration;
    private String idioma;
    private DataEpisodi data;
    private int valoracioMitja;
    private HashMap<String,Integer> valoraciones;
    private HashMap<String,Estat> estats;

    public Episodi(String titol, DurationEpisodi duration, String idioma, String descripcio, DataEpisodi data) {
        this.titol = titol;
        this.descripcio = descripcio;
        this.duration = duration;
        this.idioma = idioma;
        this.data = data;
        this.valoracioMitja = 0;
        this.valoraciones = new HashMap<>();
        this.estats = new HashMap<>();
    }

    public String getTitol() { return titol; }

    public void setTitol(String titol) { this.titol = titol; }

    public String getDescripcio() { return descripcio; }

    public void setDescripcio(String descripcio) { this.descripcio = descripcio; }

    public DurationEpisodi getDuration() { return duration; }

    public void setDuration(DurationEpisodi duration) { this.duration = duration; }

    public String getIdioma() { return idioma; }

    public void setIdioma(String idioma) { this.idioma = idioma; }

    public DataEpisodi getData() { return data; }

    public void setData(DataEpisodi data) { this.data = data; }

    public int getValoracioMitja() { return valoracioMitja; }

    public void setValoracioMitja() {
        int valoracioMitja = 0;
        for (int i : valoraciones.values()) {
            valoracioMitja += i;
        }
        valoracioMitja = valoracioMitja/valoraciones.size();
        this.valoracioMitja = valoracioMitja;
    }

    public void addValoracio(int valoracio, String userName) {
        this.valoraciones.put(userName, valoracio);
        this.setValoracioMitja();
    }

    public void play(String clientName, String userName, VisualitzacioEpisodi visualitzacioEpisodi) {
        DurationEpisodi inici = new DurationEpisodi(0, 0, 0);
        if (estats.containsKey(clientName+userName)) {
            inici = estats.get(clientName+userName).getTempsVist();
        }
        DurationEpisodi visualitzacio = null;
        visualitzacio = visualitzacioEpisodi.play(this, inici);
        if (visualitzacio == getDuration()) {
            estats.put(clientName+userName, new EstatVist());
        }else {
            estats.put(clientName+userName, new EstatEnReproduccio(visualitzacio));
        }
    }

    public String toString() {
        return "Titol: " + titol + " Descripcio: " + descripcio + " Idioma: " + idioma + " Valoració mitja: " + valoracioMitja + " Duracio: " + duration.toString();
    }
}
