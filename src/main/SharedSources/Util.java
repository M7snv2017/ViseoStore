
package main.SharedSources;

/**
 * Util class contains several methods that you may need to use.
 * to use in your class/frame/... , you need to import the package (main.SharedSources) and just write as Util.<em>method_name_you_want_to use<em>.
 * @author Mustafa
 */

import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.*;

public class Util {
    public static FocusListener placeHolderListener;
    public static void addComponent(Container container, Component component, int row, int col, double width,
            double height) {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = col;
        constraints.gridy = row;
        constraints.weightx = width;
        constraints.weighty = height;
        constraints.fill = GridBagConstraints.BOTH;
        container.add(component, constraints);
    }

    public static JButton createButton(String name, Color background, Color foreground, Font font) {
        JButton button = new JButton(name);
        button.setBackground(background);
        button.setForeground(foreground);
        button.setFont(font);
        button.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        button.setFocusPainted(false);
        return button;
    }

    //This method attached mouseListeners to JButton to provide hover feature
    public static void hoverListener(JButton button) {  //toBg: new background color when hover
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            Color orBg = button.getBackground(); //orBg: original color
            
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(orBg.darker());
            }
        
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(orBg);
            }
        });
    }
    
     //This class attached focusListeners to JTextField to provide placeHolder feature
    public static class placeHolderListener extends FocusAdapter {
        String originalText;
        
        @Override
        public void focusGained(FocusEvent evt) {
            JTextField source = (JTextField) evt.getSource();
            originalText = source.getText();
            source.setText("");
        }

        @Override
        public void focusLost(FocusEvent evt) {
            JTextField source = (JTextField) evt.getSource();
            if (source.getText().isEmpty()) {
                source.setText(originalText); 
            }
        }
    } 
}




