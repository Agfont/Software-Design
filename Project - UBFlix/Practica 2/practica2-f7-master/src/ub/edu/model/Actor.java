package ub.edu.model;

public class Actor extends Artist {
    public Actor(String id, String realName, String nacionalitat) {
        super(id, realName, nacionalitat);
    }

    public String toString() {
        return "Actor: " + getRealName() + " Nacionalitat: " + getNacionalitat();
    }
}
