package io.codewithwinnie.commandstrategy.intface;

import java.util.Scanner;

import io.codewithwinnie.Bank;

@FunctionalInterface
public interface InputCommand {
    public int execute(Scanner scanner, Bank bank, int current);
}
