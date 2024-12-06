
package main.SharedSources;

/**
 * MenuPanel is the one which representing the sidebar where user can move around the other panels(main, favorite, ...)
 * You can simply attach this panel to any JFrame by instantiating it in you frame
 * @author Mustafa
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MenuPanel extends JPanel {
    public static JButton selectedButton = null;
    
    public MenuPanel(ActionListener listener) {
        initialize(listener);
    }
    
    private void initialize(ActionListener listener) {
        setPreferredSize(new Dimension(230, 500));
        //setSize(230,500);
        setLayout(new GridBagLayout());
        setBackground(new Color(204,204,204));
        
        Color bgColor = new Color(135,135,135);
        Color fgColor = Color.BLACK;
        Font font = new Font("Arial", Font.BOLD, 16);
        
        String[] bNames = {"Main", "Favorite", "Cart", "Purchases", "Account"};
        for (int i = 0; i < 5; i++) {
            JButton button = Util.createButton(bNames[i], bgColor, fgColor, font);
            button.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
            
            if (i == 0) {
                // Customize the "Main" button as the default selected
                button.setBackground(new Color(60, 60, 60));
                button.setForeground(Color.WHITE);
                selectedButton = button; // Set the "Main" button as the selected button
            }

            button.setActionCommand(bNames[i]);
            button.addActionListener(new ActionListenerImpl());
            button.addActionListener(listener);

            Util.addComponent(this, button, i != 4 ? i : ++i, 0, 1.0, 1.0);
        }
        
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridy = 4;
        constraints.gridx = 1;
        constraints.weighty = 10.0;
        add(Box.createVerticalGlue(), constraints);  
    }
    
    private static class ActionListenerImpl implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton clickedButton = (JButton) e.getSource();
            if((selectedButton != clickedButton) && (selectedButton != null)){
                selectedButton.setBackground(new Color(135,135,135));
                selectedButton.setForeground(Color.BLACK);
            }
            clickedButton.setBackground(new Color(60,60,60));
            clickedButton.setForeground(Color.WHITE);
            selectedButton = clickedButton;
        }
    }
}
