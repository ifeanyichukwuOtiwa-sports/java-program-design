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
    public void addInterest() {
        // do nothing
    }

    @Override
    public String toString() {
        return "Regular Checkings account " + accountNumber + " : balance = " + balance + " is " + (isForeign ? "Foreign" :
                "Domestic");
    }
}
