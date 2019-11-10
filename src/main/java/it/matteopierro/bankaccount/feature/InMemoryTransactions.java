package it.matteopierro.bankaccount.feature;

import it.matteopierro.bankaccount.Transaction;
import it.matteopierro.bankaccount.Transactions;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.unmodifiableList;

public class InMemoryTransactions implements Transactions {
    private List<Transaction> transactions = new ArrayList<>();

    @Override
    public void add(Transaction transaction) {
        transactions.add(transaction);
    }

    @Override
    public List<Transaction> all() {
        return unmodifiableList(transactions);
    }
}
