package video.store;

/**
 * Here is where all available videos are shown to customer, and search feature is provided.
 * 
 * @author Mustafa
 */

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import main.SharedSources.*;

public class Main extends JPanel {
    SearchPanel search = new SearchPanel();
    VideosList list;

    public Main(ArrayList<Video> allVideos) {
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

        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.insets = new Insets(20,0,0,0);
        gbc.gridheight = 1;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0.4;
        gbc.weighty = 2.0;
        this.add(search, gbc);

        
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 10.0;
        list = new VideosList(allVideos);
        JScrollPane allVideoScrollPane = new JScrollPane(list);
        this.add(allVideoScrollPane, gbc);   
    }

    //For test
    public static void main(String[] args) {
        JFrame frm = new JFrame();

        ArrayList<Video> arr = new ArrayList<>();
        Main p = new Main(arr);

        frm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frm.setSize(800, 500);
        frm.setLocationRelativeTo(null);
        frm.add(p);
        frm.setVisible(true);   
    }
}
