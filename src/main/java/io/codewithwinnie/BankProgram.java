package io.codewithwinnie;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BankProgram {
    private static final Logger LOG = LoggerFactory.getLogger(BankProgram.class);
    private final Map<Integer, Integer> accounts = new HashMap<>();

    private final double rate = 0.01;
    private int nextAcct = 0;
    private int current = -1;
    private Scanner scanner;
    private boolean done = false;


    public static void main(String[] args) {
        BankProgram program = new BankProgram();
        program.run();
    }

    private void run() {
        scanner = new Scanner(System.in);

        while (!done) {
            LOG.info("Enter command (\n\t0=quit \n\t1=new \n\t2=select " +
                    "\n\t3=deposit \n\t4=loan \n\t5=show \n\t6=interest\n): ");
            int cmd = scanner.nextInt();
            processCommand(cmd);
        }
        scanner.close();
    }

    private void processCommand(final int cmd) {
        if (cmd == 0) quit();
        else if (cmd == 1) newAccount();
        else if (cmd == 2) select();
        else if (cmd == 3) deposit();
        else if (cmd == 4) authorizeLoan();
        else if (cmd == 5) showAll();
        else if (cmd == 6) addInterest();
        else LOG.info("Illegal Command");
    }

    private void addInterest() {
        Set<Integer> accts = accounts.keySet();

        for (Integer acct: accts) {
            int balance = accounts.get(acct);
            int newBalance = (int) (balance + (rate * balance));
            accounts.put(acct, newBalance);
        }
    }

    private void showAll() {
        Set<Integer> accts = accounts.keySet();

        for (Integer acct: accts) {
            LOG.info("The bank has {} accounts.", accounts.size());
            LOG.info("\tBank account {}: balance =  {}", acct, accounts.get(acct));
        }
    }

    private void authorizeLoan() {
        LOG.info("Enter loan amount: ");
        int loanAmt = scanner.nextInt();
        int balance = accounts.get(current);
        if (balance >= loanAmt / 2)
            LOG.info("Your loan is approved");
        else
            LOG.info("Your loan is denied");
    }

    private void deposit() {
        LOG.info("Enter amount: ");
        int amount = scanner.nextInt();
        int balance = accounts.get(current);
        accounts.put(current, balance + amount);
    }

    private void select() {
        LOG.info("Enter account Number: ");
        current = scanner.nextInt();
        int balance = accounts.get(current);
        LOG.info("Your balance is {}", balance);
    }

    private void newAccount() {
        current = nextAcct++;
        accounts.put(current, 0);
        LOG.info("Your new account number is {}", current);
    }

    private void quit() {
        done = true;
        LOG.info("Good Bye!");
    }
}