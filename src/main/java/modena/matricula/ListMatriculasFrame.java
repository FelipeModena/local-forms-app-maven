package modena.matricula;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

import modena.matricula.db.entity.MatriculaEntity;
import modena.matricula.db.repository.MatriculaRepository;


public class ListMatriculasFrame extends JFrame {

    JPanel mainPanel = new JPanel();

    ListMatriculasFrame() {
        baseConfig();

        MatriculaRepository matriculaDB = new MatriculaRepository();
        ArrayList<MatriculaEntity> listOfMatriculas = matriculaDB.readAll();

        for (MatriculaEntity entity : listOfMatriculas) {
            mainPanel.add(makeLabelMatriculas(entity));
        }

        JScrollPane scrollPane = new JScrollPane(mainPanel);
        getContentPane().add(scrollPane);
        pack();
        setVisible(true);
    }

    JLabel makeLabelMatriculas(MatriculaEntity matriculaEntity) {
        JLabel label = new JLabel();
        label.setText("Nome completo: " + matriculaEntity.nomeCompletoEstudante + " | Idade: "
                + matriculaEntity.idadeEstudante + " | Email: "
                + matriculaEntity.emailEstudante + " | Endereco: " + matriculaEntity.enderecoEstudante + " | CEP: "
                + matriculaEntity.cepEstudante + " | Telefone: " + matriculaEntity.telefoneEstudante + " | Username: "
                + matriculaEntity.userEstudante
                + " | Senha: " + matriculaEntity.senhaEstudante + " | Curso: " + matriculaEntity.cursoEstudante
                + " | Observacao: "
                + matriculaEntity.observacao + " | Ativo: " + matriculaEntity.ativo);
        label.setFont(label.getFont().deriveFont(Font.BOLD, 18f));
        return label;
    }

    void baseConfig() {
        setSize(500, 600);
        setMinimumSize(new Dimension(300, 400));

        mainPanel.setLayout(new GridLayout(0, 1));
    }
}