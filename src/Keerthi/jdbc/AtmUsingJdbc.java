package Keerthi.jdbc;

import java.sql.*;

/**
 * Created by CrazyNaveen on 3/7/16.
 */
public class AtmUsingJdbc {

    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/workshop", "postgres", "keerthi");
           Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Atm");
            while (resultSet.next()){
                System.out.println(resultSet.getInt(1));
                System.out.println(resultSet.getString(2));
                System.out.println(resultSet.getInt(3));
                System.out.println(resultSet.getInt(4));

            }
            resultSet.close();
            statement.close();
            connection.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}
