package it.matteopierro.bankaccount;

import java.util.List;

public interface Transactions {
    void add(Transaction transaction);
    List<Transaction> all();
}
