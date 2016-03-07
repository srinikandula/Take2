package srini.jdbc;

import java.sql.*;

/**
 * Created by skandula on 2/23/16.
 */
public class JDBCSelectColumnsWithWhere {
    public static void main(String[] args) {
        try {
            //load the driver
            Class.forName("org.postgresql.Driver");
            //Driver driver = new org.postgresql.Driver();
            //DriverManager.registerDriver(driver);
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("select name from department where active=true");
            while(rs.next()){
                //System.out.println(rs.getString("id") +"--"+rs.getString("name")+"--"+rs.getString("active"));
                System.out.println(rs.getString("name"));
            }
            rs.close();
            statement.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
