
package video.store;

/**
 * This is the main page of our project. HERE IS WHERE ALL THE BEAUTY STARTS
 * IT IS NOT COMPLETE, WAITING TO OTHER PARTS OF THE PROJECT TO BE READY.
 * @author Mustafa
 */

import main.SharedSources.SearchPanel;
import main.SharedSources.MenuPanel;
import main.SharedSources.VideosList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class cMain extends JFrame implements ActionListener {
    private CardLayout cardLayout;
    private JPanel main;
    private GridBagLayout layout;
    private GridBagConstraints gbc;
    private ArrayList<Video> av;
    private ArrayList<Video> fv;
    MenuPanel menu = new MenuPanel(this);
    SearchPanel search = new SearchPanel();
    VideosList allVideos;
    VideosList favorite;
    cAcount acount = new cAcount();
    
    public cMain() {
        super("Test");
        setPreferredSize(new Dimension(800, 500));
      
        layout = new GridBagLayout();
        setLayout(layout);
        gbc = new GridBagConstraints();
        
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridheight = 3;
        gbc.weightx = 0.2;
        gbc.weighty =1.0;
        add(menu, gbc);
        
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.insets = new Insets(20,0,0,0);
        gbc.gridheight = 1;
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 0.4;
        gbc.weighty = 2.0;
        add(search, gbc);
        
        gbc.insets = new Insets(0,0,0,0);
        gbc.fill = GridBagConstraints.CENTER;
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 0.1;
        gbc.weighty = 0.1;
        JLabel lbl = new JLabel ("Videos List");
        lbl.setFont(new Font("Arial", Font.BOLD, 16));
        add(lbl,gbc);
        
        cardLayout = new CardLayout();
        main = new JPanel(cardLayout);
        Video e = new Video();
        av = new ArrayList<Video>();
        av.add(e);

        fv = new ArrayList<Video>();
        allVideos = new VideosList(av);
        favorite = new VideosList(fv);

        JScrollPane allVideoScrollPane = new JScrollPane(allVideos);
        JScrollPane favoriteScrollPane = new JScrollPane(favorite);

        main.add(allVideoScrollPane, "Main");
        main.add(favoriteScrollPane, "Favorite");
        //main.add(new cAcount(), "Account");
        
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 10.0;
        //add(main);
        add(main, gbc); 
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = menu.getActionCommand();
        switch (command) {
            case "Main" -> cardLayout.show(main, "Main");
            case "Favorite" -> cardLayout.show(main, "FavoriteList");
            case "Account" -> cardLayout.show(main, "Account");
        }
        repaint();
    }

    public static void main (String []args) {
        cMain frm = new cMain();
        frm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frm.setLocationRelativeTo(null);
        frm.setSize(800,500);
        frm.setVisible(true);
    }
}
