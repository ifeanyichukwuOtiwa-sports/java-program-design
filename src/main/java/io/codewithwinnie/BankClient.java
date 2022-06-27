package io.codewithwinnie;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.codewithwinnie.commandstrategy.impl.AddInterestCmd;
import io.codewithwinnie.commandstrategy.impl.AuthorizeLoanCmd;
import io.codewithwinnie.commandstrategy.impl.DepositCmd;
import io.codewithwinnie.commandstrategy.impl.NewCmd;
import io.codewithwinnie.commandstrategy.impl.QuitCmd;
import io.codewithwinnie.commandstrategy.impl.SelectCmd;
import io.codewithwinnie.commandstrategy.impl.SetForeignCmd;
import io.codewithwinnie.commandstrategy.impl.ShowAllCmd;
import io.codewithwinnie.commandstrategy.intface.InputCommand;

public class BankClient {
    private static final Logger LOG = LoggerFactory.getLogger(BankClient.class);

    private int current = -1;
    private final Scanner scanner;
    private boolean done = false;
    private final Bank bank;
    private static final InputCommand[] commands = {
            new QuitCmd(),
            new NewCmd(),
            new SelectCmd(),
            new DepositCmd(),
            new AuthorizeLoanCmd(),
            new ShowAllCmd(),
            new AddInterestCmd(),
            new SetForeignCmd()
    };

    public BankClient(Scanner scanner, Bank bank) {
        this.bank = bank;
        this.scanner = scanner;
    }

    public void run() {
        while (!done) {
            if(bank.getAccounts().size() > 0 && bank.getNextAcctNum() > 0) {
                LOG.info("Enter command (\n\t0=quit \n\t1=new \n\t2=select " +
                        "\n\t3=deposit \n\t4=loan \n\t5=show \n\t6=interest \n\t7=Set Foreign\n): ");
                int cmd = scanner.nextInt();
                processCommand(cmd);

            } else {
                LOG.info("No accounts yet");
                LOG.info("Enter command (\n\t0=quit \n\t1=new");
                int cmd = scanner.nextInt();
                processCommand(cmd);

            }
        }

        scanner.close();
    }

    private void processCommand(final int cnum) {
        InputCommand cmd = commands[cnum];
        current = cmd.execute(scanner, bank, current);
        if (current < 0) {
            done = true;
        }
    }

    @Deprecated(forRemoval = true, since = "BP-10010")
    private void setForeign() {
        bank.setForeign(current, requestForeign());
    }

    @Deprecated(forRemoval = true, since = "BP-10010")
    private boolean requestForeign() {
        System.out.println("Enter \n\t1 for Foreign\n\t2 for domestic");
        int val = scanner.nextInt();
        return val == 1;
    }

    @Deprecated(forRemoval = true, since = "BP-10010")
    private void addInterest() {
        bank.addInterest();
    }

    @Deprecated(forRemoval = true, since = "BP-10010")
    private void showAll() {
        System.out.println(bank.toString());
    }

    @Deprecated(forRemoval = true, since = "BP-10010")
    private void authorizeLoan() {
        LOG.info("Enter loan amount: ");
        int loanAmt = scanner.nextInt();
        if (bank.authorizeLoan(loanAmt, current))
            LOG.info("Your loan is approved");
        else
            LOG.info("Your loan is denied");
    }

    /**
     * replaced with @link{DepositCmd}
     */
    @Deprecated(forRemoval = true, since = "BP-10010")
    private void deposit() {
        System.out.println("Enter Deposit Amount: ");
        int amt = scanner.nextInt();
        bank.deposit(current, amt);
        System.out.println("Credit Alert\nYour current balance is " + bank.getBalance(current));
    }

    @Deprecated(forRemoval = true, since = "BP-10010")
    private void select() {
        System.out.println("Enter account number: ");
        current = scanner.nextInt();
        int balance = bank.getBalance(current);
        System.out.println("the balance of " + current + " is " + balance);
    }

    @Deprecated(forRemoval = true, since = "BP-10010")
    private void newAccount() {
        boolean isForeign = requestForeign();
        int type  = requestType();
        current = bank.newAccount(type, isForeign);
        System.out.println("Your new account Number is " + current );
    }

    @Deprecated(forRemoval = true, since = "BP-10010")
    private int requestType() {
        System.out.println("Enter \n\t1 Savings\n\t2 Regular Checking\n\t3 Interest Checking");
        return scanner.nextInt();
    }


    @Deprecated(forRemoval = true, since = "BP-10010")
    private void quit() {
        done = true;
        LOG.info("Good Bye!");
    }

}
