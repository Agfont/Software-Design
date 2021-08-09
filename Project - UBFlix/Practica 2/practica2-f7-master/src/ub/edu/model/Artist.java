package ub.edu.model;

public abstract class Artist {
    private String id;
    private String realName;
    private String nacionalitat;

    public Artist(String id, String realName, String nacionalitat) {
        this.id = id;
        this.realName = realName;
        this.nacionalitat = nacionalitat;
    }

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public String getRealName() { return realName; }

    public void setRealName(String realName) { this.realName = realName;}

    public String getNacionalitat() { return nacionalitat; }

    public void setNacionalitat(String nacionalitat) { this.nacionalitat = nacionalitat; }

    @Override
    public abstract String toString();
}