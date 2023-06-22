package modena.ui;

import java.awt.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


public class MenuFrame extends JFrame {
    JPanel mainPanel = new JPanel();
    JButton addMatricula = new JButton("Adicionar Matricula");
    JButton listAllMatriculas = new JButton("Listar todas as matriculas");
    JButton getMatricula = new JButton("Buscar matricula");

    public void initialize() {
        baseConfig();
        addButtonToMenu();

        new ListMatriculasFrame();

        JScrollPane scrollPane = new JScrollPane(mainPanel);
        getContentPane().add(scrollPane);
        pack();
        setVisible(true);
    }

    void addButtonToMenu() {
        listAllMatriculas.addActionListener(e -> {
            new ListMatriculasFrame();
        });
        mainPanel.add(listAllMatriculas);

        addMatricula.addActionListener(e -> {
            new AddMatriculaFrame();
        });
        mainPanel.add(addMatricula);

        getMatricula.addActionListener(e -> {
            new GetMatriculaFrame();
        });
        mainPanel.add(getMatricula);
    }

    void baseConfig() {
        setSize(500, 600);
        setMinimumSize(new Dimension(300, 400));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPanel.setLayout(new GridLayout(0, 1));
    }

}