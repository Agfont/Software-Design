package ub.edu.model;

public class Adreça {
    private String direcio;
    private int nombre;
    private int codi;
    private String ciutat;

    public Adreça(String direcio, int nombre, int codi, String ciutat) {
        this.direcio = direcio;
        this.nombre = nombre;
        this.codi = codi;
        this.ciutat = ciutat;
    }

    public String getDirecio() {
        return direcio;
    }

    public void setDirecio(String direcio) {
        this.direcio = direcio;
    }

    public int getNombre() {
        return nombre;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }

    public int getCodi() {
        return codi;
    }

    public void setCodi(int codi) {
        this.codi = codi;
    }

    public String getCiutat() {
        return ciutat;
    }

    public void setCiutat(String ciutat) {
        this.ciutat = ciutat;
    }
}
