package video.store;

/**
 *  This class was initially created by Mohsin, and improved by Mustafa.
 * @author Mustafa
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
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

    public UpdateAccount(int id) {
        
        customer_id = id;
        
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
        username.setText("Enter New Username");
        username.addFocusListener(new placeHolderListener());
        this.add(username, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        this.add(passwordLbl, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        password.setText("Enter New Password");
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
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == updateBtn) {
            String uName = username.getText();
            String pass = password.getText();
            JOptionPane.showMessageDialog(null, " Information Updated Successfully.");
            this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        }

        if (e.getSource() == cancelBtn) {
            this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        }
    }

    public static void main(String[] args) {
        UpdateAccount frm = new UpdateAccount(1);
    }
}

