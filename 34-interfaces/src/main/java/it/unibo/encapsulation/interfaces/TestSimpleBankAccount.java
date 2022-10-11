package it.unibo.encapsulation.interfaces;

public class TestSimpleBankAccount {

    private TestSimpleBankAccount() {
        /*
         * Prevents object creation from the outside.
         */
    }

    public static void main(final String[] args) {
        // 1) Creare l' AccountHolder relativo a Andrea Rossi con id 1
        AccountHolder holder1 = new AccountHolder("Andrea", "Rossi", 1);

        // 2) Creare l' AccountHolder relativo a Alex Bianchi con id 2
        AccountHolder holder2 = new AccountHolder("Alex", "Bianchi", 2);

        // 3) Creare i due SimpleBankAccount corrispondenti
        SimpleBankAccount account1 = new SimpleBankAccount(holder1.getUserID(), 0);
        SimpleBankAccount account2 = new SimpleBankAccount(holder2.getUserID(), 0);

        // 4) Effettuare una serie di depositi e prelievi
        account1.deposit(holder1.getUserID(), 100);
        account2.deposit(holder2.getUserID(), 1000);
        account2.withdraw(holder2.getUserID(), 100);
        account1.depositFromATM(holder1.getUserID(), 600);
        account2.withdrawFromATM(holder2.getUserID(), 150);

        /*
         * 5) Stampare a video l'ammontare dei due conti e verificare la
         * correttezza del risultato
         */

        System.out.println("Account1 balance: " + account1.getBalance());
        System.out.println("Account2 balance: " + account2.getBalance());

        // 6) Provare a prelevare fornendo un id utente sbagliato
        account1.withdraw(holder2.getUserID(), 50);

        // 7) Controllare nuovamente l'ammontare
        System.out.println("Account1 balance: " + account1.getBalance());
    }
}
