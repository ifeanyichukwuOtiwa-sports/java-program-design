package io.codewithwinnie;

/**
 * Created by @author Ifeanyichukwu Otiwa
 * 11/06/2022
 */

public abstract class AbstractBankAccount implements BankAccount {
    protected int accountNumber;
    protected int balance = 0;
    protected boolean isForeign = false;

    private OwnerStrategy ownerStrategy = new Domestic();


    protected AbstractBankAccount(final int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public int getBalance() {
        return balance;
    }

    public boolean isForeign() {
        return ownerStrategy.isForeign();
    }

    public void setBalance(final int balance) {
        this.balance = balance;
    }

    public void setAccountNumber(final int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setForeign(final boolean foreign) {
        this.ownerStrategy = foreign ? new Foreign() : new Domestic();
    }

    public void deposit(int amt) {
        balance += amt;
    }

    public int fee() {
        return ownerStrategy.fee();
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
    public int hashCode() {
        int result = accountNumber;
        result = 31 * result + balance;
        return result;
    }

    @Override
    public boolean equals(final Object o) {
        if (!(o instanceof BankAccount)) {
            return false;
        }
        final BankAccount that = (BankAccount) o;

        if (isForeign != that.isForeign()) return false;
        if (balance != that.getBalance()) return false;
        return accountNumber != that.getAccountNumber();
    }

    @Override
    public boolean hasEnoughCollateral(final int loanAmt) {
        double ratio = collateralRatio();
        return balance >= loanAmt * ratio;
    }

    public String toString() {
        return getAccountType() + " account " + accountNumber + " Balance: " + balance + " Foreign: " + ownerStrategy.isForeign()
                + " Fee: " + ownerStrategy.fee();
    }

    @Override
    public void addInterest() {
        balance += balance * interestRate();
    }

    protected abstract double interestRate();

    protected abstract double collateralRatio();

    protected abstract String getAccountType();

}
