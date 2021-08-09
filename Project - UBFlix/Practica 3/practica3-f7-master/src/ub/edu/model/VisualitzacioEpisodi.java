package ub.edu.model;


import java.util.Random;

public class VisualitzacioEpisodi {
    public VisualitzacioEpisodi() {}

    public DurationEpisodi play(Episodi episodi, DurationEpisodi inici) {
        // Si tinguessim un reproductor real agafariam inici
        Random temps = new Random();
        int horesMax = episodi.getDuration().getHour();
        int minutsMax = episodi.getDuration().getHour();
        int segonsmax = episodi.getDuration().getHour();
        int hores = temps.nextInt(horesMax);
        int minuts = temps.nextInt(minutsMax);
        int segons = temps.nextInt(segonsmax);
        DurationEpisodi tempsVist = new DurationEpisodi(hores, minuts, segons);
        return tempsVist;
    }
}
