package it.matteopierro.bankaccount;

import java.time.LocalDate;
import java.util.List;

public class Ledger {
    private final Clock clock;
    private final Transactions transactions;

    public Ledger(Clock clock, Transactions transactions) {
        this.clock = clock;
        this.transactions = transactions;
    }

    public void addDeposit(int amount) {
        LocalDate today = clock.today();
        transactions.add(new Transaction(today, amount));
    }

    public void addWithdrawal(int amount) {
        LocalDate today = clock.today();
        transactions.add(new Transaction(today, -amount));
    }

    public List<Transaction> allTransactions() {
        return transactions.all();
    }
}
