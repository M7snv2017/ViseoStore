package video.store;

/**
 *  This class was initially created by Abdulrahman, and improved by Mustafa since there was issues.
 * @author Mustafa
 */

import main.SharedSources.*;
import javax.swing.*;

import static main.SharedSources.Util.createButton;

import java.awt.*;

public class HomePage extends JFrame {
    private final Color ButtonBgColor = new Color(59, 89, 182);
    private final Color ButtonFgColor = Color.WHITE;
    private final Font ButtonFont = new Font("Tahoma", Font.BOLD, 16);

    public HomePage() {
        super("Home Page");
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
        panel.add(loginButton);

        JButton registerButton = createButton("Register", ButtonBgColor, ButtonFgColor, ButtonFont);
        Util.hoverListener(registerButton);
        registerButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(Box.createRigidArea(new Dimension(0, 5)));
        panel.add(registerButton);

        JLabel adminLoginLabel = new JLabel("Login as an admin", SwingConstants.CENTER);
        adminLoginLabel.setForeground(Color.BLUE);
        adminLoginLabel.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Make it look clickable
        adminLoginLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(adminLoginLabel);

        add(panel, BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main (String []args) {
        SwingUtilities.invokeLater(() -> {
            HomePage frm = new HomePage();
            frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frm.setSize(450,330);
            frm.setResizable(false);
            frm.setLocationRelativeTo(null);
            frm.setVisible(true);
        });	     
    }
}