package srini.streams;

import java.io.Serializable;

/**
 * Created by skandula on 3/1/16.
 */
public class Account implements Serializable{
    private String firstName;
    private String lastName;
    private String accountType;
    private long accNum;

    public Account(){
    }

    public long getSsn() {
        return ssn;
    }

    public void setSsn(long ssn) {
        this.ssn = ssn;
    }

    private transient long ssn;
    private double balance;

    public long getAccNum() {
        return accNum;
    }

    public void setAccNum(long accNum) {
        this.accNum = accNum;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Account(int accountNumber){
        this.accNum = accountNumber;
    }

<<<<<<< HEAD
=======
    //default constructor
    public Account(){

    }

>>>>>>> 885f664d963148596f54c378aa185954e7be7194
}
