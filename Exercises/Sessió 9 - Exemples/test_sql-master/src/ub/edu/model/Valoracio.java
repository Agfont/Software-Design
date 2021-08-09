package ub.edu.model;

public class Valoracio {
    private int id;
    private String idClient;
    private int idUsuari;
    private String idSerie;
    private int idEpisodi;
    private Integer valoracioEstrelles;
    private String valoracioThumb;
    private String data;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdClient() {
        return idClient;
    }

    public void setIdClient(String idClient) {
        this.idClient = idClient;
    }

    public int getIdUsuari() {
        return idUsuari;
    }

    public void setIdUsuari(int idUsuari) {
        this.idUsuari = idUsuari;
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

    public Integer getValoracioEstrelles() {
        return valoracioEstrelles;
    }

    public void setValoracioEstrelles(Integer valoracioEstrelles) {
        this.valoracioEstrelles = valoracioEstrelles;
    }

    public String getValoracioThumb() {
        return valoracioThumb;
    }

    public void setValoracioThumb(String valoracioThumb) {
        this.valoracioThumb = valoracioThumb;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
