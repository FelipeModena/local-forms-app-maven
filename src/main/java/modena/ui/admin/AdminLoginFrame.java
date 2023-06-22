package modena.ui.admin;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import modena.infra.usecase.AdminUsecase;
import modena.ui.BaseFrame;

public class AdminLoginFrame extends BaseFrame {
    private JTextField userField = new JTextField("admin", 20);
    private JTextField passwordField = new JTextField("admin", 20);
    private UI ui = new UI();

    public void initialize() {
        // ui.addImageToPanel();
        ui.addInputsToPanel();
        super.initialize("Login");
        super.setVisible(true);
    }

    private class UI {
        private void addImageToPanel() {
            try {

                // get acutal path
                BufferedImage myPicture = ImageIO.read(new File("src/main/resources/images/logo.png"));
                JLabel picLabel = new JLabel(new javax.swing.ImageIcon(myPicture));
                mainPanel.add(picLabel);
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        private void addInputsToPanel() {
            JButton loginButton = new JButton("Login");
            // add input for user and password
            JLabel userLabel = new JLabel("Usuário: ");
            JLabel passwordLabel = new JLabel("Senha: ");

            mainPanel.setLayout(new GridBagLayout());

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.anchor = GridBagConstraints.LINE_END;
            gbc.insets = new Insets(10, 10, 0, 10);
            mainPanel.add(userLabel, gbc);

            gbc.gridy = 1;
            mainPanel.add(passwordLabel, gbc);

            gbc.gridx = 1;
            gbc.gridy = 0;
            gbc.anchor = GridBagConstraints.LINE_START;
            gbc.insets = new Insets(10, 0, 0, 10);
            mainPanel.add(userField, gbc);

            gbc.gridy = 1;
            mainPanel.add(passwordField, gbc);

            gbc.gridx = 0;
            gbc.gridy = 2;
            gbc.gridwidth = 2;
            gbc.anchor = GridBagConstraints.CENTER;
            gbc.insets = new Insets(20, 10, 10, 10);
            mainPanel.add(loginButton, gbc);

            loginButton.addActionListener(e -> {
                Business business = new Business();
                business.login();
            });

        }

    }

    private class Business {
        AdminUsecase adminBusiness = new AdminUsecase();

        private void login() {
            UserLogin user = new UserLogin();

            user.username = userField.getText();
            user.password = passwordField.getText();

            if (adminBusiness.loginUser(user.username, user.password)) {
                new DashboardFrame().initialize();
                dispose();
            } else {
                System.out.println("Login failed");
            }

        }

        class UserLogin {
            String username;
            String password;
        }
    }
}
