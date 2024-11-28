
package main.SharedSources;

import java.awt.*;
import javax.swing.*;

/**
 * SearchPanel can be used to search from videos and favorite lists
 * You do not have to attach it to your frame unless there is an need
 * @author Mustafa
 */
public class SearchPanel extends JPanel {
    String[] category = {"Title", "Genre", "Director"};
    JComboBox<String> categories = new JComboBox<>(category);
    JTextField searchField = new JTextField(20);
    JButton submit = new JButton("Search");
    
    public SearchPanel() {
        initialize();
    }
    
    private void initialize() {
        setLayout(new FlowLayout());
        
        JLabel lbl1 = new JLabel("Search by");
        lbl1.setFont(new Font("Arial", Font.BOLD, 20));
        
        add(lbl1);
        add(Box.createHorizontalStrut(10));

        
        categories.setSelectedIndex(0);
        categories.setMaximumRowCount(3);
        categories.setFont(new Font("Arial", Font.BOLD, 16));
        add(categories);
        add(Box.createHorizontalStrut(10));
        searchField.setFont(new Font("Arial", Font.PLAIN, 16));
        add(searchField);
        add(submit);
    }    
}
