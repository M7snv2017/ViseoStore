
package video.store;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class UpdateAccount extends JPanel
{
    JLabel  title,
            phoneNO,
            username,
            password,
            confirmPass;
    JTextField tphoneNO,
               tusername;
    JPasswordField tpassword,
               tconfirmPass;
    JButton update;
    
    public UpdateAccount(cAcount back){
//        super("Update Acount");
//        
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setVisible(true);
        setSize(900,600);
        
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        Insets ins1 = new Insets(0,0,10,10);
        Insets ins2 = new Insets(120,0,10,10);
        gbc.gridy=0;
        gbc.gridwidth=2;
        gbc.fill = GridBagConstraints.NORTH;
        title = new JLabel("Update Information");
        title.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        add(title,gbc);
        
        gbc.insets=ins2;
        gbc.gridwidth=1;
        
        //phone
        gbc.gridy++;
        gbc.gridx=0;
        
        phoneNO = new JLabel("Phone No.");
        add(phoneNO,gbc);
        
        gbc.gridx++;
        tphoneNO = new JTextField(16);
        add(tphoneNO,gbc);
        
        gbc.insets=ins1;
        //username
        gbc.gridy++;
        gbc.gridx=0;
        username = new JLabel("UserName");
        add(username,gbc);
        
        gbc.gridx++;
        tusername = new JTextField(16);
        add(tusername,gbc);
        
        //password
        gbc.gridy++;
        gbc.gridx=0;
        password = new JLabel("Password");
        add(password,gbc);
        
        gbc.gridx++;
        tpassword = new JPasswordField(16);
        add(tpassword,gbc);
        
        //Confirm Password
        gbc.gridy++;
        gbc.gridx=0;
        confirmPass = new JLabel("Password");
        add(confirmPass,gbc);
        
        gbc.gridx++;
        tconfirmPass = new JPasswordField(16);
        add(tconfirmPass,gbc);
        
        gbc.gridy++;
        gbc.gridwidth+=3;
        gbc.fill = GridBagConstraints.CENTER;
        update = new JButton("Update");
        update.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int result = JOptionPane.showConfirmDialog(null,
                                "Are you sure you want to proceed?",
                                "Confirmation",
                                JOptionPane.OK_CANCEL_OPTION
                        );

                        // Check if OK button was clicked
                        if (result == JOptionPane.OK_OPTION) {
                            
                            back.setVisible(true);
                            setVisible(false);
                            
                            //call function to open update account
                        }
                    }
                });
        add(update,gbc);
        
        // to show them without need to resize the frame
        validate();
    }
//    public static void main(String[] args) {
//        new UpdateAccount(null);
//    }
}
