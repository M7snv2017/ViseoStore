package video.store;

/**
 *  This class was initially created by Mohsin, and improved by Mustafa.
 * @author Mustafa
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.*;
import javax.swing.*;
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
    public UpdateAccount(Customer c,AccountPage a) {
        
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
        
        this.a=a;
        this.c=c;
    }
    
    String url = "jdbc:mysql://sql12.freesqldatabase.com:3306/sql12747559?user=sql12747559&password=zdI3qyjlca";

    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == updateBtn) {
         JOptionPane.showMessageDialog(null, "Update Successfully.hi"+customer_id, "Info", JOptionPane.INFORMATION_MESSAGE);

            String uName = username.getText();
            String pass =new String( password.getPassword());
            System.out.println(uName+"\n"+pass);
            //
            String sql = "UPDATE Customer SET username = '" + uName + "', password = '" + pass + "' WHERE id = " + customer_id;
            

        try (Connection connection = DriverManager.getConnection(url);
             Statement stmt = connection.createStatement()) {

            int rowsInserted = stmt.executeUpdate(sql);
            if (rowsInserted > 0) {
                Customer c = new Customer();
                JOptionPane.showMessageDialog(null, "Update Successfully.hi"+customer_id, "Info", JOptionPane.INFORMATION_MESSAGE);

            } else {
                JOptionPane.showMessageDialog(null, "Update Failed. Please Try Again.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Database Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
            //
//            this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
            this.dispose();
        }

        if (e.getSource() == cancelBtn) {
//            this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
            this.dispose();
        }
        
        a.c=c;
        a.refresh(c);
    }
    //for test
//    public static void main(String[] args) {
//        UpdateAccount frm = new UpdateAccount(1);
//    }
}

