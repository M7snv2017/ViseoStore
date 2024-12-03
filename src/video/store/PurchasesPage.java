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

public class PurchasesPage extends JPanel {

    private ArrayList<Video> videos = new ArrayList();
    CStream s;
    public PurchasesPage(ArrayList<Video> video,CStream s) {
        this.s=s;
        videos = video;
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
                gbc.insets = new Insets(10,10,0,10);  //top padding
                gbc.gridx = i%3;
                gbc.gridy = i/3;
                gbc.weightx = 0.1;
                gbc.weighty = 0.1;
                gbc.fill = GridBagConstraints.BOTH;  
                purchases.add(createItem(i, videos.get(i)), gbc);
            } 
        }

        JScrollPane purchJScrollPane = new JScrollPane(purchases);
        this.add(purchJScrollPane, BorderLayout.CENTER);
    }

    private JPanel createItem (int i, Video video) {
    JPanel itemPanel = new JPanel();
        itemPanel.setLayout(new GridLayout(3,0));
        itemPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        Border blackline = BorderFactory.createLineBorder(Color.BLACK);
        TitledBorder videoCard;
        videoCard = BorderFactory.createTitledBorder(blackline, "Item"+(i+1));
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

        JButton getSourceBtn = new JButton("Get Source");
        getSourceBtn.addActionListener(e -> JOptionPane.showMessageDialog(null, "Please Copy the URL "+video.getVideoSource()));
        itemPanel.add(getSourceBtn);

        return itemPanel;
    }   
    
    //for test
//    public static void main(String[] args) {
//        JFrame frm = new JFrame();
//        ArrayList<Video> videos = new ArrayList();
//        Video video = new Video();
//        videos.add(video);
//        videos.add(video);
//        videos.add(video);
//        videos.add(video);
//        videos.add(video);
//        PurchasesPage p = new PurchasesPage(videos);
//
//        frm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        frm.setSize(800, 500);
//        frm.setLocationRelativeTo(null);
//        frm.add(p);
//        frm.setVisible(true);
//    }
}
