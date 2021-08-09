package ub.edu.model;

import java.util.ArrayList;
import java.util.List;

public class CatalegSeries {
    private ArrayList<Serie> series;

    public CatalegSeries() {
        series = new ArrayList<>();
    }

    public CatalegSeries(List<Serie> list) {
        this.series = (ArrayList<Serie>) list;
    }

    public void addSerie(Serie serie){
        if (!series.contains(serie)){
            series.add(serie);
        }
    }

    public ArrayList<Serie> getSeries() {
        return series;
    }

    public Serie getSerie(String idSerie) {
        int i = 0;
        boolean trobat = false;
        while (i < series.size() && !trobat) {
            if (series.get(i).getId().equals(idSerie)) {
                trobat = true;
            }
            else { i+=1;}
        }
        if (trobat) {
            return series.get(i);
        }
        else { return null; }
    }
}
