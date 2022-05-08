package io.codewithwinnie;

public class BankAccount {
    private int accountNumber;
    private int balance;
    private boolean isForeign;

    public BankAccount(final int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public int getBalance() {
        return balance;
    }

    public boolean isForeign() {
        return isForeign;
    }

    public void setBalance(final int balance) {
        this.balance = balance;
    }

    public void setAccountNumber(final int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setForeign(final boolean foreign) {
        isForeign = foreign;
    }
}
