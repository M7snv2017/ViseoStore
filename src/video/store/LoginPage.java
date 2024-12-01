package video.store;

/**
 * This class was initially created by Abdulrahman, and improved by Mustafa
 * since there was issues.
 *
 * @author Mustafa
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;
import java.sql.*;
import main.SharedSources.Util.placeHolderListener;

public class LoginPage extends JFrame {

    static JLabel usernameLbl = new JLabel("Username:");
    static JLabel passwordLbl = new JLabel("Password:");

    static JTextField usernameField = new JTextField(20);
    static JPasswordField passwordField = new JPasswordField(20);

    static JButton loginBtn = new JButton("Login");
    static JButton cancelBtn = new JButton("Cancel");
    
    CStream main;
    HomePage hp;
    public LoginPage(HomePage hp) 
    {
        this.hp=hp;
        
        loginBtn.addActionListener((ActionEvent e) -> {
            performLogin();
        });

        // Add key listeners to text fields
        usernameField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    performLogin();
                }
            }
        });

        passwordField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    performLogin();
                }
            }
        });

        cancelBtn.addActionListener(e -> this.dispose());

        this.setTitle("Login Page");
        this.setSize(320, 220);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty = 0.1;
        gbc.weightx = 0.1;

        gbc.fill = GridBagConstraints.NONE;
        this.add(usernameLbl, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        usernameField.setText("Enter Your Unsername");
        usernameField.addFocusListener(new placeHolderListener());
        this.add(usernameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        this.add(passwordLbl, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        passwordField.setText("Enter Your Password");
        passwordField.addFocusListener(new placeHolderListener());
        this.add(passwordField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.weightx = 0.8;
        gbc.anchor = GridBagConstraints.LINE_END;
        this.add(loginBtn, gbc);

        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 1;
        gbc.weightx = 0.1;
        this.add(cancelBtn, gbc);

        this.setVisible(true);
    }
    String url = "jdbc:mysql://sql12.freesqldatabase.com:3306/sql12747559?user=sql12747559&password=zdI3qyjlca";   
    
    public boolean exist(String username, String password) {
    String sql = "SELECT COUNT(*) AS exist FROM Customer WHERE username = '" 
                 + username + "' AND password = '" 
                 + password + "'";

    try (Connection connection = DriverManager.getConnection(url);
         Statement stmt = connection.createStatement()) {
        
        try (ResultSet rs = stmt.executeQuery(sql)) {
            if (rs.next()) {
                return rs.getInt("exist") > 0; // Check if the combination exists
            }
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Database Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        e.printStackTrace();
    }
    return false;
}

    private int getId(String username) {
        String sql = "SELECT id FROM Customer WHERE username = "+username;
        int id = -1;

        try (Connection connection = DriverManager.getConnection(url);
             PreparedStatement pstmt = connection.prepareStatement(sql)) {


            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    id = rs.getInt("id");
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Database Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }

        return id;
    }

    private void performLogin() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        // Simple validation 
        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(LoginPage.this, "Username or Password cannot be empty!", "Retry", JOptionPane.WARNING_MESSAGE);
        } else if (!exist(username,password)) {
            JOptionPane.showMessageDialog(LoginPage.this, "Invalid Username or Password!", "Invalid Information", JOptionPane.WARNING_MESSAGE);
        } else if(exist(username,password)){
//            System.gc();
//            for (Window window : Window.getWindows()) {
//                window.dispose();
//                System.out.println("1disposed");
//            }
            //JOptionPane.showMessageDialog(LoginPage.this, "Welcome " + username, "Logged In", JOptionPane.INFORMATION_MESSAGE);
//            for (Window window : Window.getWindows()) {
//                window.dispose();
//                System.out.println("2disposed");
//
//            }
            Customer c= new Customer();
            c.customerId=getId(username);
            main = new CStream(c);
            main.setVisible(true);
            hp.dispose();
            this.dispose();
            
            
        }
    }
}
