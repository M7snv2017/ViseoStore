package main.SharedSources;

/**
 * Util class contains several methods that you may need to use. to use in your
 * class/frame/... , you need to import the package (main.SharedSources) and
 * just write as Util.<em>method_name_you_want_to use<em>.
 *
 * @author Mustafa
 */
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
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

            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(orBg.darker());
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(orBg);
            }
        });
    }

    //This method creates and returns a JToggleButton used to show&hide JPasswordField/s characters
    public static JToggleButton createShowHide(JPasswordField... passwordFields) {
        JToggleButton button = new JToggleButton();
        button.setFocusPainted(false);
        try {
            ImageIcon show = new ImageIcon("src\\resources\\images\\_see.jpeg");

            Image image = show.getImage();
            Image newimg = image.getScaledInstance(15, 15, Image.SCALE_SMOOTH);
            show = new ImageIcon(newimg);

            button.setIcon(show);
        } catch (Exception e) {
            button.setText("Show");
        }

        button.addItemListener((ItemEvent i) -> {
            int state = i.getStateChange();
            if (state == ItemEvent.SELECTED) {
                try {
                    ImageIcon hide = new ImageIcon("src\\resources\\images\\_!see.png");
                    
                    Image image = hide.getImage();
                    Image newimg = image.getScaledInstance(15, 15, Image.SCALE_SMOOTH);
                    hide = new ImageIcon(newimg);
                    
                    button.setIcon(hide);
                } catch (Exception e) {
                    button.setText("Hide");
                }
                for (JPasswordField passwordField : passwordFields) {
                    passwordField.setEchoChar((char) 0);
                }
            } else {
                try {
                    ImageIcon show = new ImageIcon("src\\resources\\images\\_see.jpeg");
                    
                    Image image = show.getImage();
                    Image newimg = image.getScaledInstance(15, 15, Image.SCALE_SMOOTH);
                    show = new ImageIcon(newimg);
                    
                    button.setIcon(show);
                } catch (Exception e) {
                    button.setText("Show");
                }
                for (JPasswordField passwordField : passwordFields) {
                    passwordField.setEchoChar('\u2022');
                }
            }
        });
        return button;
    }

    //This class attached focusListeners to JTextField to provide placeHolder feature
    public static class placeHolderListener extends FocusAdapter {
        @Override
        public void focusGained(FocusEvent evt) {
            JTextField source = (JTextField) evt.getSource();
            source.setText("");
        }
    }
}
