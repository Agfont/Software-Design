package ub.edu.resources.dao;

import ub.edu.model.Client;
import ub.edu.model.Usuari;
import java.util.List;

public interface DAOClient extends DAO<Client> {
    public Client  findClientByUserNAmeAndPassword(String usuari, String pwd) throws Exception;
    public List<Usuari> getAllUsuaris(String idClient) throws Exception;
}
