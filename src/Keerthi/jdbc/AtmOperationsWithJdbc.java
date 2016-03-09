        package Keerthi.jdbc;

        import java.sql.*;
        import java.util.Scanner;


        /**
         * Created by CrazyNaveen on 3/8/16.
         */
        public class AtmOperationsWithJdbc {
            Scanner scanner = new Scanner(System.in);
            PreparedStatement preparedStatement = null;
            ResultSet rs = null;
            Connection conn = null;

            public static void main(String[] args) {

                AtmOperationsWithJdbc atm = new AtmOperationsWithJdbc();
                Scanner scanner = new Scanner(System.in);

                int option;
                do {
                    System.out.println("Please select from the following");
                    System.out.println("1. Retrieve all the existing records");
                    System.out.println("2. Update a record");
                    System.out.println("3. Insert into a record");
                    System.out.println("4. Deposit the amount");
                    System.out.println("5. Withdraw amount");
                    System.out.println("6. Check Balance");
                    System.out.println("7. Delete a record");
                    System.out.println("8. Exit");
                    option = scanner.nextInt();
                    switch (option) {
                        case 1:
                            atm.toRead();
                            break;
                        case 2:
                            atm.toUpdate();
                            break;
                        case 3:
                            atm.toInsert();
                            break;
                        case 4:
                            atm.toDeposit();
                            break;
                        case 5:
                            atm.toWithdraw();
                            break;
                        case 6:
                            atm.checkBalance();
                            break;
                        case 7:
                            atm.toDelete();
                            break;
                        case 8:
                            System.out.println("Thanks for using our Atm..:)");
                            System.exit(1);
                        default:
                            System.err.println("Invalid option selected. Please try again....!");
                    }
                }
                while (option != 7);
            }

            public void toRead() {
                Scanner scanner = new Scanner(System.in);
                PreparedStatement preparedStatement = null;
                ResultSet rs = null;
                Connection conn = null;
                try {
                    Class.forName("org.postgresql.Driver");
                    conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/workshop", "postgres", "keerthi");
                    preparedStatement = conn.prepareStatement("SELECT  * FROM Atm");
                    rs = preparedStatement.executeQuery();
                    while (rs.next()) {
                        System.out.println("id is " + " " + rs.getInt(1));
                        System.out.println("name is " + " " + rs.getString(2));
                        System.out.println("account number is " + " " + rs.getInt(3));
                        System.out.println("balance is" + " " + rs.getInt(4));
                    }

                    System.out.println("data is successfully retrieved...");
                    rs.close();
                    preparedStatement.close();
                    conn.close();

                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        if (!(rs.isClosed())) {
                            rs.close();
                        }
                        if (!(preparedStatement.isClosed())) {
                            preparedStatement.close();
                        }

                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }

            }

            public void toUpdate() {
                Scanner scanner = new Scanner(System.in);
                PreparedStatement preparedStatement = null;
                Connection conn;
                try {
                    Class.forName("org.postgresql.Driver");
                    conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/workshop", "postgres", "keerthi");
                    preparedStatement = conn.prepareStatement("UPDATE Atm set balance = ? WHERE acc_num = ?");
                    System.out.println("Enter your account number");
                    int accNUmber = scanner.nextInt();
                    /*System.out.println("Enter your updated name");
                    String name1 = scanner.next();*/
                    System.out.println("Enter the amount");
                    int amount = scanner.nextInt();
                    preparedStatement.setInt(2, accNUmber);
                    preparedStatement.setInt(1, amount);
                    int res = preparedStatement.executeUpdate();
                    System.out.println("status of updating records... " + res);
                    preparedStatement.close();
                    conn.close();

                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        if (!(preparedStatement.isClosed())) {
                            preparedStatement.close();
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }

            }

            public void toInsert() {
                Scanner scanner = new Scanner(System.in);
                PreparedStatement preparedStatement = null;
                ResultSet rs = null;
                Connection conn;
                try {
                    Class.forName("org.postgresql.Driver");
                    conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/workshop", "postgres", "keerthi");
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
                    preparedStatement.setInt(1, id);
                    preparedStatement.setString(2, name);
                    preparedStatement.setInt(3, acc_num);
                    preparedStatement.setInt(4, balance);
                    int result = preparedStatement.executeUpdate();
                    System.out.println(result);
                    System.out.println("data is successfully inserted...");
                    preparedStatement.close();
                    conn.close();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        if (!(preparedStatement.isClosed())) {
                            preparedStatement.close();
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }

            }

            public void toDelete() {
                Scanner scanner = new Scanner(System.in);
                PreparedStatement preparedStatement = null;
                ResultSet rs = null;
                Connection conn;
                try {
                    Class.forName("org.postgresql.Driver");
                    conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/workshop", "postgres", "keerthi");

                    preparedStatement = conn.prepareStatement("DELETE from Atm where id = ?");
                    System.out.println("Enter id of record to be deleted");
                    int deleteId = scanner.nextInt();
                    preparedStatement.setInt(1, deleteId);
                    int deleteStatus = preparedStatement.executeUpdate();
                    System.out.println("Record is deleted successfully..." + deleteStatus);

                    preparedStatement = conn.prepareStatement("SELECT * FROM Atm");
                    rs = preparedStatement.executeQuery();
                    while (rs.next()) {
                        System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getInt(3) + "  " + rs.getInt(4));
                    }
                    System.out.println("Records after deleting a record with id " + deleteId);
                    rs.close();
                    preparedStatement.close();
                    conn.close();

                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        if (!(rs.isClosed())) {
                            rs.close();
                        }
                        if (!(preparedStatement.isClosed())) {
                            preparedStatement.close();
                        }

                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }


            public void toDeposit() {
                Scanner scanner = new Scanner(System.in);
                PreparedStatement preparedStatement = null;
                ResultSet rs;
                Connection conn;
                try {
                    Class.forName("org.postgresql.Driver");
                    conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/workshop", "postgres", "keerthi");
                    preparedStatement = conn.prepareStatement("SELECT * FROM Atm WHERE acc_num = ?");
                    System.out.println("Enter your account number");
                    int accNum = scanner.nextInt();
                    preparedStatement.setInt(1, accNum);
                    rs = preparedStatement.executeQuery();
                    int balance;
                    int initialAmount = 0;
                    if ((!rs.next())) {
                        System.err.println("Account number is invalid");
                    } else {
                        do {
                            initialAmount = rs.getInt(4);
                            System.out.println("in while " + initialAmount);
                        }
                        while (rs.next());
                        System.out.println(" out of while loop" + initialAmount);
                        System.out.println("Enter your amount to be deposited...");
                        balance = scanner.nextInt();
                        initialAmount = initialAmount + balance;
                        System.out.println("balance.... " + initialAmount);
                    }
                    preparedStatement = conn.prepareStatement("UPDATE Atm set balance = ? WHERE acc_num = ?");
                    System.out.println("Enter your account number");
                    int accountNumber = scanner.nextInt();
                    preparedStatement.setInt(1, initialAmount);
                    preparedStatement.setInt(2, accountNumber);
                    System.out.println(initialAmount);
                    int res = preparedStatement.executeUpdate();
                    System.out.println("status of updating records... " + res);

                    preparedStatement = conn.prepareStatement("SELECT * FROM Atm where acc_num = ?");
                    System.out.println("Enter your account number");
                    int accNumber = scanner.nextInt();
                    preparedStatement.setInt(1, accNumber);
                    rs = preparedStatement.executeQuery();
                    while (rs.next()) {
                        System.out.println("id is " + " " + rs.getInt(1));
                        System.out.println("name is " + " " + rs.getString(2));
                        System.out.println("account number is " + " " + rs.getInt(3));
                        System.out.println("balance is" + " " + rs.getInt(4));
                    }
                    rs.close();
                    preparedStatement.close();
                    conn.close();

                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        if (!(preparedStatement.isClosed())) {
                            preparedStatement.close();
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }

            }


            public void toWithdraw() {
                Scanner scanner = new Scanner(System.in);
                PreparedStatement preparedStatement = null;
                ResultSet rs;
                Connection conn;
                try {
                    Class.forName("org.postgresql.Driver");
                    conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/workshop", "postgres", "keerthi");
                    preparedStatement = conn.prepareStatement("SELECT * FROM Atm WHERE acc_num = ?");
                    System.out.println("Enter your account number");
                    int accNum = scanner.nextInt();
                    preparedStatement.setInt(1, accNum);

                    rs = preparedStatement.executeQuery();
                    int balance;
                    int initialAmount = 0;
                    if ((!rs.next())) {
                        System.err.println("Account number is invalid");
                        return;
                    } else {
                        do {
                            initialAmount = rs.getInt(4);
                            System.out.println(" inside while loop" + initialAmount);
                        }
                        while (rs.next());

                        System.out.println("Enter your amount to be withdraw...");

                        balance = scanner.nextInt();
                        if (balance > initialAmount) {
                            balance = initialAmount;
                            System.err.println("withdraw balance should be less than available amount " + balance);
                        } else {
                            initialAmount = initialAmount - balance;
                        }
                    }
                    preparedStatement = conn.prepareStatement("UPDATE Atm set balance = ? WHERE acc_num = ?");
                    System.out.println("Enter your account number");
                    int accountNumber = scanner.nextInt();
                    preparedStatement.setInt(1, initialAmount);
                    preparedStatement.setInt(2, accountNumber);
                    int res = preparedStatement.executeUpdate();
                    System.out.println("status of updating records... " + res);

                    preparedStatement = conn.prepareStatement("SELECT * FROM Atm where acc_num = ?");
                    System.out.println("Enter your account number");
                    int accNumber = scanner.nextInt();
                    preparedStatement.setInt(1, accNumber);
                    rs = preparedStatement.executeQuery();
                    while (rs.next()) {
                        System.out.println("id is " + " " + rs.getInt(1));
                        System.out.println("name is " + " " + rs.getString(2));
                        System.out.println("account number is " + " " + rs.getInt(3));
                        System.out.println("balance is" + " " + rs.getInt(4));
                    }
                    rs.close();
                    preparedStatement.close();
                    conn.close();

                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        if (!(preparedStatement.isClosed())) {
                            preparedStatement.close();
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }


            }


            public void checkBalance() {
                Scanner scanner = new Scanner(System.in);
                PreparedStatement preparedStatement = null;
                ResultSet rs = null;
                Connection conn;
                try {
                    Class.forName("org.postgresql.Driver");
                    conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/workshop", "postgres", "keerthi");
                    preparedStatement = conn.prepareStatement("SELECT  balance from Atm WHERE  acc_num = ?");
                    System.out.println("Enter your account number");
                    int accountNumber = scanner.nextInt();
                    preparedStatement.setInt(1, accountNumber);
                    rs = preparedStatement.executeQuery();
                    while (rs.next()) {
                        String balance = rs.getString("balance");
                        System.out.println("Available balance in your account " + accountNumber + " is " +" " +balance);
                    }
                    rs.close();
                    preparedStatement.close();
                    conn.close();

                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        if (!(rs.isClosed())) {
                            rs.close();
                        }
                        if (!(preparedStatement.isClosed())) {
                            preparedStatement.close();
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }


            }
        }







