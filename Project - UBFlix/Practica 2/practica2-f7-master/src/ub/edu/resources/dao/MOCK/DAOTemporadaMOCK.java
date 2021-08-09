package ub.edu.resources.dao.MOCK;

import ub.edu.model.Temporada;
import ub.edu.resources.dao.DAOTemporada;

import java.util.*;

public class DAOTemporadaMOCK implements DAOTemporada {
    private Map<String, Temporada> idToTemporada = new HashMap<>();

    public DAOTemporadaMOCK(){
        Temporada temp = new Temporada(0, null, 0, "0");
        idToTemporada.put("0", temp);
    }
    @Override
    public Optional<Temporada> getById(String id){ return Optional.ofNullable(idToTemporada.get(id)); }

    @Override
    public List<Temporada> getAll(){
        return new ArrayList<>(idToTemporada.values());
    }

    @Override
    public boolean add(Temporada temporada) {
        if (getById(temporada.getId()).isPresent()) {
            return false;
        }
        idToTemporada.put(temporada.getId(), temporada);
        return true;
    }

    @Override
    public boolean update(Temporada temporada, String[] params) {
        return false;
    }

    @Override
    public boolean delete(Temporada temporada) { return idToTemporada.remove(temporada.getId()) != null; }
}
