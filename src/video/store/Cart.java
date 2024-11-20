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

public class Cart extends JPanel {
    public Cart() {
        setLayout(new BorderLayout());

       
        JPanel sidebar = new JPanel(new GridBagLayout());
        sidebar.setPreferredSize(new Dimension(120, 0));
        sidebar.setBackground(new Color(204, 204, 204));

        String[] buttonNames = {"Main", "Favorite", "Cart", "Account"};
        Color bgColor = new Color(135, 135, 135);
        Font buttonFont = new Font("Arial", Font.BOLD, 14);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;
        gbc.insets = new Insets(5, 5, 5, 5);

        for (int i = 0; i < 3; i++) {
            JButton button = new JButton(buttonNames[i]);
            button.setBackground(bgColor);
            button.setForeground(Color.BLACK);
            button.setFont(buttonFont);
            button.setFocusPainted(false);
            button.setPreferredSize(new Dimension(100, 30));
            gbc.gridx = 0;
            gbc.gridy = i;
            sidebar.add(button, gbc);
        }

        JButton lastButton = new JButton(buttonNames[3]);
        lastButton.setBackground(bgColor);
        lastButton.setForeground(Color.BLACK);
        lastButton.setFont(buttonFont);
        lastButton.setFocusPainted(false);
        lastButton.setPreferredSize(new Dimension(100, 30));
        gbc.gridy = 4;
        gbc.weighty = 1.0;
        sidebar.add(lastButton, gbc);

        
        JPanel cartPanel = new JPanel(new BorderLayout());

        JLabel cartLabel = new JLabel("Cart", JLabel.CENTER);
        cartLabel.setFont(new Font("Arial", Font.BOLD, 20));
        cartLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        cartPanel.add(cartLabel, BorderLayout.NORTH);

      
        JPanel itemsPanel = new JPanel();
        itemsPanel.setLayout(new BoxLayout(itemsPanel, BoxLayout.Y_AXIS)); 
        itemsPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        for (int i = 0; i < 3; i++) {
           
            JPanel itemPanel = new JPanel();
            itemPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10)); 

           
            JLabel iconLabel = new JLabel("Icon", JLabel.CENTER);
            iconLabel.setPreferredSize(new Dimension(100, 100)); 
            itemPanel.add(iconLabel);

           
            JPanel infoPanel = new JPanel();
            infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
            JLabel titleLabel = new JLabel("Title: ___");
            JLabel priceLabel = new JLabel("Price: ___");
            infoPanel.add(titleLabel);
            infoPanel.add(priceLabel);
            itemPanel.add(infoPanel);

            
            JButton removeButton = new JButton("Remove");
            removeButton.setPreferredSize(new Dimension(100, 30)); 
            itemPanel.add(removeButton);

           
            itemsPanel.add(itemPanel);
        }

        cartPanel.add(itemsPanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.Y_AXIS));
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));

        JLabel totalLabel = new JLabel("Total: $X", JLabel.CENTER);
        totalLabel.setFont(new Font("Arial", Font.BOLD, 16));
        totalLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton buyButton = new JButton("Buy");
        buyButton.setFont(new Font("Arial", Font.BOLD, 16));
        buyButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        buyButton.setPreferredSize(new Dimension(100, 40));

        bottomPanel.add(totalLabel);
        bottomPanel.add(Box.createVerticalStrut(10));
        bottomPanel.add(buyButton);

        cartPanel.add(bottomPanel, BorderLayout.SOUTH);

        
        add(sidebar, BorderLayout.WEST);
        add(cartPanel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Cart");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 500); 
        frame.setLayout(new BorderLayout());

        Cart cart = new Cart();
        frame.add(cart, BorderLayout.CENTER);

        frame.setVisible(true);
    }
}