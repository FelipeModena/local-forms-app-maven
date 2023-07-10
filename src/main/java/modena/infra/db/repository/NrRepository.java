package modena.infra.db.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import modena.infra.db.entity.NrEntity;
import modena.infra.db.repository.interfaces.RepositoryInterface;
import modena.infra.db.sqlite.connect.ConnectionManagerSQLite;

public class NrRepository extends ConnectionManagerSQLite implements RepositoryInterface<NrEntity> {

    @Override
    public NrEntity create(NrEntity object) {
        Connection connection = getDbConnection();

        String sqlCode = "INSERT INTO nr (name, user_id) VALUES (?, ?)";

        try {
            PreparedStatement ps = connection.prepareStatement(sqlCode);
            ps.setString(1, object.getName());
            ps.setInt(2, object.getUserId());

            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }

        return null;
    }

    @Override
    public NrEntity read(NrEntity object) {
        Connection connection = getDbConnection();

        String sqlCode = "SELECT * FROM nr WHERE id = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(sqlCode);
            ps.setInt(1, object.getId());

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                NrEntity nrEntity = new NrEntity();
                nrEntity.setId(rs.getInt("id"));
                nrEntity.setName(rs.getString("name"));
                nrEntity.setUserId(rs.getInt("user_id"));

                return nrEntity;
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return null;
    }

    @Override
    public int update(NrEntity object) {
        Connection connection = getDbConnection();
        String sqlCode = "UPDATE nr SET name = ?, user_id = ? WHERE id = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(sqlCode);
            ps.setString(1, object.getName());
            ps.setInt(2, object.getUserId());
            ps.setInt(3, object.getId());

            return ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }

        return 0;
    }

    @Override
    public int delete(NrEntity object) {
        Connection connection = getDbConnection();
        String sqlCode = "DELETE FROM nr WHERE id = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(sqlCode);
            ps.setInt(1, object.getId());

            return ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }

        return 0;
    }

    @Override
    public ArrayList<NrEntity> list(NrEntity object) {
        Connection connection = getDbConnection();
        ArrayList<NrEntity> nrs = new ArrayList<>();

        String sqlCode = "SELECT * FROM nr";

        try {
            PreparedStatement ps = connection.prepareStatement(sqlCode);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                NrEntity nrEntity = new NrEntity();
                nrEntity.setId(rs.getInt("id"));
                nrEntity.setName(rs.getString("name"));
                nrEntity.setUserId(rs.getInt("user_id"));

                nrs.add(nrEntity);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return nrs;
    }

    @Override
    public void put(String key, String value) {
        // Not implemented for NrEntity
    }
}
