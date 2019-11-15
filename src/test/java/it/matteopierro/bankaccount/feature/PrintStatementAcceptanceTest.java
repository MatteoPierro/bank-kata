package it.matteopierro.bankaccount.feature;

import it.matteopierro.bankaccount.Account;
import it.matteopierro.bankaccount.Ledger;
import it.matteopierro.bankaccount.Printer;
import it.matteopierro.bankaccount.StatementPrinter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class PrintStatementAcceptanceTest {

    @Mock
    private Printer printer;

    @Test
    void printStatement() {
        Ledger ledger = new Ledger();
        StatementPrinter statementPrinter = new StatementPrinter();
        Account account = new Account(ledger, statementPrinter);

        account.deposit(1000);
        account.withdrawal(100);
        account.deposit(500);
        account.printStatement();

        verify(printer).print("DATE | AMOUNT | BALANCE");
        verify(printer).print("10/04/2014 | 500.00 | 1400.00");
        verify(printer).print("02/04/2014 | -100.00 | 900.00");
        verify(printer).print("01/04/2014 | 1000.00 | 1000.00");
    }
}
