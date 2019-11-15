package it.matteopierro.bankaccount;

import java.util.List;

public class Account {
    private final Ledger ledger;
    private final StatementPrinter statementPrinter;

    public Account(Ledger ledger, StatementPrinter statementPrinter) {
        this.ledger = ledger;
        this.statementPrinter = statementPrinter;
    }

    public void printStatement() {
        List<Transaction> transactions = ledger.getTransactions();
        statementPrinter.print(transactions);
    }

    public void deposit(int amount) {
        ledger.addDeposit(amount);
    }

    public void withdrawal(int amount) {
        ledger.addWithdrawal(amount);
    }
}
