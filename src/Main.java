import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    private static JPanel panel;
    private static JFrame frame;
    private static JLabel usernameLabel;
    private static JTextField usernameText;
    private static JLabel passwordLabel;
    private static JPasswordField passwordText;
    private static JLabel ageLabel;
    private static JTextField ageText;
    private static JButton submitButton;
    private static JButton refreshButton;
    private static JLabel result;

    public static void main(String[] args) {
        // initialize panel and frame
        panel = new JPanel();
        frame = new JFrame();
        frame.setTitle("Input Form");
        frame.setSize(350, 230);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);

        panel.setLayout(null);

        // handle username
        usernameLabel = new JLabel("User Name");
        usernameLabel.setBounds(10, 20, 80, 25);
        panel.add(usernameLabel);

        usernameText = new JTextField(20);
        usernameText.setBounds(100, 20, 165, 25);
        panel.add(usernameText);

        // handle password
        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10, 50, 80, 25);
        panel.add(passwordLabel);

        passwordText = new JPasswordField();
        passwordText.setBounds(100, 50, 165, 25);
        panel.add(passwordText);

        // handle age
        ageLabel = new JLabel("Age");
        ageLabel.setBounds(10, 80, 80, 25);
        panel.add(ageLabel);

        ageText = new JTextField();
        ageText.setBounds(100, 80, 165, 25);
        panel.add(ageText);

        // define buttons
        submitButton = new JButton("Submit");
        submitButton.setBounds(10, 110, 120, 25);
        panel.add(submitButton);

        refreshButton = new JButton("Refresh");
        refreshButton.setBounds(150, 110, 120, 25);
        panel.add(refreshButton);

        // define actions for buttons
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String age = ageText.getText();
                try {
                    Double.parseDouble(age);
                    result.setText("User input submitted successfully!");
                } catch (NumberFormatException ex) {
                    result.setText("Invalid input. Please enter a valid number for age");
                }
            }
        });

        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                usernameText.setText("");
                passwordText.setText("");
                ageText.setText("");
                result.setText("");
            }
        });

        // handle result display
        result = new JLabel("");
        result.setBounds(10, 140, 300, 25);
        panel.add(result);

        frame.setVisible(true);
    }
}