package it.matteopierro.bankaccount;

import it.matteopierro.bankaccount.feature.InMemoryTransactions;

public class AccountFactory {
    public static Account getInstanceWith(Clock clock, Console console) {
        Transactions transactions = new InMemoryTransactions();
        Ledger ledger = new Ledger(clock, transactions);
        StatementPrinter statementPrinter = new StatementPrinter(console);
        return new Account(ledger, statementPrinter);
    }
}
