package ub.edu;

import ub.edu.model.*;
import ub.edu.resources.service.DataService;
import ub.edu.resources.service.FactorySQL;

import java.util.List;


public class Main {

    public static void main(String[] args) {
        Controller controller = new Controller("SQL");
        DataService dataService = new DataService(new FactorySQL());
        Serie serie = null;

        try {

            List<Serie> serieList = dataService.getAllSeries();
            List<Temporada> temporadaList = dataService.getAllTemporades();
            List<Episodi> episodisList = dataService.getAllEpisodis();
            List<Productora> productoraList = dataService.getAllProductores();
            List<Artista> artistaList = dataService.getAllArtistes();

            System.out.println("Consultant la descripció de Breaking Bad");
            for (Serie serieIt : serieList) {
                if (serieIt.getId().equals("bbad"))
                    serie = serieIt;
            }

            System.out.println("---------------");
            System.out.println("Id: " + serie.getId());
            System.out.println("Títol: " + serie.getTitol());
            System.out.println("Descripció: " + serie.getDescripcio());

            System.out.println("Consultant la productora de Breaking Bad");
            for (Productora productora : productoraList) {
                if (productora.getId() == serie.getIdProductora())
                    System.out.println("Productora: " + productora.getNom());
            }

            System.out.println("Consultant els artistes que actuen a Breaking Bad");
            for (Artista artista : artistaList) {
                if (artista.getIdSerie().equalsIgnoreCase(serie.getId())) {
                    System.out.println("Artista: " + artista.getNom() + " Tipus: " + artista.getTipus() + " Nacionalitat: " + artista.getNom());
                }
            }

            System.out.println("Consultant les temporades i els episodis de Breaking Bad");
            for (Temporada temporada : temporadaList) {
                if (temporada.getIdSerie().equals(serie.getId())) {
                    System.out.println("Número Temporada: " + temporada.getNumTemporada());
                    for (Episodi episodi : episodisList) {
                        if (episodi.getIdSerie().equals(serie.getId())
                                && episodi.getNumTemporada() == temporada.getNumTemporada()) {
                            System.out.println(episodi.getIdEpisodi());
                            System.out.println(episodi.getTitol());
                            System.out.println(episodi.getDescripcio());
                            System.out.println(episodi.getDuracio());
                            System.out.println(episodi.getIdioma());
                            System.out.println(episodi.getData());
                        }
                    }
                }
            }

            System.out.println("Consultant només el primer episodi de Breaking Bad");
            episodisList = dataService.findAllBySerieAndTemporada("bbad", 1);
            for (Episodi episodi : episodisList) {
                System.out.println(episodi.getIdEpisodi());
                System.out.println(episodi.getTitol());
                System.out.println(episodi.getDescripcio());
                System.out.println(episodi.getDuracio());
                System.out.println(episodi.getIdioma());
                System.out.println(episodi.getData());
            }



            System.out.println("Consultant els Cients i els usuaris");
            List<Client> clientList = dataService.getAllClients();
            List<Usuari> usuariList = dataService.getAllUsuaris();
            for (Client client : clientList) {
                System.out.println(" Id: " + client.getIdClient() +
                        " Nom: " +client.getNom() +
                        " Pwd: " +client.getPwd() +
                        " DI: " +client.getDocumentIdentitat() +
                        " Adreça :" +client.getAdreca() );
                for (Usuari usuari : usuariList) {
                    if (usuari.getIdClient().equals(client.getIdClient()))
                        System.out.println(usuari.getIdUser() + usuari.getUserName());
                }
            }

            System.out.println("Consultant totes les visualitzacions");
            for (Visualitzacio visualitzacio: dataService.getAllVisualitzacions()) {
                System.out.println(visualitzacio.getId());
            }

            System.out.println("Consultant totes les valoracions");
            for (Valoracio valoracio : dataService.getAllValoracions()) {
                System.out.println(valoracio.getId());
            }

            System.out.println("Consultant tots els favorits");
            for (Favorit favorit : dataService.getAllFavorits()) {
                System.out.println(favorit.getId());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
