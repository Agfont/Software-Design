package ub.edu.resources.service;

import ub.edu.model.*;
import ub.edu.resources.dao.*;

import java.util.List;

public class DataService {
    private DAOSerie serieDAO;
    private DAOClient clientDAO;
    private DAOArtist artistDAO;
    private DAOEpisodi episodiDAO;
    private DAOTemporada temporadaDAO;
    private DAOUsuari usariDAO;

    public DataService(AbstractFactoryData factory) {
        this.serieDAO = factory.createDAOSerie();
        this.clientDAO = factory.createDAOClient();
        this.artistDAO = factory.createDAOArtist();
        this.episodiDAO = factory.createDAOEpisodi();
        this.temporadaDAO = factory.createDAOTemporada();
        this.usariDAO = factory.createDAOUsuari();
        // TO DO: Crear els altres DAO de les altres estructures
    }

    public Client getClientByUsuariAndPassword(String usuari, String password) {
        try {
            return clientDAO.findClientByUserNAmeAndPassword(usuari, password);
        } catch (Exception e) {
            return null;
        }
    }

    public List<Client> getAllClients() {
        try {
            return clientDAO.getAll();
        } catch (Exception e) {
            return null;
        }
    }

    public List<Usuari> getAllUsuaris() {
        try {
            return usariDAO.getAll();
        } catch (Exception e) {
            return null;
        }
    }

    public List<Serie> getAllSeries() {
        try {
            return serieDAO.getAll();
        } catch (Exception e) {
            return null;
        }
    }

    public List<Temporada> getAllTemporades() {
        try {
            return temporadaDAO.getAll();
        } catch (Exception e) {
            return null;
        }
    }
    public List<Episodi> getAllEpisodis() {
        try {
            return episodiDAO.getAll();
        } catch (Exception e) {
            return null;
        }
    }
}

    /*  TO DO
    CAPÇALERES de les FUNCIONS que cal implementar en la pràctica 2 com a DataServices que consultaran dels DAOs corresponents
    les dades que es volen extreure

    public List<Usuari> getAllUsuaris(String idClient)

    public List<Serie> getAllSeries()

    public List<Temporada> getAllTemporades(String idSerie)

    public List<Episodi> getAllEpisodis(String idSerie, String idTemporada)

    public List<Artista> getAllArtistes( String idSerie)

    public List<Productora> getAllProductores (String idSerie)

    public List<Tematica> getAllTematiques (String idSerie)

    public List<Director> getAllDirectors (String idSerie)

    public ValoracioEstrella getValoracioEstrella (String idClient, String idUsuari, String idSerie, String idTemporada, String idEpisodi)

    public ValoracioThumb getValoracioThumb (String idClient, String idUsuari, String idSerie, String idTemporada, String idEpisodi)

    public void setValoracioEstrella( String idClient, String idUsuari, String idSerie, String idTemporada, String idEpisodi,
                                    ValoracioEstrella v, Date data)

    public void setValoracioThumb (String idClient, String idUsuari, String idSerie, String idTemporada, String idEpisodi,
                                    ValoracioThumb v, Date data);

    public bool isFromMyList (String idClient, String idUsuari, String idSerie)

    public void markInMyList (String idClient, String idUsuari, String idSerie)

    public void startWatching (String idClient, String idUsuari,  String idSerie, String idTemporada, String idEpisodi, Date data)

    public void pauseWatching (String idClient, String idUsuari,  String idSerie, String idTemporada, String idEpisodi, String numMinutes)

    public void finishWatching(String idClient, String idUsuari,  String idSerie, String idTemporada, String idEpisodi, Date data)

*/
