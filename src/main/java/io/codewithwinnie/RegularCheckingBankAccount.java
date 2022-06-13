package io.codewithwinnie;

/**
 * Created by @author Ifeanyichukwu Otiwa
 * 11/06/2022
 */

public class RegularCheckingBankAccount extends CheckingBankAccount {
    public RegularCheckingBankAccount(final Integer acctNumber) {
        super(acctNumber);
    }

    @Override
    protected double interestRate() {
        return 0.0;
    }

    @Override
    protected String getAccountType() {
        return "Regular";
    }

}
