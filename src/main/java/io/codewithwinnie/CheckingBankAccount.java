package io.codewithwinnie;

/**
 * Created by @author Ifeanyichukwu Otiwa
 * 09/05/2022
 */

public class CheckingBankAccount extends  AbstractBankAccount {

    public CheckingBankAccount(Integer acctNumber) {
        super(acctNumber);
        this.accountNumber = acctNumber;
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
