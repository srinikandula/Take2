package Keerthi.jdbc;

import java.sql.*;
import java.util.Scanner;

/**
 * Created by CrazyNaveen on 3/8/16.
 */
public class AtmUpdate {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/workshop","postgres", "keerthi");
            preparedStatement = conn.prepareStatement("INSERT INTO " +
                    "Atm(id,name,acc_num,balance)VALUES(?,?,?,?) ");
            System.out.println("Enter id");
            int id = scanner.nextInt();
            System.out.println("Enter your name");
            String name = scanner.next();
            System.out.println("Enter your account number");
            int acc_num = scanner.nextInt();
            System.out.println("Enter your balance");
            int balance = scanner.nextInt();
            preparedStatement.setInt(1,id);
            preparedStatement.setString(2, name);
            preparedStatement.setInt(3, acc_num);
            preparedStatement.setInt(4, balance);
            int result = preparedStatement.executeUpdate();
            System.out.println(result);
            System.out.println("data is successfully inserted...");
            preparedStatement = conn.prepareStatement("SELECT  * FROM Atm");
             rs = preparedStatement.executeQuery();
            while (rs.next()){
                System.out.println("id is " +" " +rs.getInt(1));
                System.out.println("name is " + " "+rs.getString(2));
                System.out.println("account numbe is " + " "+rs.getInt(3));
                System.out.println("balance is" + " "+rs.getInt(4));
            }

            System.out.println("data is successfully retrieved...");
            preparedStatement = conn.prepareStatement("UPDATE Atm set name = ? WHERE id = ?");
            System.out.println("Enter your id");
            int idi = scanner.nextInt();
            System.out.println("Enter your updated name");
            String name1 = scanner.next();
            preparedStatement.setInt(2, idi);
            preparedStatement.setString(1,name1);
            int res = preparedStatement.executeUpdate();
            System.out.println("status of updating records... " + res);

            preparedStatement = conn.prepareStatement("SELECT name from Atm WHERE id = ?");
            System.out.println("Enter your id");
            int id1 = scanner.nextInt();
            preparedStatement.setInt(1, id1);
            //preparedStatement.execute();
            //System.out.println(preparedStatement.execute());
            rs = preparedStatement.executeQuery();
            while (rs.next()){
                System.out.println("data retrieved using where clause...");
                System.out.println(rs.getString("name"));
            }
            preparedStatement = conn.prepareStatement("SELECT * from Atm WHERE id = ?");
            System.out.println("Enter your id");
            int givenId = scanner.nextInt();
            preparedStatement.setInt(1,givenId);
            rs = preparedStatement.executeQuery();
            while (rs.next()){
                System.out.println(rs.getInt(1));
                System.out.println(rs.getString(2));
                System.out.println(rs.getInt(3));
                System.out.println(rs.getInt(4));
                System.out.println("Data is successfully retrieved using  where clause....");
            }

            preparedStatement = conn.prepareStatement("DELETE from Atm where id = ?");
            System.out.println("Enter id of record to be deleted");
            int deleteId = scanner.nextInt();
            preparedStatement.setInt(1, deleteId);
            int deleteStatus = preparedStatement.executeUpdate();
            System.out.println("Record is deleted successfully..." +deleteStatus);

            preparedStatement = conn.prepareStatement("SELECT * FROM Atm");
            rs = preparedStatement.executeQuery();
            while (rs.next()){
                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+ "  "+rs.getInt(3)+ "  "+ rs.getInt(4));
            }
            System.out.println("Records after deleting a record with id "+deleteId );

            rs.close();
            preparedStatement.close();
            conn.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if(!(rs.isClosed())){
                    rs.close();
                }
                if(!(preparedStatement.isClosed())){
                    preparedStatement.close();
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }
}
