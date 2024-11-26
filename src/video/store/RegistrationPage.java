package video.store;

/**
 * 
 * @author Mustafa
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;
import main.SharedSources.Util;
import main.SharedSources.Util.placeHolderListener;

public class RegistrationPage extends JFrame {
    static JLabel usernameLbl = new JLabel("Username:");
    static JLabel passwordLbl = new JLabel("Password:");
    static JLabel password2Lbl = new JLabel("Confirm Password:");

    static JTextField usernameField = new JTextField(20);
    static JPasswordField passwordField = new JPasswordField(20);
    static JPasswordField password2Field = new JPasswordField(20);

    static JButton registerBtn = new JButton("Register");
    static JButton cancelBtn = new JButton("Cancel");

    public RegistrationPage() {
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
                    performRegisteration();
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
            performRegisteration();
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

    private void performRegisteration() {
        String username = usernameField.getText(); 
        String password = new String(passwordField.getPassword());
        String password2 =  new String(password2Field.getPassword());

        // Simple validation 
        if (username.isEmpty() || password.isEmpty() || password2.isEmpty()) { 
            JOptionPane.showMessageDialog(RegistrationPage.this, "All Fields are Required", "Retry" ,JOptionPane.WARNING_MESSAGE);
        } else if (username.equals("USER NAME EXISTS")) { 
            JOptionPane.showMessageDialog(RegistrationPage.this, "Username Already Exists", "Used Username" ,JOptionPane.ERROR_MESSAGE);
        } else if (!password.equals(password2)) {
            JOptionPane.showMessageDialog(RegistrationPage.this, "Passwords Do not Match", "Retry" ,JOptionPane.ERROR_MESSAGE);
        } else { 
            JOptionPane.showMessageDialog(RegistrationPage.this, "Account Registered Successfully.", "Welcome" ,JOptionPane.INFORMATION_MESSAGE);
            RegistrationPage.this.dispose();
        } 
    }  

    public static void main(String[] args) {
        RegistrationPage frm = new RegistrationPage();
    }
}
