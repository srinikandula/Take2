package Amar;

import java.sql.*;
import java.util.Scanner;

/**
 * Created by Amar on 3/8/2016.
 */
public class AmarATMSimulatorWithJDBC {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        AmarATMSimulatorWithJDBC api = new AmarATMSimulatorWithJDBC();
        int option = 0;
        do{
            System.out.println("Please make your selection");
            System.out.println("1.Create Account");
            System.out.println("2.Account balance");
            System.out.println("3.Deposit");
            System.out.println("4.Withdraw");
            System.out.println("5.Display Account Details");
            System.out.println("6.Delete Account");
            System.out.println("7.Exit");
            option = s.nextInt();
            switch (option){
                case 1:
                    api.createAccount();
                    break;
                case 2:
                    api.findAccountBalance();
                    break;
                case 3:
                    api.makeDeposit();
                    break;
                case 4:
                    api.makeWithdrawal();
                    break;
                case 5:
                    api.displayAccounts();
                    break;
                case 6:
                    api.deleteAccount();
                    break;
                case 7:
                    System.out.println("Thank you for using our ATM simulator");
                    System.exit(1);
                default:
                    System.err.println("invalid option selected");
            }
        }while(option !=7 );

    }
    public void createAccount(){
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
            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO Account(accnum, firstname, lastname, balance) VALUES (?, ?, ?, ?)");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter the account number");
            int accountNumber = scanner.nextInt();
            System.out.println("Please enter the first name");
            String firstName = scanner.next();
            System.out.println("Please enter the last name");
            String lastName = scanner.next();
            System.out.println("Please enter the account balance");
            double balance = scanner.nextDouble();
            preparedStatement.setInt(1, accountNumber);
            preparedStatement.setString(2, firstName);
            preparedStatement.setString(3, lastName);
            preparedStatement.setDouble(4, balance);
            int insertedRecords = preparedStatement.executeUpdate();
            System.out.println("Records inserted :"+insertedRecords);
            preparedStatement.close();
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
    public void findAccountBalance(){
       try {
            Class.forName("org.postgresql.Driver");
            String URL = "jdbc:postgresql://localhost:5432/postgres"; //HOST/DATABASE
            String USER = "postgres";
            String PASS = "Pass1234";
            Connection conn = DriverManager.getConnection(URL, USER, PASS);
            String selectSQL = "SELECT balance FROM account WHERE accnum = ?";
            PreparedStatement stmt = conn.prepareStatement(selectSQL);
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter the account number");
            int accountNumber = scanner.nextInt();
            stmt.setInt(1, accountNumber);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
               Double bal = rs.getDouble("balance");
               System.out.println("Balance of your account "+accountNumber+" $"+bal);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void makeDeposit(){
        try {
            Class.forName("org.postgresql.Driver");
            String URL = "jdbc:postgresql://localhost:5432/postgres"; //HOST/DATABASE
            String USER = "postgres";
            String PASS = "Pass1234";
            Connection conn = DriverManager.getConnection(URL, USER, PASS);
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter the account number");
            int accountNumber = scanner.nextInt();
            PreparedStatement stmt = conn.prepareStatement("SELECT * from account where accnum =?");
            stmt.setInt(1, accountNumber);
            ResultSet rs = stmt.executeQuery();
            if ((!rs.next())) {
                System.err.println("Account number is invalid, please choose the option again");
                return;
            } else {
                while (rs.next()) {
                    int x = rs.getInt("accnum");
                    Scanner sc = new Scanner(System.in);
                    System.out.println("Please enter the amount to be deposited");
                    double depositAmount = sc.nextDouble();
                    double balance = rs.getDouble("balance");
                    balance += depositAmount;
                    System.out.println("Account balance after deposit: " + "$" + balance);
                    PreparedStatement preparedStatement = conn.prepareStatement("update account set balance =? where accnum =?");
                    preparedStatement.setInt(2, accountNumber);
                    preparedStatement.setDouble(1, balance);
                    int insertedRecords = preparedStatement.executeUpdate();
                    System.out.println("Records inserted :" + insertedRecords);
                    System.out.println("Account is updated successfully");
                    preparedStatement.close();
                }
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void makeWithdrawal(){
        try {
            Class.forName("org.postgresql.Driver");
            String URL = "jdbc:postgresql://localhost:5432/postgres"; //HOST/DATABASE
            String USER = "postgres";
            String PASS = "Pass1234";
            Connection conn = DriverManager.getConnection(URL, USER, PASS);
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter the account number");
            int accountNumber = scanner.nextInt();
            PreparedStatement stmt = conn.prepareStatement("SELECT * from account where accnum =?");
            stmt.setInt(1, accountNumber);

            ResultSet rs = stmt.executeQuery();
            if ((!rs.next())) {
                System.err.println("Account number is invalid, please choose the option again");
                return;
            } else {

                while (rs.next()) {
                    int x = rs.getInt("accnum");

                    Scanner sc = new Scanner(System.in);
                    System.out.println("Please enter the amount to be Withdrawn");
                    double withdrawAmount = sc.nextDouble();
                    double balance = rs.getDouble("balance");
                    if (withdrawAmount > balance) {
                        System.err.println("Withdrawal amount is bigger than the current amount.\nChoose the option again.");
                        return;
                    } else {
                        balance -= withdrawAmount;
                        System.out.println("Account balance after withdrawal: " + "$" + balance);
                        PreparedStatement preparedStatement = conn.prepareStatement("update account set balance =? where accnum =?");
                        preparedStatement.setInt(2, accountNumber);
                        preparedStatement.setDouble(1, balance);
                        int insertedRecords = preparedStatement.executeUpdate();
                        System.out.println("Records inserted :" + insertedRecords);
                        System.out.println("Account is updated successfully");
                        //System.out.println("Account balance after Withdrawal is: " + "$" + rs.getDouble("balance"));
                        preparedStatement.close();
                    }
                }
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void displayAccounts(){
        try {
            Class.forName("org.postgresql.Driver");
            String URL = "jdbc:postgresql://localhost:5432/postgres"; //HOST/DATABASE
            String USER = "postgres";
            String PASS = "Pass1234";
            Connection conn = DriverManager.getConnection(URL, USER, PASS);
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("select * from account ");
            while(rs.next()){
                System.out.println(rs.getInt(1) +"--"+rs.getString(2)+"--"+rs.getString(3)+"--"+"$"+rs.getDouble(4));
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
    public void deleteAccount(){
        try {
            Class.forName("org.postgresql.Driver");
            String URL = "jdbc:postgresql://localhost:5432/postgres"; //HOST/DATABASE
            String USER = "postgres";
            String PASS = "Pass1234";
            Connection conn = DriverManager.getConnection(URL, USER, PASS);
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter the account number");
            int accountNumber = scanner.nextInt();
            PreparedStatement stmt = conn.prepareStatement("SELECT * from account where accnum =?");
            stmt.setInt(1, accountNumber);

            ResultSet rs = stmt.executeQuery();
            if ((!rs.next())) {
                System.err.println("Account number is invalid, please choose the option again");
                return;
            } else {
                PreparedStatement smt = conn.prepareStatement("DELETE from account where accnum = ?");
                smt.setInt(1, accountNumber);
                smt.executeUpdate();
                System.out.println("Account is deleted successfully");
                smt.close();
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
