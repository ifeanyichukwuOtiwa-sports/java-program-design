package io.codewithwinnie;

import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Bank {

    private static final Logger LOG = LoggerFactory.getLogger(Bank.class);
    private final Map<Integer, BankAccount> accounts;

    private int nextAcctNum = 0;

    public Bank(final Map<Integer, BankAccount> accounts, final int nextAcctNum) {
        this.accounts = accounts;
        this.nextAcctNum = nextAcctNum;
    }

    public int newAccount(final Integer type, final boolean isForeign) {
        int acctNum = nextAcctNum++;

        BankAccount bankAccount;
        if (type == 1) {
            bankAccount = new SavingsBankAccount(acctNum);
        } else if (type == 2) {
            bankAccount = new RegularCheckingBankAccount(acctNum);
        } else {
            bankAccount = new InterestCheckingBankAccount(acctNum);
        }
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
        bankAccount.deposit(amt);
    }

    public boolean authorizeLoan(final int loanAmt, final int accNum) {
        final BankAccount bankAccount = accounts.get(accNum);
        return bankAccount.hasEnoughCollateral(loanAmt);
    }

    public String toString() {
        StringBuilder result = new StringBuilder("The bank has accounts:" + accounts.size());

        for (BankAccount bankAccount: accounts.values()) {
            result.append("\n\t").append(bankAccount.toString());
        }
        return result.toString();
    }

    public void setForeign(int acctnum, boolean isforeign) {
        BankAccount ba = accounts.get(acctnum);
        ba.setForeign(isforeign);
    }

    public void addInterest() {

        for (BankAccount bankAccount: accounts.values()) {
            bankAccount.addInterest();
        }
    }

    public Map<Integer, BankAccount> getAccounts() {
        return accounts.entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public int getNextAcctNum() {
        return nextAcctNum;
    }
}
