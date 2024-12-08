package video.store;

/**
 * Here is where all available videos are shown to customer, and search feature is provided.
 * 
 * @author Mustafa
 */

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import main.SharedSources.VideosList;

public class Main extends JPanel {
    VideosList list;
    CStream s;
    public Main(ArrayList<Video> allVideos,CStream s) {
        this.s=s;
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        gbc.fill = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.1;
        gbc.weighty = 0.1;
        JLabel lbl = new JLabel ("Main Page");
        lbl.setFont(new Font("Arial", Font.BOLD, 16));
        this.add(lbl,gbc);

        /* 
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.insets = new Insets(20,0,0,0);
        gbc.gridheight = 1;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0.4;
        gbc.weighty = 2.0;
        this.add(search, gbc);

        */
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 10.0;
        list = new VideosList(allVideos, s);
        JScrollPane allVideoScrollPane = new JScrollPane(list);
        allVideoScrollPane.getVerticalScrollBar().setUnitIncrement(16);
        this.add(allVideoScrollPane, gbc);   
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
        JLabel lbl = new JLabel ("Main Page");
        lbl.setFont(new Font("Arial", Font.BOLD, 16));
        this.add(lbl,gbc);

        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 10.0;
        list = new VideosList(CStream.av, s);
        JScrollPane allVideoScrollPane = new JScrollPane(list);
        allVideoScrollPane.getVerticalScrollBar().setUnitIncrement(16);
        this.add(allVideoScrollPane, gbc);   
    }

}
