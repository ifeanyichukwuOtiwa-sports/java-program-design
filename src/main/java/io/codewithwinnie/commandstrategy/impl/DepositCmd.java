package io.codewithwinnie.commandstrategy.impl;

import java.util.Scanner;

import io.codewithwinnie.Bank;
import io.codewithwinnie.commandstrategy.intface.InputCommand;

/**
 * Created by @author Ifeanyichukwu Otiwa
 * 25/06/2022
 */

public class DepositCmd implements InputCommand {
    @Override
    public int execute(final Scanner scanner, final Bank bank, final int current) {
        System.out.println("Enter Deposit Amount: ");
        int amt = scanner.nextInt();
        bank.deposit(current, amt);
        System.out.println("Credit Alert\nYour current balance is " + bank.getBalance(current));
        return current;
    }

    @Override
    public String toString() {
        return "Deposit";
    }
}
