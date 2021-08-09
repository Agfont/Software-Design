package ub.edu.resources.dao.MOCK;

import ub.edu.model.*;
import ub.edu.resources.dao.DAOSerie;
import ub.edu.resources.dao.DAOTemporada;

import javax.xml.crypto.Data;
import java.util.*;

public class DAOSerieMOCK implements DAOSerie {

    private Map<String, Serie> idToSerie = new HashMap<>();

    public DAOSerieMOCK() {
        init();
    }
    public void init () {
        //1a Serie
        Director artist1 = new Director("1", "V.Gilligan", "EEUU");
        Actor artist2 = new Actor("2", "B.Cranston", "EEUU");
        Actor artist3 = new Actor("3", "A.Paul", "EEUU");
        Actor artist4 = new Actor("4", "D.Norris", "EEUU");

        ArrayList<Artist> listArtist = new ArrayList<Artist>();
        listArtist.add(artist1);
        listArtist.add(artist2);
        listArtist.add(artist3);
        listArtist.add(artist4);

        Productora productora = new Productora("1", "AMC:Gran_Via_Productions");

        DurationEpisodi dur = new DurationEpisodi(55, 00, 00);
        DataEpisodi data = new DataEpisodi(20, 01, 2008);
        Episodi ep1 = new Episodi("Piloto", dur, "VOSE", "Walter White, era un famoso investigador quӭico de un prestigioso Laboratorio del Gobierno, que a dӡ de hoy ha sido relegado a enseסr a apȴicos estudiantes de un Instituto en Albuquerque. Para poder llegar a fin de mes tambiϮ tiene un trabajo a media jornada en un lavadero de coches. Ademȳ, Ϭ y su esposa, Skyler, una mujer que se ha forjado una modesta carrera en la compra-venta de artӣulos por eBay, estȮ criando a Walter, Jr., un joven de diecisiete años, con una gran fuerza de voluntad, que tiene parȬisis cerebral lo que presenta un continuo reto para la familia. Pero todas estas dificultades palidecen en relaciخ con el nuevo descubrimiento de Walter: tiene cȮcer con un pronسtico de dos años de vida.",
                data);

        ArrayList<Episodi> eps = new ArrayList<>();
        eps.add(ep1);

        Temporada temp = new Temporada(1, eps,1, "0");

        ArrayList<Temporada> temps = new ArrayList<>();
        temps.add(temp);

        idToSerie.put("Breaking Bad", new Serie("bbad", "Breaking Bad", "Tras cumplir 50 a\u05EFs, Walter White (Bryan Cranston), un profesor de quӭica de un instituto de Albuquerque, Nuevo Mϸico, se entera de que tiene un cȮcer de pulmخ incurable. Casado con Skyler (Anna Gunn) y con un hijo discapacitado (RJ Mitte), la brutal noticia lo impulsa a dar un drȳtico cambio a su vida: decide, con la ayuda de un antiguo alumno (Aaron Paul), fabricar anfetaminas y ponerlas a la venta. Lo que pretende es liberar a su familia de problemas econحicos cuando se produzca el fatal desenlace",
                listArtist, productora, temps));

        // 2a Serie
        Director director1 = new Director("5", "S.Esmail", "EEUU");
        Actor actor1 = new Actor("6", "R.Malek", "EEUU");
        Actor actor2 = new Actor("7", "C.Slater", "EEUU");

        Productora productora2 = new Productora("2", "USA_Network_Universal_Cable_Productions");

        ArrayList<Artist> listArtist2 = new ArrayList<Artist>();
        listArtist2.add(director1);
        listArtist2.add(actor1);
        listArtist2.add(actor2);

        DurationEpisodi dur2 = new DurationEpisodi(45, 00, 00);
        DataEpisodi data2 = new DataEpisodi(24, 06, 2015);
        Episodi ep2 = new Episodi("eps1.0_hellofriend.mov", dur2, "ES", "WElliot Alderson trabaja en Allsafe, una empresa de seguridad informȴica. Por la noche, se dedica a hackear las cuentas de redes sociales y bancarias de sus amigos",
                data2);
        ArrayList<Episodi> eps2 = new ArrayList<Episodi>();
        eps2.add(ep2);
        Temporada temp2 = new Temporada(1, eps2,1, "0");
        ArrayList<Temporada> temps2 = new ArrayList<>();
        temps2.add(temp2);

        idToSerie.put("Mr Robot", new Serie("mrobot", "Mr Robot", "Elliot Anderson es un joven y brillante programador con problemas para las relaciones sociales que durante el dӡ trabaja como tϣnico de ciberseguridad de una importante empresa informȴica y por la noche es un desinteresado justiciero cibernϴico, que se verǠenvuelto en una oscura trama.",
                listArtist2, productora2, temps2));
    }
    @Override
    public List<Serie> getAll() {
        return new ArrayList<>(idToSerie.values());
    }

    @Override
    public Optional<Serie> getById(String id) {
        return Optional.ofNullable(idToSerie.get(id));
    }

    @Override
    public boolean add(final Serie serie) {
        if (getById(serie.getTitol()).isPresent()) {
            return false;
        }
        idToSerie.put(serie.getTitol(), serie);
        return true;
    }

    @Override
    public boolean update(final Serie serie, String[] params) {
        serie.setTitol(Objects.requireNonNull(
                params[0], "Title cannot be null"));
        serie.setDescripcio(Objects.requireNonNull(
                params[1], "Description cannot be null"));
        return idToSerie.replace(serie.getTitol(), serie) != null;
    }

    @Override
    public boolean delete(final Serie serie) {
        return idToSerie.remove(serie.getTitol()) != null;
    }

    @Override
    public List<Temporada> getAllTemporades(String idSerie) throws Exception {
        if (getById(idSerie).isPresent()) {
            Serie c = idToSerie.get(idSerie);
            return c.getAllTemporades();
        }
        else{
            return null;
        }
    }

    @Override
    public List<Episodi> getAllEpisodis(String idSerie, String idTemporada) throws Exception {
        return null;
    }

    @Override
    public List<Artist> getAllArtistes(String idSerie) throws Exception {
        return null;
    }

    @Override
    public List<Productora> getAllProductores(String idSerie) throws Exception {
        return null;
    }

    @Override
    public List<Tematica> getAllTematiques(String idSerie) throws Exception {
        return null;
    }

    @Override
    public List<Director> getAllDirectors(String idSerie) throws Exception {
        return null;
    }
}
