/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package video.store;

/**
 *
 * @author nawaf
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Registration extends JPanel {
    JLabel title, phoneNO, username, password, confirmPass;
    JTextField tphoneNO, tusername;
    JPasswordField tpassword, tconfirmPass;
    JButton register;

    public Registration() {
        setSize(500, 280);
        setLayout(new GridBagLayout());
        GridBagConstraints grid = new GridBagConstraints();

        
        Insets ins1 = new Insets(0, 0, 10, 10);
        Insets ins2 = new Insets(40, 0, 10, 10);

        
        grid.gridy = 0;
        grid.gridwidth = 2;
        grid.insets = ins2;
        grid.fill = GridBagConstraints.NORTH;
        title = new JLabel("Registration Page");
        title.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        add(title, grid);

        
        grid.insets = ins1;
        grid.gridwidth = 1;
        grid.gridy++;
        grid.gridx = 0;
        phoneNO = new JLabel("Phone No.");
        add(phoneNO, grid);

        grid.gridx = 1;
        tphoneNO = new JTextField(16);
        add(tphoneNO, grid);

        
        grid.gridy++;
        grid.gridx = 0;
        username = new JLabel("Username");
        add(username, grid);

        grid.gridx = 1;
        tusername = new JTextField(16);
        add(tusername, grid);

        
        grid.gridy++;
        grid.gridx = 0;
        password = new JLabel("Password");
        add(password, grid);

        grid.gridx = 1;
        tpassword = new JPasswordField(16);
        add(tpassword, grid);

        
        grid.gridy++;
        grid.gridx = 0;
        confirmPass = new JLabel("Confirm Password");
        add(confirmPass, grid);

        grid.gridx = 1;
        tconfirmPass = new JPasswordField(16);
        add(tconfirmPass, grid);

        
        grid.gridy++;
        grid.gridwidth = 2;
        grid.fill = GridBagConstraints.CENTER;
        register = new JButton("Register");
        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(null,
                        "continue",
                        "Confirmation",
                        JOptionPane.OK_CANCEL_OPTION
                );

                if (result == JOptionPane.OK_OPTION) {
                    JOptionPane.showMessageDialog(null, "Registration Successful!");
                }
            }
        });
        add(register, grid);

        
        validate();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Panel Switch Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 280);
        frame.setLocationRelativeTo(null);
        frame.add(new Registration());
        frame.setVisible(true);
    }
}
