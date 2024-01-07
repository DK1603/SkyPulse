package com.dk1603.weather_app;

import javax.swing.*;

// Login frame to proceed the registration 
public class LoginFrame extends JFrame {
	private static final long serialVersionUID = 1L;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton registerButton;
    private AccountManager accountManager;

    public LoginFrame(AccountManager accountManager) {
        this.accountManager = accountManager;
        initComponents();
    }

    private void initComponents() {
        // Initialize components
        usernameField = new JTextField(30);
        passwordField = new JPasswordField(30);
        loginButton = new JButton("Login");
        registerButton = new JButton("Register");

        // Set layout and add components
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        getContentPane().add(new JLabel("Username:"));
        getContentPane().add(usernameField);
        getContentPane().add(new JLabel("Password:"));
        getContentPane().add(passwordField);
        getContentPane().add(loginButton);
        getContentPane().add(registerButton);

        // Add action listeners
        loginButton.addActionListener(evt -> loginButtonActionPerformed());
        registerButton.addActionListener(evt -> registerButtonActionPerformed());

        // Frame settings
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center on screen
    }
     
    // Methods to receive user data after pressing login or register btn
    private void loginButtonActionPerformed() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        if (accountManager.loginUser(username, password)) {
            JOptionPane.showMessageDialog(this, "Login Successful");
            this.setVisible(false); // Hide the login frame
            UI mainUI = new UI(username, accountManager); // Create an instance of the main UI
            mainUI.setVisible(true); // Show the main UI
        } else {
            JOptionPane.showMessageDialog(this, "Login Failed", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    private void registerButtonActionPerformed() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        if (accountManager.registerUser(username, password)) {
            JOptionPane.showMessageDialog(this, "Registration Successful");
        } else {
            JOptionPane.showMessageDialog(this, "Username already taken", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}
