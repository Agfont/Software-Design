package ub.edu.resources.dao.sql;

import ub.edu.resources.dao.DAOVisualitzacio;
import ub.edu.model.Visualitzacio;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DAOVisualitzacioSQL implements DAOVisualitzacio {
    @Override
    public Optional<Visualitzacio> getById(String id) {
        return Optional.empty();
    }

    @Override
    public List<Visualitzacio> getAll() throws Exception {
        List<Visualitzacio> visualitzacioList = new ArrayList<>();
        Connection connection = ConnectionFactorySQL.getConnection();

        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM v_visualitzacio");

            while (rs.next()) {
                Visualitzacio visualitzacio = extractVisualitzacioFromResultSet(rs);
                visualitzacioList.add(visualitzacio);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactorySQL.closeConnection(connection);
        }
        return visualitzacioList;
    }

    @Override
    public boolean add(Visualitzacio visualitzacio) {
        return false;
    }

    @Override
    public boolean update(Visualitzacio visualitzacio) {
        return false;
    }

    @Override
    public boolean delete(Visualitzacio visualitzacio) {
        return false;
    }

    private Visualitzacio extractVisualitzacioFromResultSet(ResultSet rs) throws SQLException {
        Visualitzacio visualitzacio = new Visualitzacio();
        visualitzacio.setId(rs.getInt("id"));
        visualitzacio.setIdUser(rs.getString("idusuari"));
        visualitzacio.setIdSerie(rs.getString("idserie"));
        visualitzacio.setNumTemporada(rs.getInt("numtemporada"));
        visualitzacio.setIdEpisodi(rs.getInt("idEpisodi"));
        visualitzacio.setDate(rs.getString("data"));
        visualitzacio.setMinutsRestants(rs.getInt("minutsrestants"));
        return visualitzacio;
    }
}
