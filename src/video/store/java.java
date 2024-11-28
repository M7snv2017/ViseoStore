
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
        String url = "jdbc:mysql://sql12.freesqldatabase.com:3306/sql12747559"; // Replace with your database URL
        String username = "sql12747559"; // Replace with your database username
        String password = "zdI3qyjlca"; // Replace with your database password

        // Individual SQL statements
        String sql ="select * from Customer";

        // Connection object
        Connection connection = null;

        try {
            // Attempt to establish a connection
            connection = DriverManager.getConnection(url, username, password);
            if (connection != null) {
                System.out.println("Connection successful!");

                // Create a statement object
                Statement statement = connection.createStatement();


                // Execute the query and retrieve the results
                ResultSet resultSet = statement.executeQuery(sql);

                // Collect rows as strings
                while (resultSet.next()) {
                    String row = String.format("ID: %d, Username: %s, Password: %s, Phone: %s",
                            resultSet.getInt("id"),
                            resultSet.getString("username"),
                            resultSet.getString("password"),
                            resultSet.getString("phone"));
                    System.out.println(row + "\n");
                }

                // Close the result set and statement
                resultSet.close();
                statement.close();


                // Close the statement
                statement.close();
            }
        } catch (SQLException e) {
            System.out.println("Error occurred!");
            e.printStackTrace();
        } finally {
            // Close the connection if it was established
            if (connection != null) {
                try {
                    connection.close();
                    System.out.println("Connection closed.");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
