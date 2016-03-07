package srini.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * Created by skandula on 2/23/16.
 */
public class JDBCUpdate {
    public static void main(String[] args) {
        try {
            //load the driver
            Class.forName("org.postgresql.Driver");
            //Driver driver = new org.postgresql.Driver();
            //DriverManager.registerDriver(driver);
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");
            PreparedStatement preparedStatement = conn.prepareStatement("update department set name =? where id = ?");
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the value for id");
            int id = sc.nextInt();
            System.out.println("Enter the value for name");
            String name = sc.next();
            preparedStatement.setInt(2, id);
            preparedStatement.setString(1, name);

            int updatedRecords = preparedStatement.executeUpdate();
            System.out.println("Records updated :"+updatedRecords);
            preparedStatement.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
