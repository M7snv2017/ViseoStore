
package main.SharedSources;
/**
 * Util class contains several methods that you may need to use.
 * to use in your class/frame/... , you need to import the package (main.SharedSources) and just write as Util.<em>method_name_you_want_to use<em>.
 * @author Mustafa
 */

import java.awt.*;
import javax.swing.*;

public class Util {
    public static void addComponent(Container container, Component component, int row, int col, double width, double height) {
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
        button.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));      
        return button;
    }
}

