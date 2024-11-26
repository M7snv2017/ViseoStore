package video.store;

/**
 * 
 * @author Mustafa
 */

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class CartPage extends JPanel {

    private ArrayList<Video> videos = new ArrayList();
    private final double total = 0;

    public CartPage(ArrayList<Video> video) {
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

        JLabel totalLabel = new JLabel("Total: $" + total, SwingConstants.CENTER);
        totalLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        purchasePanel.add(totalLabel, BorderLayout.NORTH);

        JButton buyButton = new JButton("Buy");
        buyButton.setFont(new Font("Arial", Font.BOLD, 16));
        buyButton.addActionListener(e -> JOptionPane.showMessageDialog(null, "Purchase confirmed!"));
        purchasePanel.add(buyButton, BorderLayout.SOUTH);
        this.add(purchasePanel, BorderLayout.SOUTH);
        
        JPanel cartItems = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        if (videos.isEmpty()) {
            JLabel lbl = new JLabel("Cart is Empty");
            lbl.setFont(new Font("Arial", Font.BOLD, 16));
            lbl.setForeground(Color.BLACK);
            cartItems.add(lbl);
        } else {
            for (int i = 0; i < videos.size(); i++) {
                gbc.insets = new Insets(10,10,0,10);  //top padding
                gbc.gridx = i%3;
                gbc.gridy = i/3;
                gbc.weightx = 0.1;
                gbc.weighty = 0.1;
                gbc.fill = GridBagConstraints.BOTH;  
                cartItems.add(createCartItem(i, videos.get(i)), gbc);
            } 
        }

        JScrollPane cart = new JScrollPane(cartItems);
        this.add(cart, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        JFrame frm = new JFrame();
        ArrayList<Video> videos = new ArrayList();
        Video video = new Video();
        
        CartPage p = new CartPage(videos);

        frm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frm.setSize(800, 500);
        frm.setLocationRelativeTo(null);
        frm.add(p);
        frm.setVisible(true);
    }
    
    private JPanel createCartItem(int i, Video video) {
        JPanel itemPanel = new JPanel();
        itemPanel.setLayout(new GridLayout(4,0));
        itemPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        
        Border blackline = BorderFactory.createLineBorder(Color.BLACK);
        TitledBorder videoCard;
        videoCard = BorderFactory.createTitledBorder(blackline, "Item "+(i+1));
        videoCard.setTitleJustification(TitledBorder.CENTER);
        itemPanel.setBorder(videoCard);

        JLabel num = new JLabel(""+i);
        JLabel img = new JLabel();
        try {
            img.setIcon(video.getImage());
        } catch (Exception e) {
            img.setText("Cannot display image");
        }
        img.setPreferredSize(new Dimension(100, 50));
        img.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        itemPanel.add(img);

        JLabel title = new JLabel(""+video.getTitle(), SwingConstants.CENTER);
        itemPanel.add(title);

        JLabel price = new JLabel("$"+video.getPrice(), SwingConstants.CENTER);
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

        removeButton.addActionListener(e -> JOptionPane.showMessageDialog(null, "Item"+(i+1) + " removed from cart."));
        itemPanel.add(removeButton);

        return itemPanel;
    }
}
