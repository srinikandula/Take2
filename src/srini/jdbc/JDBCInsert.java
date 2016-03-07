package srini.jdbc;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.sql.*;
import java.util.Scanner;

/**
 * Created by skandula on 2/23/16.
 */
public class JDBCInsert {
    public static void main(String[] args) {
        try {
            //load the driver
            Class.forName("org.postgresql.Driver");
            //Driver driver = new org.postgresql.Driver();
            //DriverManager.registerDriver(driver);
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");
            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO Department(id, name, active) VALUES (?, ?, ?)");
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the value for id");
            int id = sc.nextInt();
            System.out.println("Enter the value for name");
            String name = sc.next();
            System.out.println("Enter the value for active");
            boolean active = Boolean.parseBoolean(sc.next());
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, name);
            preparedStatement.setBoolean(3, active);
            int insertedRecords = preparedStatement.executeUpdate();
            System.out.println("Records inserted :"+insertedRecords);
            preparedStatement.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
