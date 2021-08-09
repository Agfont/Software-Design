package ub.edu.model;

import java.util.ArrayList;
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

    public List<Client> getAllClients() {
        return llista;
    }

    public Usuari getUser(String clientName, String userName) {
        if (find(clientName) != null) {
            Usuari u = find(clientName).getUsuari(userName);
            return u;
        }
        return null;
    }

    public String isValidNameClient(String username) {
        Client client = this.find(username);
        if (client!=null) return "Valid Client";
        else return "Client Unknown";
    }

    public String createUser(String clientname, String username) {
        Client client = this.find(clientname);
        if (client!=null) return client.addUser(username);
        else return "Client Unknown";
    }

    public boolean isValidUser(String clientname, String username){
        Client client = this.find(clientname);
        if (client!=null) return client.exist((username));
        else return false;
    }

    public String getInformationProfile (String username){
        Client client = this.find(username);
        String info;
        if (client != null) info = client.toString();
        else info = "Client Unknown";
        return info;
    }

    public ArrayList<String> getUsers(String clientname){
        Client client = this.find(clientname);
        ArrayList<Usuari> users = client.getAllUsers();
        ArrayList<String> sortida = new ArrayList<>();
        if (client != null) {
            for(Usuari u : users) sortida.add(u.getName());
        }
        return sortida;
    }
}