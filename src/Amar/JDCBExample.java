package Amar;

import java.sql.* ;  // for standard JDBC programs
import java.math.* ; // for BigDecimal and BigInteger support
import java.util.*;
/**
 * Created by Amar on 3/7/2016.
 */
public class JDCBExample {
    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
           // Driver myDriver = new org.postgresql.Driver();
            //DriverManager.registerDriver( myDriver );
            //System.out.println("print1");
            String URL = "jdbc:postgresql://localhost:5432/postgres"; //HOST/DATABASE
            String USER = "postgres";
            String PASS = "Pass1234";
            Connection conn = DriverManager.getConnection(URL, USER, PASS);
            //System.out.println("print2");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * from department where active=false");

            while (rs.next()) {
                int x = rs.getInt("id");
                String s = rs.getString("name");
                Boolean ss = rs.getBoolean("active");
                System.out.println(rs.getInt(1) +"--"+rs.getString(2)+"--"+rs.getBoolean(3));
                System.out.println(x+" "+s+" "+ss);
            }
            rs.close();
            stmt.close();
            conn.close();

        }catch(ClassNotFoundException e) {
            e.printStackTrace();
            //System.out.println("Error: unable to load driver class!");
            System.exit(1);
        }catch(SQLException e) {
            e.printStackTrace();
            //System.out.println("Error: unable to load driver class!");
            System.exit(2);
        }

    }
}
