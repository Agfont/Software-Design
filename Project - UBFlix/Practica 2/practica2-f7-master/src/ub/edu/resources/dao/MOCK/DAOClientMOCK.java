package ub.edu.resources.dao.MOCK;

import ub.edu.model.*;
import ub.edu.resources.dao.DAOClient;

import java.util.*;

public class DAOClientMOCK implements DAOClient {

    private Map<String, Client> listClients = new HashMap<>();

    public DAOClientMOCK() {
        init();
    }

    public void init () {
        Usuari u1 = new Usuari("ajaleo");

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

        Serie s = new Serie("bbad", "Breaking Bad", "Tras cumplir 50 a\u05EFs, Walter White (Bryan Cranston), un profesor de quӭica de un instituto de Albuquerque, Nuevo Mϸico, se entera de que tiene un cȮcer de pulmخ incurable. Casado con Skyler (Anna Gunn) y con un hijo discapacitado (RJ Mitte), la brutal noticia lo impulsa a dar un drȳtico cambio a su vida: decide, con la ayuda de un antiguo alumno (Aaron Paul), fabricar anfetaminas y ponerlas a la venta. Lo que pretende es liberar a su familia de problemas econحicos cuando se produzca el fatal desenlace",
                listArtist, productora, temps);

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

        Serie s2 = new Serie("mrobot", "Mr Robot", "Elliot Anderson es un joven y brillante programador con problemas para las relaciones sociales que durante el dӡ trabaja como tϣnico de ciberseguridad de una importante empresa informȴica y por la noche es un desinteresado justiciero cibernϴico, que se verǠenvuelto en una oscura trama.",
                listArtist2, productora2, temps2);

        u1.afegirMyList(s);
        u1.afegirMyList(s2);

        u1.afegirContinueWatchingList(s);
        u1.afegirContinueWatchingList(s2);

        u1.afegirWatchedList(s);
        u1.afegirWatchedList(s2);

        ArrayList<Usuari> listaUsers = new ArrayList<>();
        listaUsers.add(u1);
        Usuari u2 = new Usuari("lmento");
        ArrayList<Usuari> listaUsers2 = new ArrayList<>();
        listaUsers2.add(u2);
        listClients.put("Armando Jaleo", new Client("Armando Jaleo","ajaleo", "c1",true,"11111111A", "Madrigal 8, 00001, Barcelona", listaUsers));
        listClients.put("Lola Mento", new Client("Lola Mento","lmento", "c2",false,"22222222B", "Monumental 2, 00003, Barcelona", listaUsers2));
        listClients.put("Leandro Gao", new Client("Leandro Gao","lgao", "c3",false,"33333333C", "Uruguay 12, 00001, Barcelona"));
    }

    @Override
    public List<Client> getAll() {
        return new ArrayList<>(listClients.values());
    }

    @Override
    public Optional<Client> getById(String id) { return Optional.ofNullable(listClients.get(id)); }

    @Override
    public boolean add(final Client client) {
        if (listClients.containsKey(client.getClientName())) {
            return false;
        }else {
            listClients.put(client.getClientName(), client);
            return true;
        }
    }

    @Override
    public boolean update(final Client client, String[] params) {
        client.setClientName(Objects.requireNonNull(
                params[0], "Name cannot be null"));
        client.setPwd(Objects.requireNonNull(
                params[1], "Password cannot be null"));
        return listClients.replace(client.getClientName(), client) != null;
    }

    @Override
    public boolean delete(final Client client) {
        return listClients.remove(client.getClientName()) != null;
    }

    @Override
    public Client findClientByUserNAmeAndPassword(String usuari, String pwd) throws Exception {
        if (getById(usuari).isPresent()) {
            Client c = listClients.get(usuari);
            if (c.getPwd().equals(pwd)) {
                return c;
            } else return null;
        } else return null;
    }

    @Override
    public List<Usuari> getAllUsuaris(String idClient) throws Exception {
        if (getById(idClient).isPresent()) {
            Client c = listClients.get(idClient);
            return c.getAllUsers();
        }
        else return null;
    }

}
