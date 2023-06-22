package modena.ui.admin;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import modena.ui.BaseFrame;

public class DashboardFrame extends BaseFrame {
    JPanel mainPanel = new JPanel();

    public void initialize() {
        super.initialize("Dashboard");
        baseConfig();
        super.add(mainPanel);
        super.setVisible(true);

    }

    public void baseConfig() {
        JFrame frame = new JFrame("Grid Layout Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel(new GridLayout(1, 3));

        for (int i = 1; i <= 3; i++) {
            JPanel panel = new JPanel();
            panel.setLayout(new BorderLayout());

            JLabel titleLabel = new JLabel("Panel " + i + " Title");
            titleLabel.setHorizontalAlignment(JLabel.CENTER);
            panel.add(titleLabel, BorderLayout.NORTH);

            JButton button = new JButton("Open Frame " + i);
            button.addActionListener(new ButtonListener());
            panel.add(button, BorderLayout.CENTER);

            mainPanel.add(panel);
        }

        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setVisible(true);

    }

    private static class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton source = (JButton) e.getSource();
            String buttonText = source.getText();
            int frameNumber = Integer.parseInt(buttonText.substring(buttonText.lastIndexOf(" ") + 1));

            JFrame newFrame = new JFrame("New Frame " + frameNumber);
            newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            newFrame.setSize(300, 200);

            JLabel label = new JLabel("This is Frame " + frameNumber);
            label.setHorizontalAlignment(JLabel.CENTER);
            newFrame.getContentPane().add(label);

            newFrame.setVisible(true);
        }

    }

}
