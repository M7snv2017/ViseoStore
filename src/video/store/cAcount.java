package video.store;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class cAcount extends JFrame
{
    JLabel acountTitle,
            phoneLabel,
            userLabel,
            passLabel;
    JTextField phoneField, //uneditable
               userField;
    JPasswordField passField;
    JButton showPass,//fancyButton
            updateButton;
    public cAcount()
    {
        super("Acount");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 600);
        setVisible(true);
        
        GridBagConstraints gbc = new GridBagConstraints();
        GridBagLayout gl = new GridBagLayout();
        setLayout(gl);
        
        acountTitle = new JLabel("Acount Information");
        acountTitle.setFont(new Font("Arial", Font.BOLD, 20));
        gbc.gridx=1;
        gbc.gridy=0;
        gbc.gridwidth=2;
        gbc.insets = new Insets(5,0,50,0);       
        gbc.anchor = GridBagConstraints.NORTH;
        add(acountTitle,gbc);
        
        gbc.gridwidth = 1;
        
        phoneLabel = new JLabel("Phone NO.");
        gbc.insets = new Insets(5,0,5,0);  
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        add(phoneLabel, gbc);
        
        phoneField = new JTextField("HI", 10);
        gbc.insets = new Insets(5,5,5,0);  
        phoneField.setEditable(false);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.EAST;
        add(phoneField, gbc);
        
        userLabel = new JLabel("Username");
        gbc.insets = new Insets(5,0,5,0);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        add(userLabel, gbc);
        
        userField = new JTextField("mvsbacj,h", 10);
        gbc.insets = new Insets(5,5,5,0);  
        userField.setEditable(false);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(userField, gbc);
        
        passLabel = new JLabel("Password");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        add(passLabel, gbc);

        passField = new JPasswordField(15);
        passField.setEditable(false);
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(passField, gbc);
    }
    public static void main(String[] args) {
        new cAcount();
    }
}
