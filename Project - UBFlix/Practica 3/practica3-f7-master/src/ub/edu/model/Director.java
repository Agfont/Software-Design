package ub.edu.model;

public class Director extends Artist{
    public Director(String id, String realName, String nacionalitat) {
        super(id, realName, nacionalitat);
    }

    @Override
    public String toString() {
        return "Director: " + getRealName() + " Nacionalitat: " + getNacionalitat();
    }
}

