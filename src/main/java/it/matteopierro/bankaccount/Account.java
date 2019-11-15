package it.matteopierro.bankaccount;

public class Account {
    private final Ledger ledger;

    public Account(Ledger ledger) {
        this.ledger = ledger;
    }

    public void printStatement() {
        throw new UnsupportedOperationException();
    }

    public void deposit(int amount) {
        ledger.addDeposit(amount);
    }

    public void withdrawal(int amount) {
        throw new UnsupportedOperationException();
    }
}
