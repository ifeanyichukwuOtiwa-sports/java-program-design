package io.codewithwinnie.commandstrategy.impl;

import java.util.Scanner;

import io.codewithwinnie.Bank;
import io.codewithwinnie.commandstrategy.intface.InputCommand;

/**
 * Created by @author Ifeanyichukwu Otiwa
 * 27/06/2022
 */

public class SetForeignCmd implements InputCommand {
    @Override
    public int execute(final Scanner scanner, final Bank bank, final int current) {
        System.out.println("Enter \n\t1 for Foreign\n\t2 for domestic");
        int val = scanner.nextInt();
        bank.setForeign(current, val == 1);
        return current;
    }
}
