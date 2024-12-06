package video.store;

/**
 * Here is where favorite videos of a customer are shown to him, and search feature is provided.
 * 
 * @author Mustafa
 */

import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;
import main.SharedSources.*;

public class Favorites extends JPanel {
    private static final String url = "jdbc:mysql://sql12.freesqldatabase.com:3306/sql12747559";
    private static final String user = "sql12747559";
    private static final String password = "zdI3qyjlca";
    
    SearchPanel search = new SearchPanel();
    VideosList list;
    CStream s;
    public Favorites(ArrayList<Video> favorites,CStream s) {
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        this.s=s;
        gbc.fill = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.1;
        gbc.weighty = 0.1;
        JLabel lbl = new JLabel ("Favorites Page");
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
        list = new VideosList(favorites, Favorites.this);
        JScrollPane favoritesScrollPane = new JScrollPane(list);
        this.add(favoritesScrollPane, gbc);   
    }
    public void change(ArrayList<Video> favorites)
    {
        list = new VideosList(favorites, s);
    }

    private ArrayList<Video> fetchFavoritesFromDatabase() {
        ArrayList<Video> favorites = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM favorites")) {

         while (resultSet.next()) {
                    Video video =new Video(
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
                            new ImageIcon(resultSet.getString("imagepath")));
                favorites.add(video);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error fetching favorites from the database: " + e.getMessage(),
                    "Database Error", JOptionPane.ERROR_MESSAGE);
        }

        return favorites;
    }

    public void updateFavorites() {
        ArrayList<Video> favorites = fetchFavoritesFromDatabase();
        remove(list);
        list = new VideosList(favorites, this);
        add(new JScrollPane(list), new GridBagConstraints() {{
            fill = GridBagConstraints.BOTH;
            gridx = 0;
            gridy = 2;
            weightx = 1.0;
            weighty = 1.0;
        }});
        revalidate();
        repaint();
    }
    //for test
//    public static void main(String[] args) {
//        JFrame frm = new JFrame();
//
//        ArrayList<Video> arr = new ArrayList<>();
//        Main p = new Main(arr);
//
//        frm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        frm.setSize(800, 500);
//        frm.setLocationRelativeTo(null);
//        frm.add(p);
//        frm.setVisible(true);   
//    }
 }
