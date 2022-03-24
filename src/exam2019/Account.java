package exam2019;

import java.util.Comparator;
import java.util.Date;

public class Account implements Comparable<Account> {
    private String id;
    private double balance;
    private Date dateCreated;

    Account (String id, double balance) {
        this.id = id;
        this.balance = balance;
    }

    public String getId() { return this.id; }
    public double getBalance() { return this.balance; }
    public Date getDateCreated() { return dateCreated; }

    @Override
    public String toString() {
        return "Account:" + this.id;
    }

    @Override
    public int compareTo(Account o) {
        /*
        return 1 if this is more than the other thing
        return 0 if same
        return -1 if this is less than other thing
        */
        return Double.compare(this.balance, o.getBalance());
    }
}


