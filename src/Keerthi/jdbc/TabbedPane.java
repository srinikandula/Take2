            package Keerthi.jdbc;
            import javax.swing.*;
            import java.awt.*;
            import java.awt.event.ActionEvent;
            import java.awt.event.ActionListener;
            import java.awt.event.WindowAdapter;
            import java.awt.event.WindowEvent;
            import java.sql.*;

            public class TabbedPane {
                public static void main(String[] args) {
                    TabbedPane tp = new TabbedPane();
                }

                JPanel firstPanel = new JPanel();
                JPanel secondPanel = new JPanel();
                JPanel thirdPanel = new JPanel();
                JPanel fourPanel = new JPanel();
                JPanel fivePanel = new JPanel();

                JLabel labelOne = new JLabel("Hello... Create Account");
                JLabel labelTwo = new JLabel();
                JLabel labelThree = new JLabel();
                JLabel labelFour = new JLabel();
                JLabel labelFive = new JLabel();

                private JFrame mainFrame;
                private JPanel controlPanel;
                private JTextField uname,accNumber,balance,accNumber1, accNumber2, balance1, accNumber3,balance2,accNumber4;
                private  JLabel userName, accNum,bal,accNum1,accNum2,bal1, accNum3,bal2,accNum4;
                private JLabel statusLabel;
                private JButton  button1, button2, button3, button4,button5,button6;

                JTabbedPane tabbedPane = new JTabbedPane();

                public TabbedPane(){
                    mainFrame = new JFrame("My Bank Project");
                    mainFrame.setSize(500,500);
                    mainFrame.setLayout(new FlowLayout());
                    mainFrame.addWindowListener(new WindowAdapter() {
                        public void windowClosing(WindowEvent windowEvent){
                            System.exit(0);
                        }
                    });
                    controlPanel = new JPanel();
                    controlPanel.setLayout(new FlowLayout());

                    mainFrame.add(controlPanel);
                    controlPanel.add(tabbedPane);
                    mainFrame.setVisible(true);

                    firstPanel.add(labelOne);
                    secondPanel.add(labelTwo);
                    thirdPanel.add(labelThree);
                    fourPanel.add(labelFour);
                    fivePanel.add(labelFive);

                    tabbedPane.add("Create Account", firstPanel);
                    tabbedPane.add("Check Balance", secondPanel);
                    tabbedPane.add("Deposit", thirdPanel);
                    tabbedPane.add("Withdraw", fourPanel);
                    tabbedPane.add("Delete", fivePanel);

                    userName = new JLabel("User Name");
                    firstPanel.add(userName);
                    uname = new JTextField(18);
                    firstPanel.add(uname);
                    accNum = new JLabel("Account Number");
                    firstPanel.add(accNum);
                    accNumber = new JTextField(18);
                    firstPanel.add(accNumber);
                    bal = new JLabel("Balance");
                    firstPanel.add(bal);
                    balance = new JTextField(18);
                    firstPanel.add(balance);
                    button1 = new JButton("Submit");
                    firstPanel.add(button1);
                    button1.addActionListener(new AddClickListener());

                    button2 = new JButton("Clear");
                    firstPanel.add(button2);
                    button2.addActionListener(new ClearClickListener());

                    accNum1 = new JLabel("Account Number");
                    secondPanel.add(accNum1);
                    accNumber1 = new JTextField(18);
                    secondPanel.add(accNumber1);
                    button3 = new JButton("Submit");
                    secondPanel.add(button3);
                    button3.addActionListener(new CheckListener());
                    button3.setActionCommand("check");

                    accNum2 = new JLabel("Account Number");
                    thirdPanel.add(accNum2);
                    accNumber2 = new JTextField(18);
                    thirdPanel.add(accNumber2);
                    bal1 = new JLabel("Balance");
                    thirdPanel.add(bal1);
                    balance1 = new JTextField(18);
                    thirdPanel.add(balance1);
                    button4 = new JButton("Submit");
                    thirdPanel.add(button4);
                    button4.addActionListener(new DepositListener());

                    accNum3 = new JLabel("Account Number");
                    fourPanel.add(accNum3);
                    accNumber3 = new JTextField(18);
                    fourPanel.add(accNumber3);
                    bal2 = new JLabel("Balance");
                    fourPanel.add(bal2);
                    balance2 = new JTextField(18);
                    fourPanel.add(balance2);
                    button5 = new JButton("Submit");
                    fourPanel.add(button5);
                    button5.addActionListener(new WithdrawListener());

                    accNum4 = new JLabel("Account Number");
                    fivePanel.add(accNum4);
                    accNumber4 = new JTextField(18);
                    fivePanel.add(accNumber4);
                    button6 = new JButton("Delete");
                    fivePanel.add(button6);
                    button6.addActionListener(new DeleteListener());


                }
                private class AddClickListener implements ActionListener {
                    public void actionPerformed(ActionEvent e) {
                        String uName = uname.getText();
                        String accNUm = accNumber.getText();
                        String bal = balance.getText();
                        createAccount(uName, Long.parseLong(accNUm), Double.parseDouble(bal));
                    }
                }

                private class CheckListener implements ActionListener {
                    public void actionPerformed(ActionEvent e) {
                        String accNumer = accNumber1.getText();
                        checkBalance(Long.parseLong(accNumer));
                        String command = e.getActionCommand();
                        if(command.equals("check")){
                            statusLabel.setText("Account Balance is :"+checkBalance(Long.parseLong(accNumer)) );
                        }
                    }
                }

                private double checkBalance(long accNumer) {
                    PreparedStatement preparedStatement = null;
                    ResultSet rs = null;
                    Connection conn;
                    double amount = -1;
                    try {
                        Class.forName("org.postgresql.Driver");
                        conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "keerthi");
                        preparedStatement = conn.prepareStatement("SELECT  balance from Account WHERE  acc_num = ?");
                        preparedStatement.setLong(1, accNumer);
                        rs = preparedStatement.executeQuery();

                        while (rs.next()) {
                             amount = Double.parseDouble(rs.getString("balance"));
                            //System.out.println("Available balance in your account " + accNumer + " is " +" " +balance);

                            statusLabel = new JLabel("kee",JLabel.CENTER);
                            statusLabel.setText("Account Balance is :" + amount);
                            statusLabel.setSize(350,100);
                        }
                        rs.close();
                        preparedStatement.close();
                        conn.close();

                        return amount;

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
                    return amount;
                }

                private class ClearClickListener implements ActionListener{
                    public void actionPerformed(ActionEvent e) {
                        uname.setText("");
                        accNumber.setText("");
                        balance.setText("");
                    }
                }

                private void createAccount(String userName, long accNUmber, double balance) {
                    {
                        try {
                            Class.forName("org.postgresql.Driver");
                            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "keerthi");
                            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO Account(name, acc_num, balance) VALUES (?, ?, ?)");
                            preparedStatement.setString(1, userName);
                            preparedStatement.setLong(2, accNUmber);
                            preparedStatement.setDouble(3, balance);
                            int result = preparedStatement.executeUpdate();
                           // statusLabel.setText("Account created :" + result);
                            preparedStatement.close();
                            conn.close();
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }

                    }

                }

                private class DepositListener implements ActionListener {
                    public void actionPerformed(ActionEvent e) {
                        String accNum = accNumber2.getText();
                        String bal = balance1.getText();
                        toDeposit(Long.parseLong(accNum), Double.parseDouble(bal));
                    }

                private void toDeposit(long accNumber, double balance) {
                        PreparedStatement preparedStatement = null;
                        ResultSet rs;
                        Connection conn;
                        try {
                            Class.forName("org.postgresql.Driver");
                            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "keerthi");
                            preparedStatement = conn.prepareStatement("SELECT * FROM Account WHERE acc_num = ?");
                            preparedStatement.setLong(1, accNumber);
                            rs = preparedStatement.executeQuery();

                            double initialAmount = 0;
                            if ((!rs.next())) {
                                System.err.println("Account number is invalid");
                            } else {
                                do {
                                    initialAmount = Double.parseDouble(rs.getString("balance"));
                                }
                                while (rs.next());
                                initialAmount = initialAmount + balance;
                                System.out.println("balance.... " + initialAmount);
                            }
                            preparedStatement = conn.prepareStatement("UPDATE Account set balance = ? WHERE acc_num = ?");
                            preparedStatement.setDouble(1, initialAmount);
                            preparedStatement.setLong(2, accNumber);
                            int res = preparedStatement.executeUpdate();
                            System.out.println("status of updating records... " + res);
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
                }

                private class WithdrawListener implements ActionListener {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        String accNum = accNumber3.getText();
                        String bal = balance2.getText();
                        toWithdraw(Long.parseLong(accNum), Double.parseDouble(bal));
                    }
                }

                private void toWithdraw(long accNumber, double balance) {
                    PreparedStatement preparedStatement = null;
                    ResultSet rs;
                    Connection conn;
                    try {
                        Class.forName("org.postgresql.Driver");
                        conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "keerthi");
                        preparedStatement = conn.prepareStatement("SELECT * FROM Account WHERE acc_num = ?");
                        preparedStatement.setLong(1, accNumber);
                        rs = preparedStatement.executeQuery();
                        double initialAmount = 0;
                        if ((!rs.next())) {
                            System.err.println("Account number is invalid");
                        } else {
                            do {
                                initialAmount = Double.parseDouble(rs.getString("balance"));
                            }
                            while (rs.next());
                            initialAmount = initialAmount - balance;
                            System.out.println("balance.... " + initialAmount);
                        }
                        preparedStatement = conn.prepareStatement("UPDATE Account set balance = ? WHERE acc_num = ?");
                        preparedStatement.setDouble(1, initialAmount);
                        preparedStatement.setLong(2, accNumber);
                        int res = preparedStatement.executeUpdate();
                        System.out.println("status of updating records... " + res);
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

                private class DeleteListener implements ActionListener {
                    public void actionPerformed(ActionEvent e) {
                        String accNum = accNumber4.getText();
                        deleteAccount(Long.parseLong(accNum));
                    }
                }

                private void deleteAccount(long accNumber) {
                    PreparedStatement preparedStatement = null;
                    ResultSet rs = null;
                    Connection conn;
                    try {
                        Class.forName("org.postgresql.Driver");
                        conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "keerthi");
                        preparedStatement = conn.prepareStatement("DELETE from Account where acc_num = ?");
                        preparedStatement.setLong(1, accNumber);
                        int deleteStatus = preparedStatement.executeUpdate();
                        System.out.println("Record is deleted successfully..." + deleteStatus);
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
            }