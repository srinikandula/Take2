package Amar;

import java.io.Serializable;
import java.util.Comparator;

/**
 * Created by Amar on 3/2/2016.
 */
public class AccountForPOJO implements Serializable,Comparable<AccountForPOJO>,Comparator<AccountForPOJO> {
    private String firstName;
    private String lastName;
    private String accountType;
    private long accNum;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    private long id;
    private transient long ssn;
    private double balance;
    public AccountForPOJO(){ }
    public AccountForPOJO(int accountNumber){
        this.accNum = accountNumber;
    }
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

    @Override
    public int compare(AccountForPOJO o1, AccountForPOJO o2) {
        if(o1.getId() == o2.getId()){
            if(o1.getBalance() == o2.getBalance()){
                return 0;
            }else if(o1.getBalance() > o2.getBalance()){
                return 1;
            }else {
                return -1;
            }
        }else if(o1.getId() > o2.getId()){
            return 1;
        }else {
            return -1;
        }

    }


    @Override
    public int compareTo(AccountForPOJO toBeCompared) {
        //accounts[0].compareTo(accounts[1])

        /*
        if(this.getAccNum() == toBeCompared.getAccNum()){
            return 0;
        }else if(this.getAccNum() > toBeCompared.getAccNum()){
            return 1;
        } else {
            return -1;
        }*/
        //System.out.println(" in compareto()");
        /*if(this.getId() == toBeCompared.getId()){
            if(this.getBalance() == toBeCompared.getBalance()){
            return 0;
            }else if(this.getBalance() > toBeCompared.getBalance()){
                return 1;
            } else {
                return -1;
            }
        }else if(this.getId() > toBeCompared.getId()){
            return 1;
        } else {
            return -1;
        }*/
        if(this.getBalance() == toBeCompared.getBalance()){
            if(this.getId() == toBeCompared.getId()){
                return 0;
            }else if(this.getId() > toBeCompared.getId()){
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
        System.out.println("in equals()");
        if(obj == null){
            return false;
        }
        if(this == obj){
            return true;
        }
        //check if the object is of type Account.class.
        if(obj instanceof AccountForPOJO){
            AccountForPOJO copy = (AccountForPOJO)obj;
            System.out.println("Comparing " + this.getAccNum() +" and "+ copy.getAccNum());
            if(copy.getAccNum() == this.getAccNum() ){
                return true;
            }else{
                return false;
            }
        } else {
            return false;
        }
    }

}
