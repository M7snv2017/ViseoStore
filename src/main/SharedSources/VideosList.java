package main.SharedSources;

/**
 * This panel is essentially used to display videos in any given list in a
 * beautiful layout. IT IS NOT COMPLETE, WAITING TO OTHER PARTS OF THE PROJECT
 * TO BE READY.
 *
 * @author Mustafa
 */
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import video.store.*;

public class VideosList extends JPanel {

    CStream s;
    Favorites fav;
    public VideosList(ArrayList<Video> vl,CStream s,Favorites f)
    {
        this.s=s;
        fav=f;
        initialize(vl);
    }
    
    public VideosList(ArrayList<Video> vl,CStream s) {  //vl: videos list
        this.s=s;
        initialize(vl);
    }

    private void initialize(ArrayList<Video> vl) {
        if (vl.isEmpty()) {
            JLabel lbl = new JLabel("List is Empty");
            lbl.setFont(new Font("Arial", Font.BOLD, 16));
            lbl.setForeground(Color.red);
            add(lbl);
        } else {
            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

            int i = 0;
            for (var v : vl) {
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

        JLabel img = new JLabel();
        try {
            ImageIcon imageIcon = video.getImage();
            Image imgScaled = imageIcon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
            img.setIcon(new ImageIcon(imgScaled));
            img.setPreferredSize(new Dimension(150, 150));
            img.setMaximumSize(new Dimension(150, 150));
        } catch (Exception e) {
            img.setText("Cannot display image");
        }
        
        JLabel title = new JLabel("Title: " + video.getTitle());
        JLabel genre = new JLabel("Genre: " + video.getGenre());
        JLabel year = new JLabel("Year: " + video.getYear());
        JLabel price = new JLabel("Price: $" + video.getPrice());

        JToggleButton toCart = new JToggleButton();
        toCart.setFocusPainted(false);
        try {
            ImageIcon cart = new ImageIcon("src\\resources\\images\\noCart.png");

            Image image = cart.getImage();
            Image newimg = image.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
            cart = new ImageIcon(newimg);

            toCart.setIcon(cart);
        } catch (Exception e) {
            toCart.setText("Add to Cart");
        }

        toCart.addItemListener((ItemEvent i1) -> {
            int state = i1.getStateChange();
            if (state != ItemEvent.SELECTED) {
                // Item removed from cart
                try {
                    ImageIcon noCart = new ImageIcon("src\\resources\\images\\noCart.png");
                    Image image = noCart.getImage();
                    Image newimg = image.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
                    noCart = new ImageIcon(newimg);
                    toCart.setIcon(noCart);
                    CStream.ca.remove(video);
                    
                    // Trigger cart refresh
                    s.cart.updateCartDisplay();

                } catch (Exception e) {
                    toCart.setText("Remove from Cart");
                }
            } else {
                // Item added to cart
                try {
                    ImageIcon cart = new ImageIcon("src\\resources\\images\\cart.png");
                    Image image = cart.getImage();
                    Image newimg = image.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
                    cart = new ImageIcon(newimg);
                    toCart.setIcon(cart);
                    CStream.ca.add(video);

                    // Trigger cart refresh
                    s.cart.updateCartDisplay();

                } catch (Exception e) {
                    toCart.setText("Add to Cart");
                }
            }
        });


        JToggleButton toFavorite = new JToggleButton();
        toFavorite.setFocusPainted(false);
        try {
            ImageIcon favorite;
            if(video.FavoriteFlag)
                 favorite = new ImageIcon("src\\resources\\images\\Favorite.png");
            else
                favorite = new ImageIcon("src\\resources\\images\\noFavorite.png");
            Image image = favorite.getImage();
            Image newimg = image.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
            favorite = new ImageIcon(newimg);

            toFavorite.setIcon(favorite);
        } catch (Exception e) {
            toFavorite.setText("Add to Favorite");
        }

//        toFavorite.addItemListener((ItemEvent i2) -> {
//            
//            int state = i2.getStateChange();
//            if (state != ItemEvent.SELECTED) {
//                try {
//                    ImageIcon noFavorite = new ImageIcon("src\\resources\\images\\noFavorite.png");
//                    
//                    Image image = noFavorite.getImage();
//                    Image newimg = image.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
//                    noFavorite = new ImageIcon(newimg);
//                    toFavorite.setIcon(noFavorite);
//                    
//                    CStream.fv.remove(video);
//                    
//                    for (var s : CStream.fv)
//                    {
//                        System.out.println(s.id);
//                    }
//                   
//                    video.FavoriteFlag=false;
//                    System.out.println("favorite "+video.id+" : "+video.FavoriteFlag);
//                    if(fav!=null)
//                        fav.change(CStream.fv);
////                    s.container.repaint();
//                    s.favorites= new Favorites(CStream.fv, s);
//                } catch (Exception e) {
//                    toFavorite.setText("Remove from Favorite");
//                }
//            } else {
//                try {
//                    ImageIcon favorite = new ImageIcon("src\\resources\\images\\Favorite.png");
//                    
//                    Image image = favorite.getImage();
//                    Image newimg = image.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
//                    favorite = new ImageIcon(newimg);
//                    toFavorite.setIcon(favorite);
//                    
//                    CStream.fv.add(video);
//                    
//                    initialize(CStream.fv);
//                    for (var s : CStream.fv)
//                    {
//                        System.out.println(s.id);
//                    }
////                    s.container.repaint();
//                    video.FavoriteFlag=true;
//                    System.out.println("favorite "+video.id+" : "+video.FavoriteFlag);
//                    if(fav!=null)
//                        fav.change(CStream.fv);
//                } catch (Exception e) {
//                    toFavorite.setText("Add to Favorite");
//                }
//            }
//        });
        toFavorite.addItemListener((ItemEvent i2) -> {
            int state = i2.getStateChange();
            if (video.FavoriteFlag != false) {
                try {
                    ImageIcon noFavorite = new ImageIcon("src\\resources\\images\\noFavorite.png");
                    Image image = noFavorite.getImage();
                    Image newimg = image.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
                    noFavorite = new ImageIcon(newimg);
                    toFavorite.setIcon(noFavorite);

                    CStream.fv.remove(video);
                    video.FavoriteFlag = false;
                    System.out.println("Removed from favorites: " + video.id);

                    if (fav != null) {
                        fav.refresh();
                    }
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

                    CStream.fv.add(video);
                    video.FavoriteFlag = true;
                    System.out.println("Added to favorites: " + video.id);

                    if (fav != null) {
                        fav.refresh();
                    }
                } catch (Exception e) {
                    toFavorite.setText("Add to Favorite");
                }
            }
        });



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
        TitledBorder videoCard;
        videoCard = BorderFactory.createTitledBorder(blackline, "" + i);
        videoCard.setTitleJustification(TitledBorder.CENTER);
        panel.setBorder(videoCard);

        panel.addMouseListener(new MouseAdapter() { //allows the user to click anywhere inside the panel to view selected video's details
            @Override
            public void mouseClicked(MouseEvent e) {
                VideoInfoFrame frm = new VideoInfoFrame(video);
            }
        });
        panel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return panel;
    }
}