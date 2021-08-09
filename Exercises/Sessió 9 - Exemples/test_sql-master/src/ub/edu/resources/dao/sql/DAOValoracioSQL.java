package ub.edu.resources.dao.sql;

import ub.edu.resources.dao.DAOValoracio;
import ub.edu.model.Valoracio;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DAOValoracioSQL implements DAOValoracio {

    @Override
    public Optional<Valoracio> getById(String id) throws Exception {
        return Optional.empty();
    }

    @Override
    public List<Valoracio> getAll() throws Exception {
        List<Valoracio> valoracioList = new ArrayList<>();
        Connection connection = ConnectionFactorySQL.getConnection();

        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM v_valoracio");

            while (rs.next()) {
                Valoracio valoracio = extractValoracioFromResultSet(rs);
                valoracioList.add(valoracio);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactorySQL.closeConnection(connection);
        }
        return valoracioList;
    }

    @Override
    public boolean add(Valoracio valoracio) throws Exception {
        return false;
    }

    @Override
    public boolean update(Valoracio valoracio) throws Exception {
        return false;
    }

    @Override
    public boolean delete(Valoracio valoracio) throws Exception {
        return false;
    }

    private Valoracio extractValoracioFromResultSet(ResultSet rs) throws SQLException {
        Valoracio valoracio = new Valoracio();
        valoracio.setId(rs.getInt("id"));
        valoracio.setIdClient(rs.getString("idclient"));
        valoracio.setIdUsuari(rs.getInt("idusuari"));
        valoracio.setIdSerie(rs.getString("idserie"));
        valoracio.setIdEpisodi(rs.getInt("idepisodi"));
        if ((Integer) rs.getInt("estrelles") != null)
            valoracio.setValoracioEstrelles(rs.getInt("estrelles"));
        if (rs.getString("thumb") != null)
            valoracio.setValoracioThumb(rs.getString("thumb"));
        valoracio.setData(rs.getString("data"));
        return valoracio;
    }
}
