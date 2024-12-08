package video.store;
//37.121.237.221

/**
 *
 * @author Mustafa
 */
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

import main.SharedSources.Util;
import main.SharedSources.Util.placeHolderListener;

public class RegistrationPage extends JFrame {

    String url = "jdbc:mysql://sql12.freesqldatabase.com:3306/sql12747559?user=sql12747559&password=zdI3qyjlca";

    static JLabel usernameLbl = new JLabel("Username:");
    static JLabel passwordLbl = new JLabel("Password:");
    static JLabel password2Lbl = new JLabel("Confirm Password:");

    static JTextField usernameField = new JTextField(20);
    static JPasswordField passwordField = new JPasswordField(20);
    static JPasswordField password2Field = new JPasswordField(20);

    static JButton registerBtn = new JButton("Register");
    static JButton cancelBtn = new JButton("Cancel");

    HomePage hp;
    CStream main;

    public RegistrationPage(HomePage hp) {

        this.hp = hp;

        this.setTitle("RegistrationPage");
        this.setSize(400, 250);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setLayout(new GridBagLayout());

        KeyAdapter keyAdapter = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    performRegistration();
                }
            }
        };

        usernameField.addKeyListener(keyAdapter);
        passwordField.addKeyListener(keyAdapter);
        password2Field.addKeyListener(keyAdapter);

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty = 0.1;
        gbc.weightx = 1.0;

        gbc.anchor = GridBagConstraints.CENTER;
        this.add(usernameLbl, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        usernameField.setText("Enter New Username");
        usernameField.addFocusListener(new placeHolderListener());
        this.add(usernameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        this.add(passwordLbl, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        passwordField.setText("Enter New Password");
        passwordField.addFocusListener(new placeHolderListener());
        this.add(passwordField, gbc);

        JToggleButton showPass = Util.createShowHide(passwordField, password2Field);
        gbc.gridx = 2;
        this.add(showPass, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        this.add(password2Lbl, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        password2Field.setText("Confirm Password");
        password2Field.addFocusListener(new placeHolderListener());
        this.add(password2Field, gbc);

        registerBtn.addActionListener((ActionEvent e) -> {
            performRegistration();
        });

        cancelBtn.addActionListener(e -> this.dispose());

        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.LINE_START;
        this.add(registerBtn, gbc);

        gbc.anchor = GridBagConstraints.LINE_END;
        this.add(cancelBtn, gbc);

        this.setVisible(true);

    }

    public boolean exist(String username) {
        String sql = "SELECT COUNT(*) AS exist FROM Customer WHERE username = '" + username + "'";

        try (Connection connection = DriverManager.getConnection(url); Statement stmt = connection.createStatement()) {

            try (ResultSet rs = stmt.executeQuery(sql)) {
                if (rs.next()) {
                    return rs.getInt("exist") > 0; // Check if username exists
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Database Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();

        }
        return false;
    }

    private void performRegistration() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());
        String password2 = new String(password2Field.getPassword());

        if (username.isEmpty() || password.isEmpty() || password2.isEmpty()) {
            JOptionPane.showMessageDialog(RegistrationPage.this, "All Fields are Required", "Retry", JOptionPane.WARNING_MESSAGE);
        } else if (exist(username)) {
            JOptionPane.showMessageDialog(RegistrationPage.this, "Username Already Exists", "Used Username", JOptionPane.ERROR_MESSAGE);
        } else if (!password.equals(password2)) {
            JOptionPane.showMessageDialog(RegistrationPage.this, "Passwords Do Not Match", "Retry", JOptionPane.ERROR_MESSAGE);
        } else {
            int id = Customer.newid(); // Assuming Customer.newid() generates a new id
            System.out.println(id);
            // Directly constructing the SQL string with concatenation
            String sql = "INSERT INTO Customer (id, username, password) VALUES ('" + id + "', '" + username + "', '" + password + "')";

            try (Connection connection = DriverManager.getConnection(url); Statement stmt = connection.createStatement()) {

                int rowsInserted = stmt.executeUpdate(sql);
                if (rowsInserted > 0) {
                    JOptionPane.showMessageDialog(RegistrationPage.this, "Account Registered Successfully.", "Welcome", JOptionPane.INFORMATION_MESSAGE);
                    RegistrationPage.this.dispose();
                    hp.dispose();
                    Customer c = new Customer();
                    c.customerId = id;
                    c.customerPassword = password;
                    c.customerUserName = username;
                    main = new CStream(c);
                    main.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(RegistrationPage.this, "Registration Failed. Please Try Again.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(RegistrationPage.this, "Database Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        }
    }
}
