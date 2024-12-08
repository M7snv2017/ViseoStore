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
import java.awt.Insets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class PurchasesPage extends JPanel {

    private ArrayList<Video> videos = new ArrayList<>();
    private Connection conn;
    CStream s;

    public PurchasesPage(CStream s) {
        this.s = s;
        connectToDatabase();
        fetchPurchasesFromDatabase();
        initialize();
    }

    private void initialize() {
        this.setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Purchases", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        this.add(titleLabel, BorderLayout.NORTH);

        JPanel purchases = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        if (videos.isEmpty()) {
            JLabel lbl = new JLabel("No Purchases");
            lbl.setFont(new Font("Arial", Font.BOLD, 16));
            lbl.setForeground(Color.BLACK);
            purchases.add(lbl);
        } else {
            for (int i = 0; i < videos.size(); i++) {
                gbc.insets = new Insets(10, 10, 0, 10); // top padding
                gbc.gridx = i % 3;
                gbc.gridy = i / 3;
                gbc.weightx = 0.1;
                gbc.weighty = 0.1;
                gbc.fill = GridBagConstraints.BOTH;
                purchases.add(createItem(i, videos.get(i)), gbc);
            }
        }

        JScrollPane purchJScrollPane = new JScrollPane(purchases);
        this.add(purchJScrollPane, BorderLayout.CENTER);
    }

    private JPanel createItem(int i, Video video) {
        JPanel itemPanel = new JPanel();
        itemPanel.setLayout(new GridLayout(3, 0));
        itemPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        Border blackline = BorderFactory.createLineBorder(Color.BLACK);
        TitledBorder videoCard;
        videoCard = BorderFactory.createTitledBorder(blackline, "Item " + (i + 1));
        videoCard.setTitleJustification(TitledBorder.CENTER);
        itemPanel.setBorder(videoCard);

        JLabel img = new JLabel();
        try {
            img.setIcon(video.getImage());
        } catch (Exception e) {
            img.setText("Cannot display image");
        }
        img.setPreferredSize(new Dimension(100, 50));
        img.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        itemPanel.add(img);

        JLabel title = new JLabel(video.getTitle(), SwingConstants.CENTER);
        itemPanel.add(title);

        JButton getSourceBtn = new JButton("Get Source");
        getSourceBtn.addActionListener(e -> JOptionPane.showMessageDialog(null, "Please Copy the URL " + video.getVideoSource()));
        itemPanel.add(getSourceBtn);

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

    private void fetchPurchasesFromDatabase() {
        String query = "SELECT * FROM Video WHERE id IN (SELECT videoid FROM Purchases WHERE customerid = " + s.getCustomerId() + ")";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Video v = new Video();
                v.setTitle(rs.getString("title"));
                v.setVideoSource(rs.getString("videoSource"));
                videos.add(v);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error fetching purchases: " + e.getMessage());
        }
    }
}
