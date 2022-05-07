package io.codewithwinnie;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Bank {

    private static final Logger LOG = LoggerFactory.getLogger(BankProgram.class);
    private final Map<Integer, Integer> accounts = new HashMap<>();

    private final double rate = 0.01;
    private int nextAcct = 0;

    public int newAccount() {
        int acctNum = nextAcct++;
        accounts.put(acctNum, 0);
        LOG.info("Your new account number is {}", acctNum);
        return acctNum;
    }

    public int getBalance(final int accountNumber) {
        int balance = accounts.get(accountNumber);
        LOG.info("Your balance is {}", balance);
        return balance;
    }

    public void deposit(final int acctNum, final int amt) {
        int balance = accounts.get(acctNum);
        accounts.put(acctNum, balance + amt);
    }

    public boolean authorizeLoan(final int loanAmt, final int accNum) {
        int balance = accounts.get(accNum);
        return (balance >= loanAmt / 2);
    }

    public String toString() {
        Set<Integer> accts = accounts.keySet();
        StringBuilder result = new StringBuilder("The bank has accounts." + accounts.size());

        for (Integer acct: accts) {
            result.append("\n\tBank account ").append(acct).append(" : balance = ").append(accounts.get(acct));
        }
        return result.toString();
    }


    public void addInterest() {
        Set<Integer> acct = accounts.keySet();

        for (Integer a: acct) {
            int balance = accounts.get(a);
            int newBalance = (int) (balance + (rate * balance));
            accounts.put(a, newBalance);
        }
    }
}
