package it.matteopierro.bankaccount;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;

import static it.matteopierro.bankaccount.TransactionBuilder.aTransaction;
import static java.time.Month.SEPTEMBER;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class LedgerTest {
    private static final LocalDate TODAY = LocalDate.of(2019, SEPTEMBER, 12);
    private static final int AN_AMOUNT = 200;

    @Mock
    private Transactions transactions;
    @Mock
    private Clock clock;

    private Ledger ledger;

    @BeforeEach
    void setUp() {
        ledger = new Ledger(clock, transactions);
    }

    @Test
    void it_saves_a_deposit_transaction_with_a_date() {
        given(clock.today()).willReturn(TODAY);

        ledger.addDeposit(AN_AMOUNT);

        verify(transactions).add(
                aTransaction()
                        .withDate(TODAY)
                        .withAmount(AN_AMOUNT)
                        .build()
        );
    }

    @Test
    void it_saves_a_withdrawal_transaction_with_a_data() {
        given(clock.today()).willReturn(TODAY);

        ledger.addWithdrawal(AN_AMOUNT);

        verify(transactions).add(
                aTransaction()
                        .withDate(TODAY)
                        .withAmount(- AN_AMOUNT)
                        .build()
        );
    }

    @Test
    void it_returns_all_transactions() {
        Transaction firstTransaction = aTransaction().withAmount(100).build();
        Transaction secondTransaction = aTransaction().withAmount(200).build();
        given(transactions.all()).willReturn(asList(firstTransaction, secondTransaction));

        List<Transaction> transactions = ledger.allTransactions();

        assertThat(transactions).containsExactly(firstTransaction, secondTransaction);
    }
}