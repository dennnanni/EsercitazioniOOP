package it.unibo.encapsulation.interfaces;

public class TestBankAccount {

    private TestBankAccount() {
        
    }

    public static void main(final String[] args) {
        /*
         * 1) Creare l' AccountHolder relativo a Andrea Rossi con id 1
         */
        /*
         * 2) Creare l' AccountHolder relativo a Alex Bianchi con id 2
         */
        /*
         * 3) Dichiarare due variabili di tipo BankAccount ed inizializzarle,
         * rispettivamente, con oggetti di tipo SimpleBankAccount per il conto di
         * Rossi (ammontare iniziale = 0), e di tipo StrictBankAccount per il conto di
         * Bianchi (ammontare iniziale = 0)
         */
        /*
         * 4) Prima riflessione: perché è stato possibile fare la new di due classi
         * diverse in variabili dello stesso tipo?
         */
        /*
         * 5) Depositare €10000 in entrambi i conti
         */
        /*
         * 6) Prelevare €15000$ da entrambi i conti
         */
        /*
         * 7) Stampare in stdout l'ammontare corrente
         */
        /*
         * 8) Qual è il risultato e perché?
         */
        /*
         * 9) Depositare nuovamente €10000 in entrambi i conti
         */
        /*
         * 10) Invocare il metodo computeManagementFees su entrambi i conti
         */
        /*
         * 11) Stampare a video l'ammontare corrente
         */
        /*
         * 12) Qual è il risultato e perché?
         */

        AccountHolder holder1 = new AccountHolder("Andrea", "Rossi", 1);

        AccountHolder holder2 = new AccountHolder("Alex", "Bianchi", 2);

        BankAccount account1 = new SimpleBankAccount(holder1.getUserID(), 0);
        BankAccount account2 = new StrictBankAccount(holder2.getUserID(), 0);

        account1.deposit(holder1.getUserID(), 10000);
        account2.deposit(holder2.getUserID(), 10000);

        account1.withdraw(holder1.getUserID(), 15000);
        account2.withdraw(holder2.getUserID(), 15000);

        System.out.println("Account1 balance: " + account1.getBalance());
        System.out.println("Account2 balance: " + account2.getBalance());

        account1.deposit(holder1.getUserID(), 10000);
        account2.deposit(holder2.getUserID(), 10000);

        account1.chargeManagementFees(holder1.getUserID());
        account2.chargeManagementFees(holder2.getUserID());

        System.out.println("Account1 balance: " + account1.getBalance());
        System.out.println("Account2 balance: " + account2.getBalance());
    }
}
