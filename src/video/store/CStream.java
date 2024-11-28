
package video.store;

/**
 * This is the container page of our project. HERE IS WHERE ALL THE BEAUTY STARTS
 * IT IS NOT COMPLETE, WAITING TO OTHER PARTS OF THE PROJECT TO BE READY.
 * @author Mustafa
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import main.SharedSources.MenuPanel;

public class CStream extends JFrame implements ActionListener {
    private final CardLayout cardLayout;
    private final JPanel container;
    private ArrayList<Video> av;
    private ArrayList<Video> fv;
    private ArrayList<Video> ca;
    private ArrayList<Video> pu;
    MenuPanel menu = new MenuPanel(this);
    Main main;
    Favorites favorites;
    CartPage cart;
    PurchasesPage purchases;
    AccountPage account;
    
    public CStream() {
        super("Test");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(800,500);
        this.setLocationRelativeTo(null);
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridheight = 3;
        gbc.weightx = 0;
        gbc.weighty =1.0;
        add(menu, gbc);

        av = new ArrayList<>();
        fv = new ArrayList<>();
        ca = new ArrayList<>();
        pu = new ArrayList<>();

        main = new Main(av);
        favorites = new Favorites(fv);
        cart = new CartPage(ca);
        purchases = new PurchasesPage(pu);
        account = new AccountPage();
    
        cardLayout = new CardLayout();
        container = new JPanel(cardLayout);

        container.add(main, "Main");
        container.add(favorites, "Favorite");
        container.add(cart, "Cart");
        container.add(purchases, "Purchases");
        container.add(account, "Account");
        
        
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 10.0;
        add(container, gbc); 

        cardLayout.show(container, "Main");    

        pack();
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "Main" -> cardLayout.show(container, "Main");
            case "Favorite" -> cardLayout.show(container, "Favorite");
            case "Cart" -> cardLayout.show(container, "Cart");
            case "Purchases" -> cardLayout.show(container, "Purchases");
            case "Account" -> cardLayout.show(container, "Account");
        }
        repaint();
    }

    public static void main (String []args) {
        CStream frm = new CStream();
    }
}
