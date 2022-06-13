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
    protected double interestRate() {
        return RATE;
    }

    @Override
    protected String getAccountType() {
        return "Interest Checking";
    }
}
