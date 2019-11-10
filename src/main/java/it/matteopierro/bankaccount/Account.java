package it.matteopierro.bankaccount;

public class Account {
    private final Ledger ledger;
    private final StatementPrinter statementPrinter;

    public Account(Ledger ledger, StatementPrinter statementPrinter) {
        this.ledger = ledger;
        this.statementPrinter = statementPrinter;
    }

    public void deposit(int amount) {
        ledger.addDeposit(amount);
    }

    public void withdrawal(int amount) {
        ledger.addWithdrawal(amount);
    }

    public void printStatement() {
        statementPrinter.print(ledger.allTransactions());
    }
}
