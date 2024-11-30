
package video.store;

import java.sql.*;

public class java {
        // Replace with your actual connection string
        //String url = "jdbc:sqlserver://5.246.199.52:1433;databaseName=VideoStore;user=user;password=pass;";
        //String url = "jdbc:sqlserver://DESKTOP-329LARA\\SQLEXPRESS;databaseName=VideoStore;user=user;password=pass;";
        //String url = "jdbc:sqlserver://DESKTOP-329LARA:1433;databaseName=VideoStore;user=user;password=pass;";
        //String url = "jdbc:sqlserver://localhost:1433;databaseName=VideoStore;user=user;password=pass;";
        //String url = "jdbc:sqlserver://5.246.199.52:1433;databaseName=VideoStore;user=user;password=pass;encrypt=true;trustServerCertificate=true;";
        //String url = "jdbc:sqlserver://192.168.0.116:1433;databaseName=VideoStore;user=user;password=pass;TrustServerCertificate=True";
        //String url = "jdbc:sqlserver://51.36.180.116:1433;databaseName=VideoStore;user=user;password=pass;TrustServerCertificate=True";
        public static void main(String[] args) {
        // Database credentials
        String url = "jdbc:mysql://sql12.freesqldatabase.com:3306/sql12747559?user=sql12747559&password=zdI3qyjlca";

        // SQL query
        String sql = "SELECT * FROM Customer";

        // Try-with-resources for automatic resource management
        try (Connection connection = DriverManager.getConnection(url);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            System.out.println("Connection successful!");

            // Process the result set
            while (resultSet.next()) {
                String row = String.format(
                        "ID: %d, Username: %s, Password: %s",
                        resultSet.getInt("id"),
                        resultSet.getString("username"),
                        resultSet.getString("password")
                );
                System.out.println(row + "\n");
            }
        } catch (SQLException e) {
            System.out.println("Error occurred while connecting or executing the query.");
            e.printStackTrace();
        }
    }
}
