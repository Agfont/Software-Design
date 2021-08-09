package ub.edu.resources.dao.sql;

import ub.edu.resources.dao.DAOUsuari;
import ub.edu.model.Usuari;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DAOUsuariSQL implements DAOUsuari {
    @Override
    public Optional<Usuari> getById(String id) {
        return Optional.empty();
    }

    @Override
    public List<Usuari> getAll() throws Exception {
        List<Usuari> usuariList = new ArrayList<>();
        Connection connection = ConnectionFactorySQL.getConnection();

        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM v_usuari");

            while (rs.next()) {
                Usuari usuari = extractUsuariFromResultSet(rs);
                usuariList.add(usuari);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactorySQL.closeConnection(connection);
        }
        return usuariList;
    }

    @Override
    public boolean add(Usuari usuari) throws Exception {
        Connection connection = ConnectionFactorySQL.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO usuari VALUES (?, ?, ?, ?, ?)");
            ps.setString(1, usuari.getIdClient());
            ps.setString(2, usuari.getIdUser());
            ps.setString(3, usuari.getUserName());
            if (ps.executeUpdate() == 1) return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception(ex);
        } finally {
            ConnectionFactorySQL.closeConnection(connection);
        }
        return false;
    }

    @Override
    public boolean update(Usuari usuari) {
        return false;
    }

    @Override
    public boolean delete(Usuari usuari) {
        return false;
    }

    private Usuari extractUsuariFromResultSet(ResultSet rs) throws SQLException {
        Usuari usuari = new Usuari();
        usuari.setIdUser(rs.getString("id"));
        usuari.setIdClient(rs.getString("idclient"));
        usuari.setUserName(rs.getString("nom"));
        return usuari;
    }
}
