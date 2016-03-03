package Amar;

import java.io.Serializable;

/**
 * Created by Amar on 3/2/2016.
 */
public class AccountForPOJO implements Serializable {
    private String firstName;
    private String lastName;
    private String accountType;
    private long accNum;
    private transient long ssn;
    private double balance;

    public long getSsn() {
        return ssn;
    }

    public void setSsn(long ssn) {
        this.ssn = ssn;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
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

    public long getAccNum() {
        return accNum;
    }

    public void setAccNum(long accNum) {
        this.accNum = accNum;
    }
}
