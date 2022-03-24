package exam2019;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class AccountComparator implements Comparator<Account> {
    @Override
    public int compare(Account o1, Account o2) {
        return o1.getId().compareTo(o2.getId());
    }

    public static void main(String[] args) {
        Account a = new Account("simon", 20);
        System.out.println(a.getId());
        System.out.println(a.getBalance());
        System.out.println(a);
        ArrayList<Account> l = new ArrayList<>();
        l.add(new Account("man", 30));
        l.add(new Account("eric", 100));
        l.add(new Account("norman", 10));
        Collections.sort(l);
        System.out.println(l);
        Collections.sort(l, new AccountComparator());
        System.out.println(l);
    }
}
