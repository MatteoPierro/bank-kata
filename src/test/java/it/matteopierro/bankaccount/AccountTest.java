package it.matteopierro.bankaccount;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static java.util.Collections.singletonList;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class AccountTest {
    private static final int AN_AMOUNT = 100;
    private static final Transaction A_TRANSACTION = new TransactionBuilder().build();

    @Mock
    private Ledger ledger;
    @Mock
    private StatementPrinter statementPrinter;

    private Account account;

    @BeforeEach
    void setUp() {
        account = new Account(ledger, statementPrinter);
    }

    @Test
    void it_saves_a_deposit_transaction() {
        account.deposit(AN_AMOUNT);

        verify(ledger).addDeposit(AN_AMOUNT);
    }

    @Test
    void it_saves_a_withdrawal_transaction() {
        account.withdrawal(AN_AMOUNT);

        verify(ledger).addWithdrawal(AN_AMOUNT);
    }

    @Test
    void it_prints_the_statement() {
        List<Transaction> transactions = singletonList(A_TRANSACTION);
        given(ledger.allTransactions()).willReturn(transactions);

        account.printStatement();

        verify(statementPrinter).print(transactions);
    }
}