package srini.streams;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by skandula on 3/1/16.
 */
public class Account implements Serializable,Comparable<Account>{
    private String firstName;
    private String lastName;
    private String accountType;
    private long accNum;
    private transient long ssn;
    private double balance;
    private List<String> addresses;

    public long getSsn() {
        return ssn;
    }

    public void setSsn(long ssn) {
        this.ssn = ssn;
    }

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
        addresses = new ArrayList<>();
    }
    //default constructor
    public Account(){
        addresses = new ArrayList<>();

    }

    @Override
    public int compareTo(Account toBeCompared) {
        if(this.getBalance() == toBeCompared.getBalance()){
            if(this.getAccNum() == toBeCompared.getAccNum()){
                return 0;
            }else if(this.getAccNum() > toBeCompared.getAccNum()){
                return 1;
            } else {
                return -1;
            }
        }else if(this.getBalance() > toBeCompared.getBalance()){
            return 1;
        } else {
            return -1;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null){
            return false;
        }
        if(this == obj){
            return true;
        }
        //check if the object is of type Account.class.
        if(obj instanceof Account){
            Account copy = (Account)obj;
            if(copy.getAccNum() == this.getAccNum() ){
                return true;
            }else{
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return (int)this.accNum;
    }
}
