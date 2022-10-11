package it.unibo.encapsulation.interfaces;

public class StrictBankAccount implements BankAccount {

    private static int ATM_TRANSACTION_FEE = 1;
    private static int MANAGEMENT_FEE = 5;
    private static double PER_TRANSACTION_FEE = 0.1;

    private int id;
    private int transactions;
    private double balance;

    public StrictBankAccount(final int id, final double balance) { 
        this.id = id;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public double getBalance() {
        return this.balance;
    }

    public int getTransactionsCount() {
        return this.transactions;
    }

    public void withdraw(final int id, final double amount) {
        if (this.id != id) {
            return;
        }

        if (this.balance - amount < 0) {
            return;
        }

        this.transactions++;
        this.balance -= amount;
    }

    public void deposit(final int id, final double amount) {
        if (this.id != id) {
            return;
        }

        this.transactions++;
        this.balance += amount;
    }

    public void depositFromATM(final int id, final double amount) {
        if (this.id != id) {
            return;
        }

        this.transactions++;
        this.balance += amount - ATM_TRANSACTION_FEE;
    }

    public void withdrawFromATM(final int id, final double amount) {
        if (this.id != id) {
            return;
        }

        if (this.balance - amount - ATM_TRANSACTION_FEE < 0) {
            return;
        }

        this.transactions++;
        this.balance = this.balance - amount - ATM_TRANSACTION_FEE;
    }

    public void chargeManagementFees(final int id) {
        this.balance = this.balance - MANAGEMENT_FEE - PER_TRANSACTION_FEE * this.transactions;
    }
    
}
