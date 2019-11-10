package it.matteopierro.bankaccount.feature;

import it.matteopierro.bankaccount.Transaction;
import it.matteopierro.bankaccount.Transactions;

import java.util.List;

public class InMemoryTransactions implements Transactions {
    @Override
    public void add(Transaction transaction) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Transaction> all() {
        throw new UnsupportedOperationException();
    }
}
