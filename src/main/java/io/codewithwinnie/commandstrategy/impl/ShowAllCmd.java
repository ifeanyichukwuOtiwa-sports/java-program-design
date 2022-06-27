package io.codewithwinnie.commandstrategy.impl;

import java.util.Scanner;

import io.codewithwinnie.Bank;
import io.codewithwinnie.commandstrategy.intface.InputCommand;

/**
 * Created by @author Ifeanyichukwu Otiwa
 * 27/06/2022
 */

public class ShowAllCmd implements InputCommand {
    @Override
    public int execute(final Scanner scanner, final Bank bank, final int current) {
        System.out.println(bank.toString());
        return current;
    }
}
