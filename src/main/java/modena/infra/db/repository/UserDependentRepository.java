package modena.infra.db.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import modena.infra.db.entity.UserDependentEntity;
import modena.infra.db.repository.interfaces.RepositoryInterface;
import modena.infra.db.sqlite.connect.ConnectionManagerSQLite;

public class UserDependentRepository implements RepositoryInterface<UserDependentEntity> {
    private Connection connection;

    public UserDependentRepository() {
        connection = ConnectionManagerSQLite.getDbConnection();
    }

    @Override
    public UserDependentEntity create(UserDependentEntity object) {
        String sqlCode = "INSERT INTO userDependent (name, age, user_id) VALUES (?, ?, ?)";

        try {
            PreparedStatement ps = connection.prepareStatement(sqlCode);
            ps.setString(1, object.getName());
            ps.setInt(2, object.getAge());
            ps.setInt(3, object.getUserId());

            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }

        return null;
    }

    @Override
    public UserDependentEntity read(UserDependentEntity object) {
        String sqlCode = "SELECT * FROM userDependent WHERE id = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(sqlCode);
            ps.setInt(1, object.getId());

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                UserDependentEntity userDependentEntity = new UserDependentEntity();
                userDependentEntity.setId(rs.getInt("id"));
                userDependentEntity.setName(rs.getString("name"));
                userDependentEntity.setAge(rs.getInt("age"));
                userDependentEntity.setUserId(rs.getInt("user_id"));

                return userDependentEntity;
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return null;
    }

    @Override
    public int update(UserDependentEntity object) {
        String sqlCode = "UPDATE userDependent SET name = ?, age = ?, user_id = ? WHERE id = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(sqlCode);
            ps.setString(1, object.getName());
            ps.setInt(2, object.getAge());
            ps.setInt(3, object.getUserId());
            ps.setInt(4, object.getId());

            return ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }

        return 0;
    }

    @Override
    public int delete(UserDependentEntity object) {
        String sqlCode = "DELETE FROM userDependent WHERE id = ?";

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
    public ArrayList<UserDependentEntity> list(UserDependentEntity object) {
        ArrayList<UserDependentEntity> userDependents = new ArrayList<>();

        String sqlCode = "SELECT * FROM userDependent";

        try {
            PreparedStatement ps = connection.prepareStatement(sqlCode);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                UserDependentEntity userDependentEntity = new UserDependentEntity();
                userDependentEntity.setId(rs.getInt("id"));
                userDependentEntity.setName(rs.getString("name"));
                userDependentEntity.setAge(rs.getInt("age"));
                userDependentEntity.setUserId(rs.getInt("user_id"));

                userDependents.add(userDependentEntity);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return userDependents;
    }

    @Override
    public void put(String key, String value) {
        // Not implemented for UserDependentEntity
    }
}
