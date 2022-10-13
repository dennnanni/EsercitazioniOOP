package it.unibo.inheritance.impl;

import it.unibo.inheritance.api.AccountHolder;

public class ClassicBankAccount extends AbstractBankAccount {

    public ClassicBankAccount(final AccountHolder holder, final double balance) {
        super(holder, balance);
    }

    protected boolean isWithdrawAllowed(final double amount) { 
        return true;
    }

    protected double computeFee() {
        return MANAGEMENT_FEE;
    }

    public void chargeManagementFees(int id) {
        this.setBalance(this.getBalance() - MANAGEMENT_FEE);
        this.resetTransactions();
    }

}