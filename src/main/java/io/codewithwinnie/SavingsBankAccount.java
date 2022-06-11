package io.codewithwinnie;

public class SavingsBankAccount extends AbstractBankAccount {

    private static final double RATE = 0.1;

    public SavingsBankAccount(final int accountNumber) {
        super(accountNumber);
        this.accountNumber = accountNumber;
    }

    @Override
    public boolean hasEnoughCollateral(final int loanAmt) {
        return (balance >= loanAmt / 2);
    }

    @Override
    public void addInterest() {
        addInterest(RATE);
    }

    private void addInterest(final double rate) {
        this.setBalance(this.balance  + (int) (this.balance * (rate)));
    }

    @Override
    public String toString() {
        return "Savings account " + accountNumber + " : balance = " + balance + " is " + (isForeign ? "Foreign" : "Domestic");
    }
}
