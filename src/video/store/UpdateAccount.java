package video.store;

/**
 * This class was initially created by Mohsin, and improved by Mustafa.
 *
 * @author Mustafa
 */
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
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

public class UpdateAccount extends JFrame implements ActionListener {

    static int customer_id;

    static JLabel usernameLbl = new JLabel("Username:");
    static JLabel passwordLbl = new JLabel("Password:");
    static JLabel password2Lbl = new JLabel("Confirm Password:");

    static JTextField username = new JTextField(20);
    static JPasswordField password = new JPasswordField(20);
    static JPasswordField password2 = new JPasswordField(20);

    static JButton updateBtn = new JButton("Update");
    static JButton cancelBtn = new JButton("Cancel");

    AccountPage a;
    Customer c;
    private Connection conn;

    public UpdateAccount(Customer c, AccountPage a) {

        customer_id = c.customerId;
        JOptionPane.showMessageDialog(null, "Here");
        this.setTitle("Update Information");
        this.setSize(400, 250);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.weighty = 0.1;
        gbc.weightx = 1.0;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        this.add(usernameLbl, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        username.setText(c.customerUserName);
        username.addFocusListener(new placeHolderListener());
        this.add(username, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        this.add(passwordLbl, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        password.setText(c.customerPassword);
        password.setEchoChar((char) 0);
        password.addFocusListener(new placeHolderListener());
        this.add(password, gbc);

        JToggleButton showPass = Util.createShowHide(password, password2);
        gbc.gridx = 2;
        this.add(showPass, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        this.add(password2Lbl, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        password2.setText("Confirm Password");
        password2.addFocusListener(new placeHolderListener());
        this.add(password2, gbc);

        updateBtn.addActionListener(this);
        cancelBtn.addActionListener(this);

        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.LINE_START;
        this.add(updateBtn, gbc);

        gbc.anchor = GridBagConstraints.LINE_END;
        this.add(cancelBtn, gbc);

        this.setVisible(true);

        this.a = a;
        this.c = c;
    }

    private void connectToDatabase() {
        try {
            conn = DriverManager.getConnection(
                    "jdbc:mysql://sql12.freesqldatabase.com:3306/sql12747559",
                    "sql12747559",
                    "zdI3qyjlca"
            );
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Database connection failed: " + e.getMessage());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == updateBtn) {
            connectToDatabase();
            String uName = username.getText();
            String pass = new String(password.getPassword());
            String pass2 = new String(password2.getPassword());
            System.out.println(uName + "\n" + pass);

            if (pass != pass2) {
                JOptionPane.showMessageDialog(null, "Passwords Do not Match", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                String sql = "UPDATE Customer SET username = '" + uName + "', password = '" + pass + "' WHERE id = '" + customer_id + "'";

                try (Statement stmt = conn.createStatement()) {

                    int rowsInserted = stmt.executeUpdate(sql);
                    if (rowsInserted > 0) {
                        c.setUsername(uName);
                        c.setPassword(pass);
                        JOptionPane.showMessageDialog(null, "Update Successfully", "Info", JOptionPane.INFORMATION_MESSAGE);

                    } else {
                        JOptionPane.showMessageDialog(null, "Update Failed. Please Try Again.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Database Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();
                }

                this.dispose();
            }
            if (e.getSource() == cancelBtn) {
//           
                this.dispose();
            }

            a.c = c;
            a.refresh(c);
        }
    }
}
