package video.store;

/**
 * 
 * @author Mustafa
 */

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.SharedSources.*;
import main.SharedSources.Util.*;

public class RegistrationPage extends JFrame implements ActionListener {
    static JLabel phoneLbl = new JLabel("Phone No.:");
    static JLabel usernameLbl = new JLabel("Username:");
    static JLabel passwordLbl = new JLabel("Password:");
    static JLabel password2Lbl = new JLabel("Confirm Password:");

    static JTextField phone = new JTextField(20);
    static JTextField username = new JTextField(20);
    static JPasswordField password = new JPasswordField(20);
    static JPasswordField password2 = new JPasswordField(20);

    static JButton RegisterBtn = new JButton("Register");
    static JButton cancelBtn = new JButton("Cancel");

    public RegistrationPage() {
        this.setTitle("RegistrationPage");
        this.setSize(340, 250);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty = 0.1;
        gbc.weightx = 0.1;

        this.add(phoneLbl, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        phone.setText("Enter Your Phone Number");
        phone.addFocusListener(new placeHolderListener());
        this.add(phone, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        this.add(usernameLbl, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        username.setText("Enter New Username");
        username.addFocusListener(new placeHolderListener());
        this.add(username, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        this.add(passwordLbl, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        password.setText("Enter New Password");
        password.addFocusListener(new placeHolderListener());
        this.add(password, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.CENTER;
        this.add(password2Lbl, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        password2.setText("Confirm Password");
        password2.addFocusListener(new placeHolderListener());
        this.add(password2, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.weightx = 0.8;
        gbc.anchor = GridBagConstraints.LINE_END;
        this.add(RegisterBtn, gbc);

        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 1;
        gbc.weightx = 0.1;
        this.add(cancelBtn, gbc);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == RegisterBtn) {
            String number = phone.getText();
            String uName = username.getText();
            String pass = password.getText();
        }

        if (e.getSource() == cancelBtn) {

        }
    }

    public static void main(String[] args) {
        RegistrationPage frm = new RegistrationPage();
    }
}
