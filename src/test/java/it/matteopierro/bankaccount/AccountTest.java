package it.matteopierro.bankaccount;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AccountTest {

    @Mock
    Ledger ledger;
    @Mock
    StatementPrinter statementPrinter;

    @Test
    void testDeposit() {
        Account account = new Account(ledger, statementPrinter);

        account.deposit(1);

        verify(ledger).addDeposit(1);
    }

    @Test
    void testWithdraw() {
        Account account = new Account(ledger, statementPrinter);

        account.withdrawal(1);

        verify(ledger).addWithdrawal(1);
    }

    @Test
    void testPrintStatement() {
        List<Transaction> transactions = Arrays.asList(new Transaction("09/09/1909",65));
        when(ledger.getTransactions()).thenReturn(transactions);
        Account account = new Account(ledger, statementPrinter);

        account.printStatement();

        verify(statementPrinter).print(transactions);
    }
}
