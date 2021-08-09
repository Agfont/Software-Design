package ub.edu.model;

public class Visualitzacio {
    private int id;
    private String idUser;
    private String idSerie;
    private int numTemporada;
    private int idEpisodi;
    private String date;
    private int minutsRestants;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getIdSerie() {
        return idSerie;
    }

    public void setIdSerie(String idSerie) {
        this.idSerie = idSerie;
    }

    public int getIdEpisodi() {
        return idEpisodi;
    }

    public void setIdEpisodi(int idEpisodi) {
        this.idEpisodi = idEpisodi;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getNumTemporada() {
        return numTemporada;
    }

    public void setNumTemporada(int numTemporada) {
        this.numTemporada = numTemporada;
    }

    public int getMinutsRestants() {
        return minutsRestants;
    }

    public void setMinutsRestants(int minutsRestants) {
        this.minutsRestants = minutsRestants;
    }
}
