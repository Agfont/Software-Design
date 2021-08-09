package ub.edu.resources.dao.MOCK;

import ub.edu.model.Client;
import ub.edu.model.Usuari;
import ub.edu.resources.dao.DAOUsuari;

import java.util.*;

public class DAOUsuariMOCK implements DAOUsuari {

    private Map<String, Usuari> listUsuaris = new HashMap<>();

    public DAOUsuariMOCK() {
    }

    @Override
    public Optional getById(String id) throws Exception { return Optional.ofNullable(listUsuaris.get(id)); }

    @Override
    public List<Usuari> getAll() throws Exception { return new ArrayList<>(listUsuaris.values()); }

    @Override
    public boolean add(Usuari usuari) throws Exception {
        if (listUsuaris.containsKey(usuari.getName())) {
            return false;
        }else {
            listUsuaris.put(usuari.getName(), usuari);
            return true;
        }
    }
    @Override
    public boolean update(Usuari usuari, String[] params)  {
        return false;
    }

    @Override
    public boolean delete(Usuari usuari) throws Exception { return listUsuaris.remove(usuari.getName()) != null; }

}
