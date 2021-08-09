package ub.edu.resources.dao.MOCK;

import ub.edu.model.*;
import ub.edu.resources.dao.DAOEpisodi;

import java.util.*;

public class DAOEpisodiMOCK implements DAOEpisodi {
    private Map<String, Episodi> listEpisodis = new HashMap<>();

    public DAOEpisodiMOCK(){
        DurationEpisodi dur = new DurationEpisodi(55, 0, 0);
        DataEpisodi data = new DataEpisodi(20, 1, 2008);
        Episodi ep1 = new Episodi("Piloto", dur, "VOSE", "Walter White, era un famoso investigador quӭico de un prestigioso Laboratorio del Gobierno, que a dӡ de hoy ha sido relegado a enseסr a apȴicos estudiantes de un Instituto en Albuquerque. Para poder llegar a fin de mes tambiϮ tiene un trabajo a media jornada en un lavadero de coches. Ademȳ, Ϭ y su esposa, Skyler, una mujer que se ha forjado una modesta carrera en la compra-venta de artӣulos por eBay, estȮ criando a Walter, Jr., un joven de diecisiete años, con una gran fuerza de voluntad, que tiene parȬisis cerebral lo que presenta un continuo reto para la familia. Pero todas estas dificultades palidecen en relaciخ con el nuevo descubrimiento de Walter: tiene cȮcer con un pronسtico de dos años de vida.",
                data);
        listEpisodis.put("Piloto", ep1);
    }
    @Override
    public Optional<Episodi> getById(String id) { return Optional.ofNullable(listEpisodis.get(id)); }

    @Override
    public ArrayList<Episodi> getAll() {
        return new ArrayList<>(listEpisodis.values());
    }

    @Override
    public boolean add(Episodi episodi) throws Exception {
        if (listEpisodis.containsKey(episodi.getTitol())) {
            return false;
        } else {
            listEpisodis.put(episodi.getTitol(), episodi);
            return true;
        }
    }

    @Override
    public boolean update(Episodi episodi, String[] params) throws Exception {
        return false;
    }

    @Override
    public boolean delete(Episodi episodi) throws Exception { return listEpisodis.remove(episodi.getTitol()) != null; }
}
