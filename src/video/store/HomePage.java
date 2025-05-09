package video.store;

/**
 *  This class was initially created by Abdulrahman, and improved by Mustafa since there was issues.
 * @author Mustafa
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import main.SharedSources.Util;
import static main.SharedSources.Util.createButton;

public class HomePage extends JFrame {
    private final Color ButtonBgColor = new Color(59, 89, 182);
    private final Color ButtonFgColor = Color.WHITE;
    private final Font ButtonFont = new Font("Tahoma", Font.BOLD, 16);

    public HomePage() {
        super("Home Page");
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    LoginPage login = new LoginPage(HomePage.this);
                    login.setVisible(true);
                }
            }
        });
        
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(Box.createRigidArea(new Dimension(0, 30)));
        
        JLabel logo = new JLabel();
        try {
            ImageIcon icn = new ImageIcon("src\\resources\\images\\logo.png");
            Image image = icn.getImage();
            Image newimg = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            icn = new ImageIcon(newimg);
            logo.setIcon(icn);
        } catch (Exception e) {
            logo.setText("Cannot display logo");
        }

        logo.setPreferredSize(new Dimension(80, 80));
        logo.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        logo.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(logo);

        JLabel welcomeLabel = new JLabel("Welcome to MyVideo Store", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Monospaced",Font.BOLD, 16));
        welcomeLabel.setForeground(Color.BLACK);
        welcomeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(welcomeLabel);

        JButton loginButton = createButton("Login", ButtonBgColor, ButtonFgColor, ButtonFont);
        Util.hoverListener(loginButton);
        loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(Box.createRigidArea(new Dimension(0, 30)));
        loginButton.addActionListener((ActionEvent e) -> {
            LoginPage login = new LoginPage(HomePage.this);
            login.setVisible(true);
        });
        panel.add(loginButton);

        JButton registerButton = createButton("Register", ButtonBgColor, ButtonFgColor, ButtonFont);
        Util.hoverListener(registerButton);
        registerButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(Box.createRigidArea(new Dimension(0, 5)));
        registerButton.addActionListener((ActionEvent e) -> {
            RegistrationPage register = new RegistrationPage(HomePage.this);
            register.setVisible(true);
        });
        panel.add(registerButton);

        add(panel, BorderLayout.CENTER);

        setVisible(true);
    }

    //for test
    public static void main (String []args) {
        SwingUtilities.invokeLater(() -> {
            HomePage frm = new HomePage();
            frm.requestFocus();
            frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frm.setSize(450,330);
            frm.setResizable(false);
            frm.setLocationRelativeTo(null);
            frm.setVisible(true);
        });	     
    }
}