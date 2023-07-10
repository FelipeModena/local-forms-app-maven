package modena.infra.db.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import modena.infra.db.entity.AdminEntity;
import modena.infra.db.repository.interfaces.RepositoryInterface;
import modena.infra.db.sqlite.connect.ConnectionManagerSQLite;

public class AdminRepository extends ConnectionManagerSQLite implements RepositoryInterface<AdminEntity> {

    @Override
    public AdminEntity create(AdminEntity object) {
        Connection connection = getDbConnection();

        String sqlCode = String.format(
                "INSERT INTO admin (name,username, email, password, role, status) VALUES ('%s', '%s', '%s', '%s', '%s','%s');",
                object.getName(), object.getUsername(), object.getEmail(), object.getPassword(), object.role.toString(),
                "active");

        try {
            PreparedStatement ps = connection.prepareStatement(sqlCode);

            ps.execute();
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        return null;

    }

    @Override
    public AdminEntity read(AdminEntity object) {
        Connection connection = getDbConnection();

        String sqlCode = String.format("SELECT * FROM admin WHERE username = '%s' AND password = '%s';",
                object.getUsername(), object.getPassword());
        try {
            PreparedStatement ps = connection.prepareStatement(sqlCode);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                AdminEntity adminEntity = new AdminEntity(rs.getString("name"), rs.getString("username"),
                        rs.getString("password"), rs.getString("email"));

                return adminEntity;
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public int update(AdminEntity object) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public int delete(AdminEntity object) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public ArrayList<AdminEntity> list(AdminEntity object) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'list'");
    }

    @Override
    public void put(String key, String value) {
        Connection connection = getDbConnection();

        String sqlCode = String.format("UPDATE admin SET %s = '%s' WHERE id = 1;", key, value);

        try {
            PreparedStatement ps = connection.prepareStatement(sqlCode);

            ps.execute();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
