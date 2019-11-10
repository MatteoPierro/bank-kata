package it.matteopierro.bankaccount;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import static com.google.common.collect.Lists.reverse;
import static com.google.common.collect.Streams.zip;

public class StatementPrinter {
    private static final String HEADER = "DATE | AMOUNT | BALANCE";
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final DecimalFormat AMOUNT_FORMATTER = new DecimalFormat("#.00", DecimalFormatSymbols.getInstance(Locale.UK));
    private final Console console;

    public StatementPrinter(Console console) {
        this.console = console;
    }

    public void print(List<Transaction> transactions) {
        printHeader();
        printStatementsFor(transactions);
    }

    private void printHeader() {
        console.printLine(HEADER);
    }

    private void printStatementsFor(List<Transaction> transactions) {
        reverse(statementLines(transactions)).forEach(console::printLine);
    }

    private List<String> statementLines(List<Transaction> transactions) {
        return zip(
                transactions.stream(),
                runningBalance(transactions).stream(),
                this::statementLine
        ).collect(Collectors.toList());
    }

    private String statementLine(Transaction transaction, Integer runningBalance) {
        return DATE_FORMATTER.format(transaction.date) +
                " | " +
                AMOUNT_FORMATTER.format(transaction.amount) +
                " | " +
                AMOUNT_FORMATTER.format(runningBalance);
    }

    private List<Integer> runningBalance(List<Transaction> transactions) {
        List<Integer> runningBalances = new ArrayList<>();

        int runningBalance = 0;
        for (Transaction transaction : transactions) {
            runningBalance += transaction.amount;
            runningBalances.add(runningBalance);
        }

        return runningBalances;
    }
}

