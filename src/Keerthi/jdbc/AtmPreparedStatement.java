package Keerthi.jdbc;

import java.sql.*;
import java.util.Scanner;

/**
 * Created by CrazyNaveen on 3/7/16.
 */
public class AtmPreparedStatement {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            Class.forName("org.postgresql.Driver");

        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/workshop", "postgres", "keerthi");
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Atm (id, name, acc_num, balance ) " +
                "VALUES (?,?,?,?)");
            System.out.println("Enter your id");
            int id = sc.nextInt();
            System.out.println("Enter you name");
            String name = sc.next();
            System.out.println("Enter your account number");
            int accNum = sc.nextInt();
            System.out.println("Enter your balance");
            int balance = sc.nextInt();
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, name);
            preparedStatement.setInt(3, accNum);
            preparedStatement.setInt(4, balance);
            int result = preparedStatement.executeUpdate();
            System.out.println("record insertion status " +result);
            preparedStatement.close();
            connection.close();


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
