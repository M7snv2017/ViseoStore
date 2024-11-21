package video.store;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.Box;
import javax.swing.BoxLayout;

public class HomePage extends JFrame{
    JLabel welcomeLabel = new JLabel("Welcome to the Video Store");
    JLabel loginAsAdminLabel = new JLabel("Login as Admin");
    ImageIcon logo;
    JButton loginButton = new JButton("Login");
    JButton registerButton = new JButton("Register");

    public HomePage(){
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        this.setSize(500, 280);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.add(welcomeLabel);
        this.add(loginButton);
        this.add(registerButton);
        this.add(loginAsAdminLabel);

        this.setVisible(true);
    }

}
