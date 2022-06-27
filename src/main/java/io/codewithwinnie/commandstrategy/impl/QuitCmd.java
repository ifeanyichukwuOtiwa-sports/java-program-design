package io.codewithwinnie.commandstrategy.impl;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.codewithwinnie.Bank;
import io.codewithwinnie.commandstrategy.intface.InputCommand;

/**
 * Created by @author Ifeanyichukwu Otiwa
 * 25/06/2022
 */

public class QuitCmd implements InputCommand {
    private static final Logger LOG = LoggerFactory.getLogger(QuitCmd.class);
    @Override
    public int execute(final Scanner scanner, final Bank bank, final int current) {
        LOG.info("Good Bye!");
        return -1;
    }
}
