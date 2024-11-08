
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

public class cMain extends JFrame implements ActionListener {
    private CardLayout cardLayout;
    private JPanel main;
    private GridBagLayout layout;
    private GridBagConstraints gbc;
    MenuPanel menu = new MenuPanel(this);
    SearchPanel search = new SearchPanel();
    VideosList list = new VideosList();
    
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
        
        //main.add(new VideosList(), "Main");
        //main.add(new FavoriteList(), "Favorite");
        
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 10.0;
        add(main);
        JScrollPane scrollPane = new JScrollPane(list);
        add(scrollPane, gbc); 
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "Main" -> cardLayout.show(main, "Main");
            case "Settings" -> cardLayout.show(main, "FavoriteList");
        }
    }
}
