package modena.infra.db.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import modena.infra.db.entity.UserEntity;
import modena.infra.db.repository.interfaces.RepositoryInterface;
import modena.infra.db.sqlite.connect.ConnectionManagerSQLite;

public class UserRepository implements RepositoryInterface<UserEntity> {
    private Connection connection;

    public UserRepository() {
        connection = ConnectionManagerSQLite.getDbConnection();
    }

    @Override
    public UserEntity create(UserEntity object) {
        String sqlCode = "INSERT INTO user (name, email, cpf, rg, address, salary, pis, work_permit, military_reservist, heiring_date, operation_state, status) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = connection.prepareStatement(sqlCode);
            ps.setString(1, object.getName());
            ps.setString(2, object.getEmail());
            ps.setString(3, object.getCpf());
            ps.setString(4, object.getRg());
            ps.setString(5, object.getAddress());
            ps.setDouble(6, object.getSalary());
            ps.setString(7, object.getPis());
            ps.setString(8, object.getWorkPermit());
            ps.setString(9, object.getMilitaryReservist());
            ps.setString(10, object.getHeiringDate());
            ps.setString(11, object.getOperationState());
            ps.setBoolean(12, object.isStatus());

            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }

        return null;
    }

    @Override
    public UserEntity read(UserEntity object) {
        String sqlCode = "SELECT * FROM user WHERE id = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(sqlCode);
            ps.setInt(1, object.getId());

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                UserEntity userEntity = new UserEntity();
                userEntity.setId(rs.getInt("id"));
                userEntity.setName(rs.getString("name"));
                userEntity.setEmail(rs.getString("email"));
                userEntity.setCpf(rs.getString("cpf"));
                userEntity.setRg(rs.getString("rg"));
                userEntity.setAddress(rs.getString("address"));
                userEntity.setSalary(rs.getDouble("salary"));
                userEntity.setPis(rs.getString("pis"));
                userEntity.setWorkPermit(rs.getString("work_permit"));
                userEntity.setMilitaryReservist(rs.getString("military_reservist"));
                userEntity.setHeiringDate(rs.getString("heiring_date"));
                userEntity.setOperationState(rs.getString("operation_state"));
                userEntity.setStatus(rs.getBoolean("status"));

                return userEntity;
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return null;
    }

    public UserEntity getByName(String name) {
        String sqlCode = "SELECT * FROM user WHERE name = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(sqlCode);
            ps.setString(1, name);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                UserEntity userEntity = new UserEntity();
                userEntity.setId(rs.getInt("id"));
                userEntity.setName(rs.getString("name"));
                userEntity.setEmail(rs.getString("email"));
                userEntity.setCpf(rs.getString("cpf"));
                userEntity.setRg(rs.getString("rg"));
                userEntity.setAddress(rs.getString("address"));
                userEntity.setSalary(rs.getDouble("salary"));
                userEntity.setPis(rs.getString("pis"));
                userEntity.setWorkPermit(rs.getString("work_permit"));
                userEntity.setMilitaryReservist(rs.getString("military_reservist"));
                userEntity.setHeiringDate(rs.getString("heiring_date"));
                userEntity.setOperationState(rs.getString("operation_state"));
                userEntity.setStatus(rs.getBoolean("status"));

                return userEntity;
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return null;
    }

    @Override
    public int update(UserEntity object) {
        String sqlCode = "UPDATE user SET name = ?, email = ?, cpf = ?, rg = ?, phone = ?, address = ?, salary = ?, pis = ?, work_permit = ?, military_reservist = ?, heiring_date = ?, operation_state = ?, status = ? "
                + "WHERE id = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(sqlCode);
            ps.setString(1, object.getName());
            ps.setString(2, object.getEmail());
            ps.setString(3, object.getCpf());
            ps.setString(4, object.getRg());
            ps.setString(6, object.getAddress());
            ps.setDouble(7, object.getSalary());
            ps.setString(8, object.getPis());
            ps.setString(9, object.getWorkPermit());
            ps.setString(10, object.getMilitaryReservist());
            ps.setString(11, object.getHeiringDate());
            ps.setString(12, object.getOperationState());
            ps.setBoolean(13, object.isStatus());
            ps.setInt(14, object.getId());

            return ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }

        return 0;
    }

    @Override
    public int delete(UserEntity object) {
        String sqlCode = "DELETE FROM user WHERE id = ?";

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
    public ArrayList<UserEntity> list(UserEntity object) {
        ArrayList<UserEntity> users = new ArrayList<>();

        String sqlCode = "SELECT * FROM user";

        try {
            PreparedStatement ps = connection.prepareStatement(sqlCode);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                UserEntity userEntity = new UserEntity();
                userEntity.setId(rs.getInt("id"));
                userEntity.setName(rs.getString("name"));
                userEntity.setEmail(rs.getString("email"));
                userEntity.setCpf(rs.getString("cpf"));
                userEntity.setRg(rs.getString("rg"));
                userEntity.setAddress(rs.getString("address"));
                userEntity.setSalary(rs.getDouble("salary"));
                userEntity.setPis(rs.getString("pis"));
                userEntity.setWorkPermit(rs.getString("work_permit"));
                userEntity.setMilitaryReservist(rs.getString("military_reservist"));
                userEntity.setHeiringDate(rs.getString("heiring_date"));
                userEntity.setOperationState(rs.getString("operation_state"));
                userEntity.setStatus(rs.getBoolean("status"));

                users.add(userEntity);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return users;
    }

    @Override
    public void put(String key, String value) {
        // Not implemented for UserEntity
    }
}
