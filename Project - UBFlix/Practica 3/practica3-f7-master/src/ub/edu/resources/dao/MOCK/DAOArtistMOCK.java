package ub.edu.resources.dao.MOCK;

import ub.edu.model.Artist;
import ub.edu.resources.dao.DAOArtist;

import java.util.*;

public class DAOArtistMOCK implements DAOArtist {
    private Map<String, Artist> listArtistes = new HashMap<>();
    @Override
    public Optional<Artist> getById(String id) throws Exception {
        return Optional.ofNullable(listArtistes.get(id));
    }

    @Override
    public List<Artist> getAll() throws Exception {
        return new ArrayList<>(listArtistes.values());
    }

    @Override
    public boolean add(Artist artist) throws Exception {
        if (listArtistes.containsKey(artist.getId())) {
            return false;
        }else {
            listArtistes.put(artist.getId(), artist);
            return true;
        }
    }

    @Override
    public boolean update(Artist artist, String[] params) throws Exception {
        return false;
    }

    @Override
    public boolean delete(Artist artist) throws Exception {
        return listArtistes.remove(artist.getId()) != null;
    }
}
