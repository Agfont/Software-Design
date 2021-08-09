package ub.edu.resources.service;

import ub.edu.resources.dao.*;
import ub.edu.resources.dao.MOCK.*;

public class FactoryMOCK implements AbstractFactoryData {

    @Override
    public DAOClient createDAOClient() { return new DAOClientMOCK(); }

    @Override
    public DAOSerie createDAOSerie() {
        return new DAOSerieMOCK();
    }

    @Override
    public DAOArtist createDAOArtist() { return new DAOArtistMOCK(); }

    @Override
    public DAOEpisodi createDAOEpisodi() { return new DAOEpisodiMOCK(); }

    @Override
    public DAOTemporada createDAOTemporada() { return new DAOTemporadaMOCK(); }

    @Override
    public DAOUsuari createDAOUsuari() { return new DAOUsuariMOCK(); }
}
