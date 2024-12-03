package video.store;

/**
 * This is the container page of our project. HERE IS WHERE ALL THE BEAUTY STARTS
 * IT IS NOT COMPLETE, WAITING TO OTHER PARTS OF THE PROJECT TO BE READY.
 * @author Mustafa 
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;
import main.SharedSources.MenuPanel;

public class CStream extends JFrame implements ActionListener {
    public final CardLayout cardLayout;
    public final JPanel container;
    
    public static ArrayList<Video> av;
    public static ArrayList<Video> fv;
    public static ArrayList<Video> ca;
    public static ArrayList<Video> pu;
    MenuPanel menu = new MenuPanel(this);
    Main main;
    public Favorites favorites;
    CartPage cart;
    PurchasesPage purchases;
    AccountPage account;
    
    //database connection info
    String url = "jdbc:mysql://sql12.freesqldatabase.com:3306/sql12747559?user=sql12747559&password=zdI3qyjlca";
    
    
    Customer c;
    
    public CStream(Customer c) {
        super("Test");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        this.c=c;
        
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
        
        databaseCon();
        main = new Main(av,this);
        favorites = new Favorites(fv,this);
        cart = new CartPage(ca,this);
        purchases = new PurchasesPage(pu,this);
        account = new AccountPage(c);
    
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
        this.setVisible(false);
        this.setSize(800,500);

    }
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        String command = e.getActionCommand();
        switch (command) 
        {
            case "Main" -> cardLayout.show(container, "Main");
            case "Favorite" -> cardLayout.show(container, "Favorite");
            case "Cart" -> cardLayout.show(container, "Cart");
            case "Purchases" -> cardLayout.show(container, "Purchases");
            case "Account" -> cardLayout.show(container, "Account");
        }
        repaint();
    }
    

    public void databaseCon() {
    int customerId = c.customerId;
    System.out.println(customerId);
    String sqlAllVideos = "SELECT * FROM Video";
    String sqlFavoriteVideos = "SELECT * FROM Video WHERE id IN (SELECT videoid FROM Favorite WHERE customerid = "+customerId+")";
    String sqlPurchasedVideos = "SELECT * FROM Video WHERE id IN (SELECT videoid FROM Orders WHERE customerid = "+customerId+")";

    try (Connection connection = DriverManager.getConnection(url)) {
        av.clear();
        fv.clear();
        pu.clear();
        
        
        // Fetch favorite videos
        try (PreparedStatement stmt = connection.prepareStatement(sqlFavoriteVideos)) {
            try (ResultSet resultSet = stmt.executeQuery()) {
                while (resultSet.next()) {
                    Video v =new Video(
                            resultSet.getInt("id"),
                            resultSet.getInt("purchaseFrequency"),
                            resultSet.getInt("price"),
                            resultSet.getString("title"),
                            resultSet.getString("director"),
                            resultSet.getString("synopsis"),
                            resultSet.getString("agegroup"),
                            resultSet.getString("genre"),
                            resultSet.getString("videoSource"),
                            resultSet.getString("year"),
                            new ImageIcon(resultSet.getString("imagepath")),
                            cart);
                    v.FavoriteFlag=true;
                    fv.add(v);
                    
                }
            }
        }
        // Fetch all videos
        try (PreparedStatement stmt = connection.prepareStatement(sqlAllVideos);
             ResultSet resultSet = stmt.executeQuery()) {

            while (resultSet.next()) {
                Video v=new Video(
                        resultSet.getInt("id"),
                        resultSet.getInt("purchaseFrequency"),
                        resultSet.getInt("price"),
                        resultSet.getString("title"),
                        resultSet.getString("director"),
                        resultSet.getString("synopsis"),
                        resultSet.getString("agegroup"),
                        resultSet.getString("genre"),
                        resultSet.getString("videoSource"),
                        resultSet.getString("year"),
                        new ImageIcon(resultSet.getString("imagepath")),
                        cart
                );
                
                for(var vi : fv)
                {
                    if(vi.id==v.id)
                    { 
                        
                        v.FavoriteFlag=true;
                    }
                }
                    
                System.out.println(v.FavoriteFlag);
                av.add(v);
                
                
//                    main.list.vl.get(i);
//                    main.list.changeImg(0, main.list, i);  
            }
        }

        // Fetch purchased videos
        try (PreparedStatement stmt = connection.prepareStatement(sqlPurchasedVideos)) {
            try (ResultSet resultSet = stmt.executeQuery()) {
                while (resultSet.next()) {
                    pu.add(new Video(
                            resultSet.getInt("id"),
                            resultSet.getInt("purchaseFrequency"),
                            resultSet.getInt("price"),
                            resultSet.getString("title"),
                            resultSet.getString("director"),
                            resultSet.getString("synopsis"),
                            resultSet.getString("agegroup"),
                            resultSet.getString("genre"),
                            resultSet.getString("videoSource"),
                            resultSet.getString("year"),
                            new ImageIcon(resultSet.getString("imagepath")),
                            cart
                    ));
                }
            }
        }

        //JOptionPane.showMessageDialog(null, "Data fetched successfully!");
    } catch (SQLException e) {
        //JOptionPane.showMessageDialog(null, "Error occurred while fetching data: " + e.getMessage());
        e.printStackTrace();
    }
}

    
    public static void main (String []args) {
        CStream frm = new CStream(null);
    }
}
