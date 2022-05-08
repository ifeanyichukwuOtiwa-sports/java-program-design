package io.codewithwinnie;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Bank {

    private static final Logger LOG = LoggerFactory.getLogger(BankProgram.class);
    private final Map<Integer, BankAccount> accounts = new HashMap<>();

    private final double rate = 0.01;
    private int nextAcct = 0;

    public int newAccount(final boolean isForeign) {
        int acctNum = nextAcct++;
        final BankAccount bankAccount = new BankAccount(acctNum);
        bankAccount.setForeign(isForeign);
        accounts.put(acctNum, bankAccount);
        LOG.info("Your new account number is {}", acctNum);
        return acctNum;
    }

    public int getBalance(final int accountNumber) {
        final BankAccount bankAccount = accounts.get(accountNumber);
        int balance = bankAccount.getBalance();
        LOG.info("Your balance is {}", balance);
        return balance;
    }

    public void deposit(final int acctNum, final int amt) {
        final BankAccount bankAccount = accounts.get(acctNum);
        int balance = bankAccount.getBalance();
        bankAccount.setBalance(balance + amt);
    }

    public boolean authorizeLoan(final int loanAmt, final int accNum) {
        final BankAccount bankAccount = accounts.get(accNum);
        int balance = bankAccount.getBalance();
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

    public void setForeign(int acctnum, boolean isforeign) {
        BankAccount ba = accounts.get(acctnum);
        ba.setForeign(isforeign);
    }

    public void addInterest() {

        for (BankAccount bankAccount: accounts.values()) {
            int balance = bankAccount.getBalance();
            int newBalance = (int) (balance + (rate * balance));
            bankAccount.setBalance(newBalance);
        }
    }
}
