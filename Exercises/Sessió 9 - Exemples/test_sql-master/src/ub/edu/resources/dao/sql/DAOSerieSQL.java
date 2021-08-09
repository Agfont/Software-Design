package ub.edu.resources.dao.sql;

import ub.edu.resources.dao.DAOSerie;
import ub.edu.model.Serie;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DAOSerieSQL implements DAOSerie {

    @Override
    public Optional<Serie> getById(String id) {
        return Optional.empty();
    }

    @Override
    public List<Serie> getAll() throws Exception {
        List<Serie> serieList = new ArrayList<>();
        Connection connection = ConnectionFactorySQL.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM v_serie");

            while (rs.next()) {
                Serie serie = extractSerieFromResultSet(rs);
                serieList.add(serie);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            //TODO
        } finally {
            ConnectionFactorySQL.closeConnection(connection);
        }
        return serieList;
    }

    @Override
    public boolean add(Serie serie) throws Exception {
        return false;
    }

    @Override
    public boolean update(Serie serie) throws Exception {
        return false;
    }

    @Override
    public boolean delete(Serie serie) throws Exception {
        return false;
    }

    private Serie extractSerieFromResultSet(ResultSet rs) throws SQLException {
        Serie serie = new Serie();
        serie.setId(rs.getString("id"));
        serie.setTitol(rs.getString("title"));
        serie.setDescripcio(rs.getString("description"));
        serie.setIdProductora(rs.getInt("idproductora"));
        return serie;
    }
}
