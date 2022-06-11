package io.codewithwinnie;


/**
 * Created by @author Ifeanyichukwu Otiwa
 * 11/06/2022
 */

public class InterestCheckingBankAccount extends CheckingBankAccount{

    private static final double RATE = 0.01;

    public InterestCheckingBankAccount(final Integer acctNumber) {
        super(acctNumber);
    }

    @Override
    public String toString() {
        return "Savings account " + accountNumber + " : balance = " + balance + " is " + (isForeign ? "Foreign" : "Domestic");
    }

    @Override
    public void addInterest() {
        int newBalance = (int) (balance * RATE);
        deposit(newBalance);
    }
}
