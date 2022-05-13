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

    @Override
    public int compareTo(final BankAccount ba) {
        int bal1 = getBalance();
        int bal2 = ba.getBalance();
        if (bal1 == bal2) {
            return getAccountNumber() - ba.getAccountNumber();
        } else {
            return bal1 - bal2;
        }
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final CheckingBankAccount that = (CheckingBankAccount) o;

        if (accountNumber != that.accountNumber) return false;
        if (balance != that.balance) return false;
        return isForeign == that.isForeign;
    }

    @Override
    public int hashCode() {
        int result = accountNumber;
        result = 31 * result + balance;
        result = 31 * result + (isForeign ? 1 : 0);
        return result;
    }
}
