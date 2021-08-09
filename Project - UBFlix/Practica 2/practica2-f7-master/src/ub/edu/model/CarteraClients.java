package ub.edu.model;

import java.util.List;

public class CarteraClients {
    private List<Client> llista;

    public CarteraClients(List<Client> allClients) {
        llista = allClients;
    }

    public Client find(String username) {

        for (Client c : llista) {
            if (c.getClientName().equals(username)) return c;
        }
        return null;

    }

    public String getInformationClient(String username) {
        for (Client c : llista) {
            if (c.getClientName().equals(username)) return c.getPwd();
        }
        return "User Unknown";

    }

    public String addClient(String username, String password) {
        if (find(username) == null) {
            Client c = new Client(username, password);
            llista.add(c);

            return "User Created";
        }
        else return "The user already exist";
    }

    public Usuari getUser(String clientName, String userName) {
        if (find(clientName) != null) {
            Usuari u = find(clientName).getUsuari(userName);
            return u;
        }
        return null;
    }
}