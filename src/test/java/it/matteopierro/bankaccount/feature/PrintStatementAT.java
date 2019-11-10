package it.matteopierro.bankaccount.feature;

import it.matteopierro.bankaccount.Account;
import it.matteopierro.bankaccount.Console;
import it.matteopierro.bankaccount.Ledger;
import it.matteopierro.bankaccount.StatementPrinter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class PrintStatementAT {

    @Mock
    private Console console;

    private Account account;

    @BeforeEach
    void setUp() {
        Ledger ledger = new Ledger();
        StatementPrinter statementPrinter = new StatementPrinter();
        account = new Account(ledger, statementPrinter);
    }

    @Test
    void statement_contains_all_transactions() {
        account.deposit(1000);
        account.withdrawal(100);
        account.deposit(500);
        account.printStatement();

        verify(console).printLine("DATE | AMOUNT | BALANCE");
        verify(console).printLine("10/04/2014 | 500.00 | 1400.00");
        verify(console).printLine("02/04/2014 | -100.00 | 900.00");
        verify(console).printLine("01/04/2014 | 1000.00 | 1000.00");
    }
}
