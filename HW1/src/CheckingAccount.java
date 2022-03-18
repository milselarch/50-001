public class CheckingAccount extends Account {
    CheckingAccount(int id, double balance) {
        super(id, balance);
    }

    public void withdraw(double amount) {
        double balance = this.getBalance();

        if (balance - amount < -5000) {
            System.out.println("over limit");
        } else {
            super.withdraw(amount);
        }
    }

    static void test() {
        CheckingAccount myCheckAcc = new CheckingAccount(1024, 8000.0);
        myCheckAcc.deposit(2000);
        myCheckAcc.withdraw(15000);

        System.out.println(myCheckAcc.getBalance());
        myCheckAcc.withdraw(200);
        System.out.println(myCheckAcc.getBalance());
        myCheckAcc.deposit(7000);
        myCheckAcc.withdraw(200);
        System.out.println(myCheckAcc.getBalance());
    }
}