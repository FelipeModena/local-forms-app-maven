package modena.infra.db.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modena.infra.db.entity.ProjectEntity;
import modena.infra.db.repository.interfaces.RepositoryInterface;
import modena.infra.db.sqlite.connect.ConnectionManagerSQLite;

public class ProjectRepository implements RepositoryInterface<ProjectEntity> {

    private Connection connection;

    public ProjectRepository() {
        connection = ConnectionManagerSQLite.getDbConnection();
    }

    @Override
    public ProjectEntity create(ProjectEntity project) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO projects (name, description, start_date, end_date, status) VALUES (?, ?, ?, ?, ?)");
            statement.setString(1, project.name);
            statement.setString(2, project.description);
            statement.setString(3, project.startDate);
            statement.setString(4, project.endDate);
            statement.setString(5, project.status);
            statement.executeUpdate();
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                project.id = generatedKeys.getInt(1);
            }
            generatedKeys.close();
            statement.close();

            return project;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ProjectEntity read(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM projects WHERE id = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                ProjectEntity project = new ProjectEntity(
                        resultSet.getString("name"),
                        resultSet.getString("description"),
                        resultSet.getString("start_date"),
                        resultSet.getString("end_date"),
                        resultSet.getString("status"));
                project.id = resultSet.getInt("id");
                resultSet.close();
                statement.close();
                return project;
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int update(ProjectEntity updatedProject) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE projects SET name = ?, description = ?, start_date = ?, end_date = ?, status = ? WHERE id = ?");
            statement.setString(1, updatedProject.name);
            statement.setString(2, updatedProject.description);
            statement.setString(3, updatedProject.startDate);
            statement.setString(4, updatedProject.endDate);
            statement.setString(5, updatedProject.status);
            statement.setInt(6, updatedProject.id);
            statement.executeUpdate();
            statement.close();
            return updatedProject.id;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public ProjectEntity read(ProjectEntity object) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'read'");
    }

    @Override
    public int delete(ProjectEntity object) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public ArrayList<ProjectEntity> list(ProjectEntity object) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'list'");
    }

    @Override
    public void put(String key, String value) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'put'");
    }

}
