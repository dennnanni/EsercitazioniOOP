package it.unibo.inheritance.impl;

import it.unibo.inheritance.api.AccountHolder;
import it.unibo.inheritance.api.BankAccount;

public abstract class AbstractBankAccount implements BankAccount {

    public static final double ATM_TRANSACTION_FEE = 1;
    public static final double MANAGEMENT_FEE = 5;
    public static final double TRANSACTION_FEE = 0.1;

    private final AccountHolder holder;
    private double balance;
    private int transactions;

    public AbstractBankAccount(final AccountHolder holder, final double balance) {
        this.holder = holder;
        this.balance = balance;
        this.transactions = 0;
    }

    public AccountHolder getAccountHolder() {
        return this.holder;
    }

    public double getBalance() {
        return this.balance;
    }

    protected void setBalance(final double balance) {
        this.balance = balance;
    }

    public int getTransactionsCount() {
        return this.transactions;
    }

    public void deposit(final int id, final double amount) {
        this.transactionOp(id, amount);
    }

    public void depositFromATM(final int id, final double amount) {
        this.deposit(id, amount - ATM_TRANSACTION_FEE);
    }

    public void withdraw(final int id, final double amount) {
        this.transactionOp(id, -amount);
    }

    public void withdrawFromATM(int id, double amount) {
        this.withdraw(id, amount + ATM_TRANSACTION_FEE);
    }

    protected boolean checkUser(final int id) {
        return this.holder.getUserID() == id;
    }

    protected void incrementTransactions() {
        this.transactions++;
    }

    protected void resetTransactions() {
        this.transactions = 0;
    }

    protected void transactionOp(final int id, final double amount) {
        if (checkUser(id)) {
            this.balance += amount;
            this.incrementTransactions();
        }
    }

    protected abstract boolean isWithdrawAllowed(final double amount);

    protected abstract double computeFee();
}