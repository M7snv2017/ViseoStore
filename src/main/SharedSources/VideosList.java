
package main.SharedSources;
/**
 * This panel is essentially used to display videos in any given list in a beautiful layout.
 * IT IS NOT COMPLETE, WAITING TO OTHER PARTS OF THE PROJECT TO BE READY.
 * @author Mustafa
 */
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import video.store.Video;

public class VideosList extends JPanel {
    private ArrayList<Video> videos = new ArrayList();
    
    public VideosList() {
        initialize();
    }
    
    private void initialize() {
        setPreferredSize(new Dimension(570, 1000));  //(Mustafa) there may be some other way instead of puttin 1000 
        
        if(videos.isEmpty()) {
            JLabel lbl = new JLabel("List is Empty");
            lbl.setFont(new Font("Arial", Font.BOLD, 16));
            lbl.setForeground(Color.red);
            add(lbl);
        }
        else {
            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
            
            int i = 0;
            for(var v: videos) {
                add(addVideo(v, ++i));
            }
        }
    }
    
    private JPanel addVideo(Video video, int i) {
        JPanel panel = new JPanel();
        panel.setSize(570,50);
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 150));
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        
        JLabel img = new JLabel(video.getImage());
        JLabel title = new JLabel("Title: "+video.getTitle());
        JLabel genre = new JLabel("Genre: "+video.getGenre());
        JLabel year = new JLabel("Year: "+video.getYear());
        JLabel price = new JLabel("Price: "+video.getPrice());
        
        ImageIcon cart = new ImageIcon();
        ImageIcon noCart = new ImageIcon();
        JButton toCart = new JButton(cart);
        toCart.setRolloverIcon(noCart);

        
        ImageIcon favorite = new ImageIcon();
        ImageIcon noFavorite = new ImageIcon();
        JButton toFavorite = new JButton(favorite);
        toFavorite.setRolloverIcon(noFavorite);
        
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridheight = 2;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.7;
        gbc.weighty = 0.2;
        panel.add(img, gbc);
        Util.addComponent(panel, title, 0, 1, 0.5, 0.1);
        Util.addComponent(panel, genre, 0, 2, 0.5, 0.1);
        Util.addComponent(panel, year, 1, 1, 0.5, 0.1);
        Util.addComponent(panel, price, 1, 2, 0.5, 0.1); 
        
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridheight = 1;
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.weightx = 0.07;
        gbc.weighty = 0.1;
        gbc.insets = new Insets(15,50,15,20);
        panel.add(toCart, gbc);
        
        gbc.gridx = 3;
        gbc.gridy = 1;
        panel.add(toFavorite, gbc);
        
        
        Border blackline = BorderFactory.createLineBorder(Color.BLACK);
        TitledBorder title1;
        title1 = BorderFactory.createTitledBorder(blackline, ""+i);
        title1.setTitleJustification(TitledBorder.CENTER);
        panel.setBorder(title1);
        
        return panel;
    }
}
