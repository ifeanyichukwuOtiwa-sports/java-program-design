package io.codewithwinnie;


import java.util.Map;
import java.util.Scanner;

public class BankProgram {

    public static void main(String[] args) {
        SavedBankInfo info = new SavedBankInfo("bank.info");
        Map<Integer, BankAccount> accounts = info.getAccounts();
        int nextAcct = info.getNextAcctNum();
        Bank bank = new Bank(accounts, nextAcct);
        Scanner scanner = new Scanner(System.in);
        BankClient client = new BankClient(scanner, bank);
        client.run();
        info.saveMap(accounts, bank.getNextAcctNum());
    }
}