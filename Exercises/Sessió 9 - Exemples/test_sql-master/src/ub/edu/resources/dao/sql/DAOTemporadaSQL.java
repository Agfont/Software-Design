package ub.edu.resources.dao.sql;

import ub.edu.resources.dao.DAOTemporada;
import ub.edu.model.Temporada;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DAOTemporadaSQL implements DAOTemporada {

    @Override
    public Optional<Temporada> getById(String id) {
        return Optional.empty();
    }

    @Override
    public List<Temporada> getAll() throws Exception {
        List<Temporada> temporadaList = new ArrayList<>();
        Connection connection = ConnectionFactorySQL.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM v_temporada");

            while (rs.next()) {
                Temporada temporada = extractTemporadaFromResultSet(rs);
                temporadaList.add(temporada);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            //TODO
        } finally {
            ConnectionFactorySQL.closeConnection(connection);
        }
        return temporadaList;
    }

    @Override
    public boolean add(Temporada temporada) {
        return false;
    }

    @Override
    public boolean update(Temporada temporada) {
        return false;
    }

    @Override
    public boolean delete(Temporada temporada) {
        return false;
    }

    private Temporada extractTemporadaFromResultSet(ResultSet rs) throws SQLException {
        Temporada temporada = new Temporada();
        temporada.setIdSerie(rs.getString("idserie"));
        temporada.setNumTemporada(rs.getInt("numtemporada"));
        temporada.setNumEpisodis(rs.getInt("numepisodis"));
        return temporada;
    }
}
