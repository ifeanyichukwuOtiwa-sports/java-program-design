package io.codewithwinnie;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by @author Ifeanyichukwu Otiwa
 * 13/05/2022
 */

public class CompareBankAccounts {
    public static void main(String[] args) {
        ArrayList<BankAccount> accts = initAccounts();
        BankAccount maxAccount = findMaxAcct(accts);
        BankAccount maxAccount2 = Collections.max(accts);
        System.out.println("Account with largest Balance is: " + maxAccount);
        System.out.println("Account with largest Balance is: " + maxAccount2);
    }

    private static BankAccount findMaxAcct(final ArrayList<BankAccount> accts) {
        BankAccount max = accts.get(0);
        for (BankAccount acc : accts) {
            if (acc.compareTo(max) > 0) {
                max = acc;
            }
        }
        return max;
    }

    private static ArrayList<BankAccount> initAccounts() {
        ArrayList<BankAccount> accts = new ArrayList<>();
        accts.add(new SavingsBankAccount(0));
        accts.get(0).deposit(100);
        accts.add(new SavingsBankAccount(1));
        accts.get(1).deposit(100);
        accts.add(new SavingsBankAccount(2));
        accts.get(2).deposit(100);
        return accts;
    }
}
