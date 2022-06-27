package io.codewithwinnie.commandstrategy.impl;

import java.util.Scanner;

import io.codewithwinnie.Bank;
import io.codewithwinnie.commandstrategy.intface.InputCommand;

/**
 * Created by @author Ifeanyichukwu Otiwa
 * 25/06/2022
 */

public class NewCmd implements InputCommand {
    @Override
    public int execute(final Scanner scanner, final Bank bank, int current) {
        System.out.println("Enter \n\t1 for Foreign\n\t2 for domestic");
        boolean isForeign = scanner.nextInt() == 1;
        System.out.println("Enter \n\t1 Savings\n\t2 Regular Checking\n\t3 Interest Checking");
        int type  = scanner.nextInt();
        current = bank.newAccount(type, isForeign);
        System.out.println("Your new account Number is " + current );
        return current;
    }

}
