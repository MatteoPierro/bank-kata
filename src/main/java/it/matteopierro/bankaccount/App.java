package it.matteopierro.bankaccount;

public class App {
    public static void main(String[] args) {
        Account account = new Account(new Ledger(), new StatementPrinter());

        account.deposit(1000);
        account.withdrawal(200);
        account.deposit(300);

        account.printStatement();
    }
}
