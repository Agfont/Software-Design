package ub.edu.resources.dao;

import ub.edu.model.*;

import java.util.List;

public interface DAOSerie extends DAO<Serie> {
    // Metodes especifics de series si es el cas
    public List<Temporada> getAllTemporades(String idSerie) throws Exception;
    public List<Episodi> getAllEpisodis(String idSerie, String idEpisodi) throws Exception;
    public List<Artist> getAllArtistes(String idSerie) throws Exception;
    public List<Productora> getAllProductores (String idSerie) throws Exception;
    public List<Tematica> getAllTematiques (String idSerie) throws Exception;
    public List<Director> getAllDirectors (String idSerie) throws Exception;
}
