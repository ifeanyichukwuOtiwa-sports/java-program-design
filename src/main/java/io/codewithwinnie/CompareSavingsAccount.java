package io.codewithwinnie;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by @author Ifeanyichukwu Otiwa
 * 13/05/2022
 */

public class CompareSavingsAccount {
    public static void main(String[] args) {
        ArrayList<SavingsBankAccount> accts = initAccounts();
        SavingsBankAccount maxAccount = findMaxAcct(accts);
        SavingsBankAccount maxAccount2 = Collections.max(accts);
        System.out.println("Account with largest Balance is: " + maxAccount);
        System.out.println("Account with largest Balance is: " + maxAccount2);
    }

    private static SavingsBankAccount findMaxAcct(final ArrayList<SavingsBankAccount> accts) {
        SavingsBankAccount max = accts.get(0);
        for (SavingsBankAccount acc : accts) {
            if (acc.compareTo(max) > 0) {
                max = acc;
            }
        }
        return max;
    }

    private static ArrayList<SavingsBankAccount> initAccounts() {
        ArrayList<SavingsBankAccount> accts = new ArrayList<>();
        accts.add(new SavingsBankAccount(0));
        accts.get(0).deposit(100);
        accts.add(new SavingsBankAccount(1));
        accts.get(1).deposit(100);
        accts.add(new SavingsBankAccount(2));
        accts.get(2).deposit(100);
        return accts;
    }
}
