package modena.infra.db.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import modena.infra.db.entity.UserEntity;
import modena.infra.db.repository.interfaces.RepositoryInterface;
import modena.infra.db.sqlite.connect.ConnectionManagerSQLite;

public class UserRepository extends ConnectionManagerSQLite implements RepositoryInterface<UserEntity> {

    @Override
    public UserEntity create(UserEntity object) {
        Connection connection = getDbConnection();

        String sql = String.format(
                "INSERT INTO user (name, email, cpf, rg, address, salary, pis, work_permit, military_reservist, heiring_date, operation_state, status, aso)  VALUES ('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s','%s', '%s', '%s');",
                object.getName(),
                object.getEmail(),
                object.getCpf(),
                object.getRg(),
                object.getAddress(),
                object.getSalary(),
                object.getPis(),
                object.getWorkPermit(),
                object.getMilitaryReservist(),
                object.getHeiringDate(),
                object.getOperationState(),
                object.isStatus(),
                object.getAsoDate()

        );

        try {
            PreparedStatement ps = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            UserEntity userEntity = new UserEntity();

            int affectedRows = ps.executeUpdate();

            if (affectedRows > 0) {
                ResultSet generatedKeys = ps.getGeneratedKeys();
                if (generatedKeys.next()) {
                    userEntity.setId(generatedKeys.getInt(1));
                    return userEntity;
                }

            }

            connection.close();
        } catch (Exception e) {
            System.out.println(e);

        }

        return null;
    }

    @Override
    public UserEntity read(UserEntity object) {
        Connection connection = getDbConnection();

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
                userEntity.setAddressRepository(rs.getString("address"));
                userEntity.setSalary(rs.getDouble("salary"));
                userEntity.setPis(rs.getString("pis"));
                userEntity.setWorkPermit(rs.getString("work_permit"));
                userEntity.setMilitaryReservist(rs.getString("military_reservist"));
                userEntity.setHeiringDate(rs.getString("heiring_date"));
                userEntity.setOperationState(rs.getString("operation_state"));
                userEntity.setStatus(rs.getBoolean("status"));
                connection.close();

                return userEntity;
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return null;
    }

    public UserEntity getByName(String name) {
        Connection connection = getDbConnection();

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
                userEntity.setAddressRepository(rs.getString("address"));
                userEntity.setSalary(rs.getDouble("salary"));
                userEntity.setPis(rs.getString("pis"));
                userEntity.setWorkPermit(rs.getString("work_permit"));
                userEntity.setMilitaryReservist(rs.getString("military_reservist"));
                userEntity.setHeiringDate(rs.getString("heiring_date"));
                userEntity.setOperationState(rs.getString("operation_state"));
                userEntity.setStatus(rs.getBoolean("status"));
                connection.close();

                return userEntity;
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return null;
    }

    @Override
    public int update(UserEntity object) {
        Connection connection = getDbConnection();

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
            int result = ps.executeUpdate();
            connection.close();
            return result;
        } catch (Exception e) {
            System.out.println(e);
        }

        return 0;
    }

    @Override
    public int delete(UserEntity object) {
        Connection connection = getDbConnection();

        String sqlCode = "DELETE FROM user WHERE id = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(sqlCode);
            ps.setInt(1, object.getId());
            int result = ps.executeUpdate();

            connection.close();

            return result;
        } catch (Exception e) {
            System.out.println(e);
        }

        return 0;
    }

    @Override
    public ArrayList<UserEntity> list(UserEntity object) {
        Connection connection = getDbConnection();

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
                userEntity.setAddressRepository(rs.getString("address"));
                userEntity.setSalary(rs.getDouble("salary"));
                userEntity.setPis(rs.getString("pis"));
                userEntity.setWorkPermit(rs.getString("work_permit"));
                userEntity.setMilitaryReservist(rs.getString("military_reservist"));
                userEntity.setHeiringDate(rs.getString("heiring_date"));
                userEntity.setOperationState(rs.getString("operation_state"));
                userEntity.setStatus(rs.getBoolean("status"));

                users.add(userEntity);
                connection.close();
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
