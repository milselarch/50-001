//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.Date;

class Account {
    private int id;
    private double balance;
    private static double annualInterestRate;
    private final Date dateCreated;

    public Account() {
        this.dateCreated = new Date();
    }

    public Account(int id, double balance) {
        this.id = id;
        this.balance = balance;
        this.dateCreated = new Date();
    }

    public int getId() {
        return this.id;
    }

    public double getBalance() {
        return this.balance;
    }

    public static double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBalance(double amount) {
        this.balance = amount;
    }

    public static void setAnnualInterestRate(double amount) {
        annualInterestRate = amount;
    }

    public double getMonthlyInterestRate() {
        // return annualInterestRate / 12.0;
        /*
        return -1 + Math.pow(
            1.0 + annualInterestRate / 100.0
        , 1/12.0);
        */
        return this.getMonthlyInterest() / this.balance;
    }

    public double getMonthlyInterest() {
        return this.balance * (annualInterestRate / 1200.0D);
    }

    public Date getDateCreated() {
        return this.dateCreated;
    }

    public void withdraw(double amount) {
        this.balance -= amount;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }
}
