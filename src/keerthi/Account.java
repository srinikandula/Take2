package Keerthi;

import java.io.Serializable;


public class Account implements Serializable{
    private String firstName;
    private long accNum;
    private String lastName;
    private int amount;
    private String accType;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public long getAccNum() {
        return accNum;
    }

    public void setAccNum(long accNum) {
        this.accNum = accNum;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getAccType() {
        return accType;
    }

    public void setAccType(String accType) {
        this.accType = accType;
    }
}
