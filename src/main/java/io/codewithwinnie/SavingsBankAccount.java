package io.codewithwinnie;

public class SavingsBankAccount implements BankAccount {
    private int accountNumber;
    private int balance;
    private boolean isForeign;

    private final double rate = 0.1;

    public SavingsBankAccount(final int accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Override
    public int getAccountNumber() {
        return accountNumber;
    }

    @Override
    public int getBalance() {
        return balance;
    }

    @Override
    public boolean isForeign() {
        return isForeign;
    }

    @Override
    public void setBalance(final int balance) {
        this.balance = balance;
    }

    @Override
    public void setAccountNumber(final int accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Override
    public void setForeign(final boolean foreign) {
        isForeign = foreign;
    }

    @Override
    public void deposit(int amt) {
        balance += amt;
    }

    @Override
    public boolean hasEnoughCollateral(final int loanAmt) {
        return (balance >= loanAmt / 2);
    }

    @Override
    public void addInterest() {
        addInterest(rate);
    }

    public void addInterest(final double rate) {
        this.setBalance(this.balance  + (int) (this.balance * (rate)));
    }

    @Override
    public String toString() {
        return "Savings account " + accountNumber + " : balance = " + balance + " is " + (isForeign ? "Foreign" : "Domestic");
    }
}
