package it.matteopierro.bankaccount;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Month;
import java.util.Arrays;
import java.util.List;

import static it.matteopierro.bankaccount.TransactionBuilder.aTransaction;
import static java.time.LocalDate.of;
import static java.util.Collections.emptyList;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class StatementPrinterTest {
    @Mock
    private Console console;

    private StatementPrinter statementPrinter;

    @BeforeEach
    void setUp() {
        statementPrinter = new StatementPrinter(console);
    }

    @Test
    void it_always_prints_the_header() {
        statementPrinter.print(emptyList());

        verify(console).printLine("DATE | AMOUNT | BALANCE");
    }

    @Test
    void it_prints_transactions_in_reverse_chronological_order() {
        List<Transaction> transactions = Arrays.asList(
                aTransaction()
                        .withDate(of(2014, Month.APRIL, 1))
                        .withAmount(1000)
                        .build(),
                aTransaction()
                        .withDate(of(2014, Month.APRIL, 2))
                        .withAmount(-100)
                        .build(),
                aTransaction()
                        .withDate(of(2014, Month.APRIL, 10))
                        .withAmount(500)
                        .build()
        );

        statementPrinter.print(transactions);

        verify(console).printLine("DATE | AMOUNT | BALANCE");
        verify(console).printLine("10/04/2014 | 500.00 | 1400.00");
        verify(console).printLine("02/04/2014 | -100.00 | 900.00");
        verify(console).printLine("01/04/2014 | 1000.00 | 1000.00");
    }
}