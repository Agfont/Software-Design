package ub.edu.model;

public class EstatEnReproduccio extends Estat {

    private DurationEpisodi tempsVist;

    public EstatEnReproduccio(DurationEpisodi tempsVist) {
        super();
        this.tempsVist = tempsVist;
    }

    public DurationEpisodi getTempsVist() { return tempsVist; }

    public void setTempsVist(DurationEpisodi tempsVist) { this.tempsVist = tempsVist; }
}
