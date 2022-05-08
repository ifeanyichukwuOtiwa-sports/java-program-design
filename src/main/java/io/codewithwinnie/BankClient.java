package io.codewithwinnie;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BankClient {
    private static final Logger LOG = LoggerFactory.getLogger(BankClient.class);

    private int current = -1;
    private Scanner scanner;
    private boolean done = false;
    private Bank bank = new Bank();

    public void run() {
        scanner = new Scanner(System.in);

        while (!done) {
            LOG.info("Enter command (\n\t0=quit \n\t1=new \n\t2=select " +
                    "\n\t3=deposit \n\t4=loan \n\t5=show \n\t6=interest \n\t7=Set Foreign\n): ");
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
        else if (cmd == 7) setForeign();
        else LOG.info("Illegal Command");
    }

    private void setForeign() {
        bank.setForeign(current, requestForeign());
    }

    private boolean requestForeign() {
        System.out.println("Enter \n\t1 for Foreign\n\t2 for domestic");
        int val = scanner.nextInt();
        return val == 1;
    }

    private void addInterest() {
        bank.addInterest();
    }

    private void showAll() {
        System.out.println(bank.toString());
    }

    private void authorizeLoan() {
        LOG.info("Enter loan amount: ");
        int loanAmt = scanner.nextInt();
        if (bank.authorizeLoan(loanAmt, current))
            LOG.info("Your loan is approved");
        else
            LOG.info("Your loan is denied");
    }

    private void deposit() {
        System.out.println("Enter Deposit Amount: ");
        int amt = scanner.nextInt();
        bank.deposit(current, amt);
        System.out.println("Credit Alert\nYour current balance is " + bank.getBalance(current));
    }

    private void select() {
        System.out.println("Enter account number: ");
        current = scanner.nextInt();
        int balance = bank.getBalance(current);
        System.out.println("the balance of " + current + " is " + balance);
    }

    private void newAccount() {
        boolean isForeign = requestForeign();
        current = bank.newAccount(isForeign);
        System.out.println("Your new account Number is " + current );
    }


    private void quit() {
        done = true;
        LOG.info("Good Bye!");
    }

}