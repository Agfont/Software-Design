package ub.edu.model;
import java.util.ArrayList;


public class Client {
    private String id;
    private boolean vip;
    private String dni;
    private String adreça;
    private String clientName;
    private String pwd;
    private ArrayList<Usuari> llista;
    private int nombreUsuaris;
    private static final int MAX_USUARIS = 5;

    public Client(String clientName, String pwd, String id, boolean vip, String dni, String adreça, ArrayList<Usuari> llista) {
        this.id = id;
        this.vip = vip;
        this.dni = dni;
        this.adreça = adreça;
        this.clientName = clientName;
        this.pwd = pwd;
        this.llista = llista;
    }

    public Client(String clientName, String pwd, String id, boolean vip, String dni, String adreça) {
        this.id = id;
        this.vip = vip;
        this.dni = dni;
        this.adreça = adreça;
        this.clientName = clientName;
        this.pwd = pwd;
        this.llista = new ArrayList<>();
    }

    public Client(String clientName, String pwd) {
        this.clientName = clientName;
        this.pwd = pwd;
    }

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public boolean isVip() { return vip; }

    public void setVip(boolean vip) { this.vip = vip; }

    public String getDni() { return dni; }

    public void setDni(String dni) { this.dni = dni; }

    public String getAdreça() { return adreça; }

    public void setAdreça(String adreça) { this.adreça = adreça; }

    public String getClientName() { return clientName; }

    public void setClientName(String clientName) { this.clientName = clientName; }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public boolean exist(String nom) {
        boolean trobat = false;
        for (Usuari u : llista) {
            if (u.getName().equals(nom)) {
                trobat = true;
            }
        }
        return trobat;
    }

    public String addUser(String username) {
        if (nombreUsuaris < MAX_USUARIS) {
            if (!exist(username)) {
                Usuari nouUsuari = new Usuari(username);
                llista.add(nouUsuari);
                nombreUsuaris += 1;
                return "User Created";
            } else {
                return "The user already exist";
            }
        } else {
            return "Users limit reached";
        }
    }

    public ArrayList<Usuari> getAllUsers() {
        if (!llista.isEmpty()) {
            return llista;
        }
        else return null;
    }

    public Usuari getUsuari(String nom) {
        int i = 0;
        boolean trobat = false;
        while (i < llista.size() && !trobat) {
            if (llista.get(i).getName().equals(nom)) {
                trobat = true;
            }
            else { i+=1;}
        }
        if (trobat) {
            return llista.get(i);
        }
        else { return null; }
    }

    public String toString() {
        return "Name: " + clientName + " Pass: " + pwd + " Usuaris: " + llista.toString() + " DNI: " + dni + " Adreça: " + adreça;
    }
}