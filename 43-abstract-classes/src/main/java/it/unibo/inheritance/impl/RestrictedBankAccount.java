package it.unibo.inheritance.impl;

import it.unibo.inheritance.api.AccountHolder;

public class RestrictedBankAccount extends AbstractBankAccount {

    public RestrictedBankAccount(final AccountHolder holder, final double balance) {
        super(holder, balance);
    }

    public void withdraw(final int id, final double amount) {
        if (this.isWithdrawAllowed(amount)) {
            super.withdraw(id, amount);
        }      
    }

    public void withdrawFromATM(final int id, final double amount) {
        if (this.isWithdrawAllowed(amount + ATM_TRANSACTION_FEE)) {
            super.withdrawFromATM(id, amount);
        }
    }

    protected boolean isWithdrawAllowed(final double amount) {
        return this.getBalance() >= amount;
    }

    protected double computeFee() {
        return MANAGEMENT_FEE * (this.getTransactionsCount() * TRANSACTION_FEE);
    }

    public void chargeManagementFees(int id) {
        final double feeAmount = MANAGEMENT_FEE + getTransactionsCount() * TRANSACTION_FEE;
        if (checkUser(id) && isWithdrawAllowed(feeAmount)) {
            setBalance(getBalance() - feeAmount);
            resetTransactions();
        }
    }
}