package video.store;

/**
 * 
 * @author Mohsin
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import main.SharedSources.*;

public class AccountPage extends JPanel
{
    JLabel  phoneLabel,
            userLabel,
            passLabel;
    JTextField phoneField, //uneditable
               userField;
    JPasswordField passField;
    //UpdateAccount ua;
    Customer c;
    static JButton updateButton;
    
    public AccountPage(Customer customer)
    {
        this.setLayout(new BorderLayout(10,20));
        JPanel borderPanel = new JPanel();
        
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        c=customer;
        
        JLabel title = new JLabel("Acount Information", SwingConstants.CENTER);
        title.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        this.add(title, BorderLayout.NORTH);
        
        gbc.gridwidth = 1;
        
        userLabel = new JLabel("Username");
        gbc.insets = new Insets(5,0,5,0);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        infoPanel.add(userLabel, gbc);
        
        userField = new JTextField(c.customerUserName,10);
        gbc.insets = new Insets(5,5,5,0);  
        userField.setEditable(false);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        infoPanel.add(userField, gbc);
        
        passLabel = new JLabel("Password");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        infoPanel.add(passLabel, gbc);

        passField = new JPasswordField(c.customerPassword,15);
        passField.setEditable(false);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        infoPanel.add(passField, gbc);
        
        JToggleButton showPass = Util.createShowHide(passField);

        showPass.setSize(new Dimension(5,5));
        gbc.insets = new Insets(5,10,5,0); 
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.NONE;
        
        infoPanel.add(showPass, gbc);
        
        gbc.gridy = 3;
        gbc.gridx = 1;
        infoPanel.add(Box.createVerticalGlue(), gbc);  

        updateButton = new JButton("Upadte Information");
        gbc.insets = new Insets(5,0,5,0);
        gbc.gridx=1;
        gbc.gridy=4;
        gbc.weighty = 0;
        gbc.gridwidth=2;
        gbc.fill= GridBagConstraints.WEST;
        updateButton.addActionListener(new ActionListener(){
            private UpdateAccount updateAccount;

            @Override
            public void actionPerformed(ActionEvent e) 
            {
                updateAccount = new UpdateAccount(c,AccountPage.this);
            }
        });
        infoPanel.add(updateButton,gbc);
        validate();

        infoPanel.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));

        borderPanel.add(infoPanel);
        this.add(borderPanel, BorderLayout.CENTER);
    }
     public void refresh(Customer c) {
        removeAll();
        revalidate();
        repaint(); 
        
        this.setLayout(new BorderLayout(10,20));
        JPanel borderPanel = new JPanel();
        
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        this.c=c;
        
        JLabel title = new JLabel("Acount Information", SwingConstants.CENTER);
        title.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        this.add(title, BorderLayout.NORTH);
        
        gbc.gridwidth = 1;
        
        userLabel = new JLabel("Username");
        gbc.insets = new Insets(5,0,5,0);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        infoPanel.add(userLabel, gbc);
        
        userField = new JTextField(c.customerUserName,10);
        gbc.insets = new Insets(5,5,5,0);  
        userField.setEditable(false);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        infoPanel.add(userField, gbc);
        
        passLabel = new JLabel("Password");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        infoPanel.add(passLabel, gbc);

        passField = new JPasswordField(c.customerPassword,15);
        passField.setEditable(false);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        infoPanel.add(passField, gbc);
        
        JToggleButton showPass = Util.createShowHide(passField);

        showPass.setSize(new Dimension(5,5));
        gbc.insets = new Insets(5,10,5,0); 
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.NONE;
        
        infoPanel.add(showPass, gbc);
        
        gbc.gridy = 3;
        gbc.gridx = 1;
        infoPanel.add(Box.createVerticalGlue(), gbc);  

        updateButton = new JButton("Upadte Information");
        gbc.insets = new Insets(5,0,5,0);
        gbc.gridx=1;
        gbc.gridy=4;
        gbc.weighty = 0;
        gbc.gridwidth=2;
        gbc.fill= GridBagConstraints.WEST;
        updateButton.addActionListener(new ActionListener(){
            private UpdateAccount updateAccount;

            @Override
            public void actionPerformed(ActionEvent e) 
            {
                updateAccount = new UpdateAccount(c,AccountPage.this);
            }
        });
        infoPanel.add(updateButton,gbc);
        validate();

        infoPanel.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));

        borderPanel.add(infoPanel);
        this.add(borderPanel, BorderLayout.CENTER);
    }
    //For test
    public static void main(String[] args) {
        JFrame frm = new JFrame();
        AccountPage p = new AccountPage(null);
        frm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frm.setSize(900,600);
        frm.setLocationRelativeTo(null);
        frm.add(p);
        frm.setVisible(true);
    }
}
