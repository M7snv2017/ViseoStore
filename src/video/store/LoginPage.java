package video.store;

/**
 *  This class was initially created by Abdulrahman, and improved by Mustafa since there was issues.
 * @author Mustafa
 */

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.SharedSources.*;
import main.SharedSources.Util.*;

public class LoginPage extends JFrame implements ActionListener {
    static JLabel usernameLbl = new JLabel("Username:");
    static JLabel passwordLbl = new JLabel("Password:");

    static JTextField username = new JTextField(20);
    static JPasswordField password = new JPasswordField(20);

    static JButton loginBtn = new JButton("Login");
    static JButton cancelBtn = new JButton("Cancel");

    public LoginPage() {
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
        username.setText("Enter Your Unsername");
        username.addFocusListener(new placeHolderListener());
        this.add(username, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        this.add(passwordLbl, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        password.setText("Enter Your Password");
        password.addFocusListener(new placeHolderListener());
        this.add(password, gbc);

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

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginBtn) {
            String uName = username.getText();
            String pass = password.getText();
        }

        if (e.getSource() == cancelBtn) {

        }
    }

    public static void main(String[] args) {
        LoginPage frm = new LoginPage();
    }
}
