package io.codewithwinnie;

/**
 * Created by @author Ifeanyichukwu Otiwa
 * 09/05/2022
 */

public abstract class CheckingBankAccount extends  AbstractBankAccount {

    protected CheckingBankAccount(Integer acctNumber) {
        super(acctNumber);
        this.accountNumber = acctNumber;
    }

    @Override
    public boolean hasEnoughCollateral(final int loanAmt) {
        return balance >= ((2 * loanAmt) / 3);
    }

    public abstract String toString();
}
