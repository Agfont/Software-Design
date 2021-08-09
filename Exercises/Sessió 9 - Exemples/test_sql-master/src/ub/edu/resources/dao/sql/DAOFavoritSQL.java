package ub.edu.resources.dao.sql;

import ub.edu.resources.dao.DAOFavorit;
import ub.edu.model.Favorit;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DAOFavoritSQL implements DAOFavorit {

    @Override
    public Optional<Favorit> getById(String id) throws Exception {
        return Optional.empty();
    }

    @Override
    public List<Favorit> getAll() throws Exception {
        List<Favorit> favoritList = new ArrayList<>();
        Connection connection = ConnectionFactorySQL.getConnection();

        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM v_favorit");

            while (rs.next()) {
                Favorit favorit = extractFavoritFromResultSet(rs);
                favoritList.add(favorit);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactorySQL.closeConnection(connection);
        }
        return favoritList;
    }

    @Override
    public boolean add(Favorit favorit) throws Exception {
        return false;
    }

    @Override
    public boolean update(Favorit favorit) throws Exception {
        return false;
    }

    @Override
    public boolean delete(Favorit favorit) throws Exception {
        return false;
    }

    private Favorit extractFavoritFromResultSet(ResultSet rs) throws SQLException {
        Favorit favorit = new Favorit();
        favorit.setId(rs.getInt("id"));
        favorit.setIdClient(rs.getString("idclient"));
        favorit.setIdUsuari(rs.getInt("idusuari"));
        favorit.setIdSerie(rs.getString("idserie"));
        return favorit;
    }
}
