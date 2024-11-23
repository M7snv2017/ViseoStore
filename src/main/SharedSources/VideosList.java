
package main.SharedSources;

/**
 * This panel is essentially used to display videos in any given list in a beautiful layout.
 * IT IS NOT COMPLETE, WAITING TO OTHER PARTS OF THE PROJECT TO BE READY.
 * @author Mustafa
 */
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import video.store.Video;

public class VideosList extends JPanel {

    private ArrayList<Video> videos = new ArrayList<Video>();
    public VideosList(ArrayList<Video> v) {
        videos = v;
        initialize();
    }

    private void initialize() {
        setPreferredSize(new Dimension(570, 1000)); // (Mustafa) there may be some other way instead of putting 1000
        if (videos.isEmpty()) {
            JLabel lbl = new JLabel("List is Empty");
            lbl.setFont(new Font("Arial", Font.BOLD, 16));
            lbl.setForeground(Color.red);
            add(lbl);
        } else {
            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

            int i = 0;
            for (var v : videos) {
                add(addVideo(v, ++i));
            }
        }
    }

    private JPanel addVideo(Video video, int i) {
        JPanel panel = new JPanel();
        panel.setSize(570, 50);
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 150));
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        JLabel img = new JLabel(video.getImage());
        JLabel title = new JLabel("Title: " + video.getTitle());
        JLabel genre = new JLabel("Genre: " + video.getGenre());
        JLabel year = new JLabel("Year: " + video.getYear());
        JLabel price = new JLabel("Price: " + video.getPrice());

        JToggleButton toCart = new JToggleButton();
        toCart.setFocusPainted(false);
        toCart.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent i) {
                int state = i.getStateChange();
                if (state == ItemEvent.SELECTED) {
                    try {
                        ImageIcon noCart = new ImageIcon("src\\resources\\images\\noCart.png");

                        Image image = noCart.getImage();
                        Image newimg = image.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
                        noCart = new ImageIcon(newimg);

                        toCart.setIcon(noCart);
                    } catch (Exception e) {
                        toCart.setText("Remove from Cart");
                    }
                } else {
                    try {
                        ImageIcon cart = new ImageIcon("src\\resources\\images\\cart.png");

                        Image image = cart.getImage();
                        Image newimg = image.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
                        cart = new ImageIcon(newimg);

                        toCart.setIcon(cart);
                    } catch (Exception e) {
                        toCart.setText("Add to Cart");
                    }

                }
            }
        });

        try {
            ImageIcon cart = new ImageIcon("src\\resources\\images\\cart.png");

            Image image = cart.getImage();
            Image newimg = image.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
            cart = new ImageIcon(newimg);

            toCart.setIcon(cart);
        } catch (Exception e) {
            toCart.setText("Add to Cart");
        }

        JToggleButton toFavorite = new JToggleButton();
        toFavorite.setFocusPainted(false);
        toFavorite.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent i) {
                int state = i.getStateChange();
                if (state == ItemEvent.SELECTED) {
                    try {
                        ImageIcon noFavorite = new ImageIcon("src\\resources\\images\\noFavorite.png");

                        Image image = noFavorite.getImage();
                        Image newimg = image.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
                        noFavorite = new ImageIcon(newimg);

                        toFavorite.setIcon(noFavorite);
                    } catch (Exception e) {
                        toFavorite.setText("Remove from Favorite");
                    }
                } else {
                    try {
                        ImageIcon favorite = new ImageIcon("src\\resources\\images\\Favorite.png");

                        Image image = favorite.getImage();
                        Image newimg = image.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
                        favorite = new ImageIcon(newimg);

                        toFavorite.setIcon(favorite);
                    } catch (Exception e) {
                        toFavorite.setText("Add to Favorite");
                    }
                }
            }
        });

        try {

            ImageIcon favorite = new ImageIcon("src\\resources\\images\\favorite.png");

            Image image = favorite.getImage();
            Image newimg = image.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
            favorite = new ImageIcon(newimg);

            toFavorite.setIcon(favorite);
        } catch (Exception e) {
            toFavorite.setText("Add to Cart");
        }

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
        gbc.insets = new Insets(15, 50, 15, 20);
        panel.add(toCart, gbc);

        gbc.gridx = 3;
        gbc.gridy = 1;
        panel.add(toFavorite, gbc);

        Border blackline = BorderFactory.createLineBorder(Color.BLACK);
        TitledBorder title1;
        title1 = BorderFactory.createTitledBorder(blackline, "" + i);
        title1.setTitleJustification(TitledBorder.CENTER);
        panel.setBorder(title1);

        return panel;
    }
}
