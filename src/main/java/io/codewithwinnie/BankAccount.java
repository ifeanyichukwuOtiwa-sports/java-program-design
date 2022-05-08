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

    public void deposit(int amt) {
        balance += amt;
    }

    public boolean hasEnoughCollateral(final int loanAmt) {
        return (balance >= loanAmt / 2);
    }

    public void addInterest(final double rate) {
        balance *= (int) (rate + 1);
    }

    @Override
    public String toString() {
        return "Bank account " + accountNumber + " : balance = " + balance + " is " + (isForeign ? "Foreign" : "Domestic");
    }
}
