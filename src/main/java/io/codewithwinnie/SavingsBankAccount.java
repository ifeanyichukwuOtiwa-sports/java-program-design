package io.codewithwinnie;

public class SavingsBankAccount extends AbstractBankAccount {


    public SavingsBankAccount(final int accountNumber) {
        super(accountNumber);
        this.accountNumber = accountNumber;
    }


    @Override
    protected double interestRate() {
        return 0.1;
    }

    @Override
    protected double collateralRatio() {
        return 0.1 / 0.2;
    }

    @Override
    protected String getAccountType() {
        return "Savings";
    }

}
