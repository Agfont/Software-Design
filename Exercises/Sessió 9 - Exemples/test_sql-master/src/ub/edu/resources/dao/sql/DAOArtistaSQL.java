package ub.edu.resources.dao.sql;

import ub.edu.resources.dao.DAOArtista;
import ub.edu.model.Artista;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DAOArtistaSQL implements DAOArtista {

    @Override
    public Optional<Artista> getById(String id) {
        return Optional.empty();
    }

    @Override
    public List<Artista> getAll() throws SQLException {
        List<Artista> productoraList = new ArrayList<>();
        Connection connection = ConnectionFactorySQL.getConnection();

        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM v_artista");

            while (rs.next()) {
                Artista artista = extractArtistaFromResultSet(rs);
                productoraList.add(artista);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            //TODO
        } finally {
            ConnectionFactorySQL.closeConnection(connection);
        }
        return productoraList;
    }

    @Override
    public boolean add(Artista artista) {
        return false;
    }

    @Override
    public boolean update(Artista artista) {
        return false;
    }

    @Override
    public boolean delete(Artista artista) {
        return false;
    }

    private Artista extractArtistaFromResultSet(ResultSet rs) throws SQLException {
        Artista artista = new Artista();
        artista.setId(rs.getInt("id"));
        artista.setNom(rs.getString("nom"));
        artista.setTipus(rs.getString("tipus"));
        artista.setNacionalitat(rs.getString("nacionalitat"));
        artista.setIdSerie(rs.getString("idserie"));
        return artista;
    }
}
