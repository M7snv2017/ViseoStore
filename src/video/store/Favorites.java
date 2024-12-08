package video.store;

/**
 * Here is where favorite videos of a customer are shown to him, and search
 * feature is provided.
 *
 * @author Mustafa
 */
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import main.SharedSources.VideosList;

public class Favorites extends JPanel {

    VideosList list;
    CStream s;
    Container c;

    public Favorites(ArrayList<Video> favorites, CStream s) {
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        this.s = s;
        gbc.fill = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.1;
        gbc.weighty = 0.1;
        JLabel lbl = new JLabel("Favorites Page");
        lbl.setFont(new Font("Arial", Font.BOLD, 16));
        this.add(lbl, gbc);

        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 10.0;
        list = new VideosList(favorites, s, Favorites.this);
        JScrollPane favoritesScrollPane = new JScrollPane(list);
        favoritesScrollPane.getVerticalScrollBar().setUnitIncrement(16);
        this.add(favoritesScrollPane, gbc);
    }

    public void change(ArrayList<Video> favorites) {
        list = new VideosList(favorites, s, Favorites.this);
    }

    public void refresh() {
        removeAll();
        revalidate();
        repaint();

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.fill = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.1;
        gbc.weighty = 0.1;
        JLabel lbl = new JLabel("Favorites Page");
        lbl.setFont(new Font("Arial", Font.BOLD, 16));
        add(lbl, gbc);

        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 10.0;
        list = new VideosList(CStream.fv, s, this);
        JScrollPane favoritesScrollPane = new JScrollPane(list);
        favoritesScrollPane.getVerticalScrollBar().setUnitIncrement(16);
        add(favoritesScrollPane, gbc);
    }
}
