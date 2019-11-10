package it.matteopierro.bankaccount.feature;

import it.matteopierro.bankaccount.Transaction;
import it.matteopierro.bankaccount.Transactions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static it.matteopierro.bankaccount.TransactionBuilder.aTransaction;
import static org.assertj.core.api.Assertions.assertThat;

class InMemoryTransactionsTest {
    private Transactions transactions;

    @BeforeEach
    void setUp() {
        transactions = new InMemoryTransactions();
    }

    @Test
    void it_stores_transactions() {
        Transaction firstTransaction = aTransaction().build();
        Transaction secondTransaction = aTransaction().build();
        transactions.add(firstTransaction);
        transactions.add(secondTransaction);

        assertThat(transactions.all()).contains(firstTransaction, secondTransaction);
    }
}