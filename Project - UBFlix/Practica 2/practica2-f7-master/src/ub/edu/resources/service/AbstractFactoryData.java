package ub.edu.resources.service;

import ub.edu.resources.dao.*;

public interface AbstractFactoryData {
    public DAOClient createDAOClient();
    public DAOSerie createDAOSerie();
    public DAOArtist createDAOArtist();
    public DAOEpisodi createDAOEpisodi();
    public DAOTemporada createDAOTemporada();
    public DAOUsuari createDAOUsuari();
}
