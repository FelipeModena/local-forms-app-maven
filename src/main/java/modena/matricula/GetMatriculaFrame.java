package modena.matricula;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.*;

import modena.matricula.db.MatriculaDB;
import modena.matricula.db.entity.MatriculaEntity;



public class GetMatriculaFrame extends JFrame {
    JTextField userField = new JTextField(20);
    MatriculaEntity userFound;
    JPanel mainPanel = new JPanel();
    JPanel userPanel = new JPanel();

    GetMatriculaFrame() {
        baseConfig();
        addInputsToPanel();

        JButton submitButton = new JButton("Adicionar");
        submitButton.addActionListener(e -> {
            submitForm();
        });
        mainPanel.add(submitButton);

        getContentPane().add(mainPanel);
        getContentPane().add(userPanel);

        pack();
        setVisible(true);

    }

    void submitForm() {
        String username = userField.getText();
        MatriculaDB matriculaDB = new MatriculaDB();
        userFound = matriculaDB.read(username);
        if (userFound != null) {
            System.out.println(userFound.senhaEstudante);

            mainPanel.add(makeLabelMatriculas(userFound));
        }
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

    void addInputsToPanel() {

        mainPanel.add(new JLabel("Nome completo: "));
        mainPanel.add(userField);
    }

    void baseConfig() {
        setSize(500, 600);
        setMinimumSize(new Dimension(300, 400));

        mainPanel.setLayout(new GridLayout(0, 1));
    }

}
