package modena.matricula;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import modena.matricula.db.entity.MatriculaEntity;
import modena.matricula.db.repository.MatriculaRepository;


public class AddMatriculaFrame extends JFrame {
    JPanel mainPanel = new JPanel();

    JTextField nomeCompletoField = new JTextField(20);
    JTextField idadeField = new JTextField(20);
    JTextField emailField = new JTextField(20);
    JTextField enderecoField = new JTextField(20);
    JTextField cepField = new JTextField(20);
    JTextField telefoneField = new JTextField(20);
    JTextField userField = new JTextField(20);
    JPasswordField senhaField = new JPasswordField(20);
    JTextField cursoField = new JTextField(20);
    JTextField observacaoField = new JTextField(20);
    JCheckBox ativoCheckbox = new JCheckBox();

    AddMatriculaFrame() {
        baseConfig();
        addInputsToPanel();

    }

    void addInputsToPanel() {

        mainPanel.add(new JLabel("Nome completo: "));
        mainPanel.add(nomeCompletoField);

        mainPanel.add(new JLabel("Idade: "));
        mainPanel.add(idadeField);

        mainPanel.add(new JLabel("Email: "));
        mainPanel.add(emailField);

        mainPanel.add(new JLabel("Endereço: "));
        mainPanel.add(enderecoField);

        mainPanel.add(new JLabel("CEP: "));
        mainPanel.add(cepField);

        mainPanel.add(new JLabel("Telefone: "));
        mainPanel.add(telefoneField);

        mainPanel.add(new JLabel("Usuário: "));
        mainPanel.add(userField);

        mainPanel.add(new JLabel("Senha: "));
        mainPanel.add(senhaField);

        mainPanel.add(new JLabel("Curso: "));
        mainPanel.add(cursoField);

        mainPanel.add(new JLabel("Observação: "));
        mainPanel.add(observacaoField);

        mainPanel.add(new JLabel("Ativo: "));
        mainPanel.add(ativoCheckbox);

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(e -> {
            // Process the form data here
            submitForm();
        });
        mainPanel.add(submitButton);

        getContentPane().add(mainPanel);
        pack();
        setVisible(true);

    }

    void submitForm() {
        MatriculaRepository matriculaDB = new MatriculaRepository();

        String nomeCompleto = nomeCompletoField.getText();
        int idade = idadeField.getText().isEmpty() ? 0 : Integer.parseInt(idadeField.getText());
        String email = emailField.getText();
        String endereco = enderecoField.getText();
        String cep = cepField.getText();
        String telefone = telefoneField.getText();
        String user = userField.getText();
        String senha = new String(senhaField.getPassword());
        String curso = cursoField.getText();
        String observacao = observacaoField.getText();
        boolean ativo = ativoCheckbox.isSelected();

        MatriculaEntity matricula = new MatriculaEntity(nomeCompleto, idade, email, endereco, cep, telefone, user,
                senha, curso, observacao, ativo);

        matriculaDB.create(matricula);

    }

    void baseConfig() {
        setSize(500, 600);
        setMinimumSize(new Dimension(300, 400));

        mainPanel.setLayout(new GridLayout(0, 1));
    }

}
