package io.codewithwinnie;

public interface BankAccount {
    int getAccountNumber();

    int getBalance();

    boolean isForeign();

    void setBalance(int balance);

    void setAccountNumber(int accountNumber);

    void setForeign(boolean foreign);

    void deposit(int amt);

    boolean hasEnoughCollateral(int loanAmt);

    @Override
    String toString();
}
