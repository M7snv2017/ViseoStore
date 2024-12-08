package video.store;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author M7sn9
 */
public class Customer {

    public int customerId;
    public String customerUserName;
    public String customerPassword;

    public Customer() {
    }

    public Customer(int customerId, String customerUserName, String customerPassword) {
        this.customerId = customerId;
        this.customerUserName = customerUserName;
        this.customerPassword = customerPassword;
    }

    public static int newid() {
        String url = "jdbc:mysql://sql12.freesqldatabase.com:3306/sql12747559";
        String user = "sql12747559";
        String pass = "zdI3qyjlca";

        int x = 0; // Set to 0 to indicate no value has been retrieved yet
        String sql = "SELECT MAX(id) AS last_number FROM Customer";

        try (Connection connection = DriverManager.getConnection(url, user, pass); Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(sql)) {

            if (resultSet.next()) {
                // If the result is null, return 1, else return last_number + 1
                x = resultSet.getInt("last_number");
                if (resultSet.wasNull()) {
                    x = 0; // Handle the case when the table is empty
                }
            }

        } catch (SQLException e) {
            // Handle the exception, and maybe return a default ID or throw a custom exception
            e.printStackTrace();
            // Optionally show user-friendly message or return a default ID
            return -1; // Return -1 to indicate an error
        }

        return x + 1; // Return the next ID
    }

    public void setId(int id) {
        this.customerId = id;
    }

    public int getId() {
        return customerId;
    }

    public void setUsername (String username) {
        this.customerUserName = username;
    }

    public void setPassword (String password) {
        this.customerPassword = password;
    }

    public void addTofavorites(Video vid) {
        // add vid to favoritesVids
    }

    public void addToCart(Video vid) {
        // add vid to customerOrders
    }

    public void purchase(Video vid) {
        // add vid to purchasedVids
    }

    public Video searchVid(String key) {
        // search for key in all videos
        return null;
    }

    public Video[] displayVids() {
        return null;
    }

    public void displayFavorites() {
        // display favoritesVids
    }

    public void updateAccountInfo(String userName, String password, String phoneNumber) {
        // update customer info
    }

    public void displayAccountInfo() {
        // display customer info
    }

    public void displayPurchasedVids() {
        // display purchasedVids
    }

    public void displayFavoritesVids() {
        // display favoritesVids
    }

}
