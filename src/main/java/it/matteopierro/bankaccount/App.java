package it.matteopierro.bankaccount;

public class App {
    public static void main(String[] args) {
        Account account = AccountFactory.getInstanceWith(new Clock(), new Console());

        account.deposit(1000);
        account.withdrawal(200);
        account.deposit(300);

        account.printStatement();
    }
}
