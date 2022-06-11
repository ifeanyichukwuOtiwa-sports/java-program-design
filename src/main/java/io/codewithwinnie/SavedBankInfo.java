package io.codewithwinnie;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by @author Ifeanyichukwu Otiwa
 * 11/06/2022
 */

public class SavedBankInfo {
    private String fileName;
    private int nextAcctNum = 0;

    private ByteBuffer byteBuffer = ByteBuffer.allocate(16);
    private Map<Integer, BankAccount> accounts = new HashMap<>();

    public SavedBankInfo(final String fileName) {
        this.fileName = fileName;
        File file = new File(fileName);
        if (!file.exists())
            return;
        try (InputStream is = new FileInputStream(file)) {
            readMap(is);
        } catch (IOException e) {
            throw new RuntimeException("file read exception");
        }
    }

    public Map<Integer, BankAccount> getAccounts() {
        return accounts;
    }

    public int getNextAcctNum() {
        return this.nextAcctNum;
    }

    public void saveMap(final Map<Integer, BankAccount> accounts, final int nextAcctNum) {
        try(OutputStream os = new FileOutputStream(fileName)) {
            writeMap(os, accounts, nextAcctNum);
        } catch (IOException e) {
            throw new RuntimeException("file write exception");
        }
    }

    private void writeMap(final OutputStream os, final Map<Integer, BankAccount> accounts, final int nextAcctNum) throws IOException {
        writeInts(os, nextAcctNum);
        for (BankAccount ba: accounts.values()) {
            writeAccount(os, ba);
        }
    }

    @SuppressWarnings("all")
    private void writeAccount(final OutputStream os, final BankAccount ba) throws IOException {
        int type = (ba instanceof SavingsBankAccount) ? 1 : (ba instanceof RegularCheckingBankAccount) ? 2 : 3;
        byteBuffer.putInt(0, ba.getAccountNumber());
        byteBuffer.putInt(4, type);
        byteBuffer.putInt(8, ba.getBalance());
        byteBuffer.putInt(12, ba.isForeign() ? 1 : 2);
        os.write(byteBuffer.array());
    }

    private void writeInts(final OutputStream os, final int nextAcctNum) throws IOException {
        byteBuffer.putInt(0, nextAcctNum);
        os.write(byteBuffer.array(), 0, 4);
    }

    private void readMap(final InputStream is) throws IOException {
        nextAcctNum = readInts(is);
        BankAccount ba = readAccount(is);
        while (ba != null) {
            accounts.put(ba.getAccountNumber(), ba);
            ba = readAccount(is);
        }
    }

    private BankAccount readAccount(final InputStream is) throws IOException {
        int n = is.read(byteBuffer.array());
        if (n < 0) {
            return null;
        }

        int acctNum = byteBuffer.getInt(0);
        int type = byteBuffer.getInt(4);
        int balance = byteBuffer.getInt(8);
        int isForeign = byteBuffer.getInt(12);

        BankAccount ba;

        if (type == 1) {
            ba = new SavingsBankAccount(acctNum);
        } else if (type == 2) {
            ba = new RegularCheckingBankAccount(acctNum);
        } else {
            ba = new InterestCheckingBankAccount(acctNum);
        }
        ba.deposit(balance);
        ba.setForeign(isForeign == 1);
        return ba;
    }

    @SuppressWarnings("all")
    private int readInts(final InputStream is) throws IOException {
        is.read(byteBuffer.array(), 0, 4);
          return byteBuffer.getInt(0);
    }
}
