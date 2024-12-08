package video.store;

/**
 *
 * @author Mustafa
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class CartPage extends JPanel {

    private ArrayList<Video> videos = new ArrayList();
    private double total=0;
    private JLabel totalLabel;
    private Connection conn;
    CStream s;

    public CartPage(ArrayList<Video> video, CStream s) {
        this.s = s;
        videos = video;
        initialize();
    }

    private void initialize() {
        this.setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Cart", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        this.add(titleLabel, BorderLayout.NORTH);

        JPanel purchasePanel = new JPanel();
        purchasePanel.setLayout(new BorderLayout());

        totalLabel = new JLabel("Total: $" + total, SwingConstants.CENTER);
        totalLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        JButton buyButton = new JButton("Buy");
        buyButton.setFont(new Font("Arial", Font.BOLD, 16));
        buyButton.addActionListener((ActionEvent e) -> {
            System.out.println("Buy button clicked.");
            processPurchase();
        });
        purchasePanel.add(totalLabel, BorderLayout.NORTH);
        purchasePanel.add(buyButton, BorderLayout.SOUTH);

        JPanel cartItems = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        if (videos.isEmpty()) {
            JLabel lbl = new JLabel("Cart is Empty");
            lbl.setFont(new Font("Arial", Font.BOLD, 16));
            lbl.setForeground(Color.BLACK);
            cartItems.add(lbl);
        } else {
            total = 0;
            for (int i = 0; i < videos.size(); i++) {
                gbc.insets = new Insets(10, 10, 0, 10);  //top padding
                gbc.gridx = i % 3;
                gbc.gridy = i / 3;
                gbc.weightx = 0.1;
                gbc.weighty = 0.1;
                gbc.fill = GridBagConstraints.HORIZONTAL;
                cartItems.add(createCartItem(i, videos.get(i)), gbc);
                total += videos.get(i).getPrice();
            }
        }
        totalLabel.setText("Total: $" + total);
        this.add(purchasePanel, BorderLayout.SOUTH);

        JScrollPane cart = new JScrollPane(cartItems);
        cart.getVerticalScrollBar().setUnitIncrement(16);
        this.add(cart, BorderLayout.CENTER);
    }

    private JPanel createCartItem(int i, Video video) {
        JPanel itemPanel = new JPanel();
        itemPanel.setLayout(new GridLayout(5, 1));
        itemPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        Border blackline = BorderFactory.createLineBorder(Color.BLACK);
        TitledBorder videoCard;
        videoCard = BorderFactory.createTitledBorder(blackline, "Item " + (i + 1));
        videoCard.setTitleJustification(TitledBorder.CENTER);
        itemPanel.setBorder(videoCard);

        JLabel num = new JLabel("" + i);
        JLabel img = new JLabel();
        try {
            img.setIcon(video.getImage());
        } catch (Exception e) {
            img.setText("Cannot display image");
        }
        img.setPreferredSize(new Dimension(100, 50));
        img.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        itemPanel.add(img);

        JLabel title = new JLabel("" + video.getTitle(), SwingConstants.CENTER);
        itemPanel.add(title);

        JLabel price = new JLabel("$" + video.getPrice(), SwingConstants.CENTER);
        itemPanel.add(price);

        JButton removeButton = new JButton();
        try {
            ImageIcon noCart = new ImageIcon("src\\resources\\images\\noCart.png");

            Image image = noCart.getImage();
            Image newimg = image.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
            noCart = new ImageIcon(newimg);

            removeButton.setIcon(noCart);
        } catch (Exception e) {
            removeButton.setText("Remove from Cart");
        }

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                CStream.ca.remove(video);
                video.cartFlag = false;
                total -= video.getPrice();
                totalLabel.setText("Total: $" + total);
                updateCartDisplay();
                s.main.refresh();
                JOptionPane.showMessageDialog(null, "Item" + (i + 1) + " removed from cart.");
            }

        });

        itemPanel.add(removeButton);

        return itemPanel;
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

    private void processPurchase() {
        if (videos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Cart is empty!");
            return;
        }

        try {
            if (conn == null || conn.isClosed()) {
                connectToDatabase(); // Ensure the connection is open
            }

            try (PreparedStatement pstmt = conn.prepareStatement(
                    "INSERT INTO Purchases (customerid, videoid) VALUES (?, ?)"
            )) {
                for (Video v : videos) {
                    pstmt.setInt(1, s.getCustomerId());
                    pstmt.setInt(2, v.getId());
                    pstmt.addBatch();
                }

                pstmt.executeBatch();
                videos.clear(); // Clear the videos after successful purchase
                total = 0;
                totalLabel.setText("Total: $" + total);
                JOptionPane.showMessageDialog(null, "Purchase confirmed!");
                updateCartDisplay(); // Update the display after purchase
            }

        } catch (SQLException e) {
            if (e instanceof SQLIntegrityConstraintViolationException) {
                JOptionPane.showMessageDialog(null, "Error during purchase: Some items were already purchased");
            } else {
                JOptionPane.showMessageDialog(null, "Error during purchase: " + e.getMessage());
            }
        }

    }

    public void updateCartDisplay() {
        this.removeAll(); // Clear existing components
        initialize();     // Rebuild the UI
        this.revalidate(); // Refresh the panel
        this.repaint();
    }
}
