package io.codewithwinnie.commandstrategy.impl;

import java.util.Scanner;

import io.codewithwinnie.Bank;
import io.codewithwinnie.commandstrategy.intface.InputCommand;

/**
 * Created by @author Ifeanyichukwu Otiwa
 * 25/06/2022
 */

public class SelectCmd implements InputCommand {
    @Override
    public int execute(final Scanner scanner, final Bank bank, int current) {
        System.out.println("Enter account number: ");
        final int curr = scanner.nextInt();
        int balance = bank.getBalance(curr);
        System.out.println("the balance of " + curr + " is " + balance);
        return curr;
    }

    @Override
    public String toString() {
        return "Select";
    }
}
