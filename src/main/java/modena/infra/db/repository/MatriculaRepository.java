package modena.infra.db.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import modena.infra.db.entity.MatriculaEntity;
import modena.infra.db.sqlite.connect.ConnectionManagerSQLite;

public class MatriculaRepository {
    private String sqlCode;

    private Connection connection;

    public MatriculaRepository() {
        connection = ConnectionManagerSQLite.getDbConnection();

        // ConnectionManager.createNewDatabase();
    }

    public void create(MatriculaEntity matriculaEntity) {

        sqlCode = String.format(
                "INSERT INTO matriculas (nomeCompletoEstudante, idadeEstudante, emailEstudante, enderecoEstudante, cepEstudante, telefoneEstudante, userEstudante, senhaEstudante, cursoEstudante, observacao, ativo) VALUES ('%s', %d, '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', %b);",
                matriculaEntity.nomeCompletoEstudante, matriculaEntity.idadeEstudante, matriculaEntity.emailEstudante,
                matriculaEntity.enderecoEstudante, matriculaEntity.cepEstudante, matriculaEntity.telefoneEstudante,
                matriculaEntity.userEstudante, matriculaEntity.senhaEstudante, matriculaEntity.cursoEstudante,
                matriculaEntity.observacao, matriculaEntity.ativo);

        try {
            PreparedStatement ps = connection.prepareStatement(sqlCode);

            ps.execute();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void edit(MatriculaEntity matriculaEntity) {
        sqlCode = String.format(
                "UPDATE matriculas SET nomeCompletoEstudante, idadeEstudante, emailEstudante, enderecoEstudante, cepEstudante, telefoneEstudante, userEstudante, senhaEstudante, cursoEstudante, observacao, ativo WHERE userEstudante = '%s';",
                matriculaEntity.nomeCompletoEstudante, matriculaEntity.idadeEstudante, matriculaEntity.emailEstudante,
                matriculaEntity.enderecoEstudante, matriculaEntity.cepEstudante, matriculaEntity.telefoneEstudante,
                matriculaEntity.userEstudante, matriculaEntity.senhaEstudante, matriculaEntity.cursoEstudante,
                matriculaEntity.observacao, matriculaEntity.ativo, matriculaEntity.userEstudante);
    }

    public void delete(String userEstudante) {
        sqlCode = String.format("DELETE from matriculas WHERE userEstudante = '%s';",
                userEstudante);

        try {
            PreparedStatement ps = connection.prepareStatement(sqlCode);

            ps.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public MatriculaEntity read(String userEstudante) {
        MatriculaEntity entity = new MatriculaEntity();
        sqlCode = String.format("SELECT from matriculas WHERE userEstudante = '%s'", userEstudante);
        try {
            PreparedStatement request = connection.prepareStatement(sqlCode);
            request.execute();

            while (request.getResultSet().next()) {
                entity.nomeCompletoEstudante = request.getResultSet().getString("nomeCompletoEstudante");
                entity.idadeEstudante = request.getResultSet().getInt("idadeEstudante");
                entity.emailEstudante = request.getResultSet().getString("emailEstudante");
                entity.enderecoEstudante = request.getResultSet().getString("enderecoEstudante");
                entity.cepEstudante = request.getResultSet().getString("cepEstudante");
                entity.telefoneEstudante = request.getResultSet().getString("telefoneEstudante");
                entity.userEstudante = request.getResultSet().getString("userEstudante");
                entity.senhaEstudante = request.getResultSet().getString("senhaEstudante");
                entity.cursoEstudante = request.getResultSet().getString("cursoEstudante");
                entity.observacao = request.getResultSet().getString("observacao");
                entity.ativo = request.getResultSet().getBoolean("ativo");
            }

            return entity;
        } catch (Exception e) {
            System.out.println(e);

            return null;
        }
    }

    public ArrayList<MatriculaEntity> readAll() {
        ArrayList<MatriculaEntity> list = new ArrayList<>();
        sqlCode = String.format("SELECT * from matriculas");

        try {
            PreparedStatement request = connection.prepareStatement(sqlCode);
            request.execute();

            while (request.getResultSet().next()) {
                MatriculaEntity entity = new MatriculaEntity();
                entity.nomeCompletoEstudante = request.getResultSet().getString("nomeCompletoEstudante");
                entity.idadeEstudante = request.getResultSet().getInt("idadeEstudante");
                entity.emailEstudante = request.getResultSet().getString("emailEstudante");
                entity.enderecoEstudante = request.getResultSet().getString("enderecoEstudante");
                entity.cepEstudante = request.getResultSet().getString("cepEstudante");
                entity.telefoneEstudante = request.getResultSet().getString("telefoneEstudante");
                entity.userEstudante = request.getResultSet().getString("userEstudante");
                entity.senhaEstudante = request.getResultSet().getString("senhaEstudante");
                entity.cursoEstudante = request.getResultSet().getString("cursoEstudante");
                entity.observacao = request.getResultSet().getString("observacao");
                entity.ativo = request.getResultSet().getBoolean("ativo");
                list.add(entity);
            }

            for (MatriculaEntity elemEntity : list) {
                System.out.println(elemEntity.nomeCompletoEstudante);
            }

            return list;
        } catch (

        Exception e) {
            System.out.println("error ao ler todos os dados");

            return new ArrayList<>();
        }
    }

}
