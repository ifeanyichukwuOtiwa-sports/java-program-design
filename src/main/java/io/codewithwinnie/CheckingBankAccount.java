package io.codewithwinnie;

/**
 * Created by @author Ifeanyichukwu Otiwa
 * 09/05/2022
 */

public class CheckingBankAccount implements BankAccount {

    private int accountNumber;
    private int balance;
    private boolean isForeign;


    public CheckingBankAccount(Integer acctNumber) {
        this.accountNumber = acctNumber;
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
        this.isForeign = foreign;
    }

    @Override
    public void deposit(final int amt) {
        balance += amt;
    }

    @Override
    public boolean hasEnoughCollateral(final int loanAmt) {
        return balance >= ((2 * loanAmt) / 3);
    }

    @Override
    public void addInterest() {
        // addInterest() for a checking account is just to improve transparency of
    }

    @Override
    public String toString() {
        return "Checkings account " + accountNumber + " : balance = " + balance + " is " + (isForeign ? "Foreign" : "Domestic");
    }
}
