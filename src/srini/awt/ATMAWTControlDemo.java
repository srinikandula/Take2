package srini.awt;

/**
 * Created by skandula on 3/8/16.
 */

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ATMAWTControlDemo {

    private Frame mainFrame;
    private Label firstName;
    private Label lastName;
    private Label balance;
    private TextField firstNameText;
    private TextField lastNameText;
    private TextField balanceText;
    private Button addAccount;
    private Button clearData;
    private Label statusLabel;



    private Panel controlPanel;

    public ATMAWTControlDemo(){
        prepareGUI();
    }

    public static void main(String[] args){
        ATMAWTControlDemo awtControlDemo = new ATMAWTControlDemo();
        awtControlDemo.showEventDemo();
    }

    private void prepareGUI(){
        mainFrame = new Frame("Java AWT Examples");
        mainFrame.setSize(400, 400);
        //mainFrame.setLayout(new FlowLayout());
        mainFrame.setLayout(new FlowLayout());
        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
        firstName = new Label("First Name");
        lastName = new Label("Last Name");
        balance = new Label("Balance");
        firstNameText = new TextField(20);
        lastNameText = new TextField(20);
        balanceText = new TextField(20);
        addAccount = new Button("Add");
        addAccount.addActionListener(new AddClickListener());
        clearData = new Button("Clear");
        clearData.addActionListener(new ClearClickListener());
        controlPanel = new Panel();
        controlPanel.setSize(200,200);
        controlPanel.setLayout(new FlowLayout());
        statusLabel = new Label();
        controlPanel.add(statusLabel);
        mainFrame.add(firstName);
        mainFrame.add(firstNameText);
        mainFrame.add(lastName);
        mainFrame.add(lastNameText);
        mainFrame.add(balance);
        mainFrame.add(balanceText);
        mainFrame.add(addAccount);
        mainFrame.add(clearData);
        mainFrame.add(controlPanel);
        mainFrame.setVisible(true);
    }

    private void showEventDemo(){


        mainFrame.setVisible(true);
    }

    private class AddClickListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            String fristName = firstNameText.getText();
            String lastName = lastNameText.getText();
            String balance = balanceText.getText();
            insertAccount(fristName, lastName, Double.parseDouble(balance));

        }
    }

    private class ClearClickListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            firstNameText.setText("");
            lastNameText.setText("");
            balanceText.setText("");
        }
    }

    private class MyWindowAdapter extends WindowAdapter{
        @Override
        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }
    }
    private void insertAccount(String firstName, String lastName, double balance){
        try {
            //load the driver
            Class.forName("org.postgresql.Driver");
            //Driver driver = new org.postgresql.Driver();
            //DriverManager.registerDriver(driver);
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");
            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO Accounts(firstname, lastname, balance) VALUES (?, ?, ?)");
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setDouble(3, balance);
            int insertedRecords = preparedStatement.executeUpdate();
            statusLabel.setText("Records inserted :" + insertedRecords);
            preparedStatement.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}