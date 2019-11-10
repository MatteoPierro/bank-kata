package it.matteopierro.bankaccount;

import java.time.LocalDate;

public class TransactionBuilder {
    private LocalDate date = LocalDate.of(2016, 02, 16);
    private int amount = 10;

    public static TransactionBuilder aTransaction() {
        return new TransactionBuilder();
    }

    public TransactionBuilder withDate(LocalDate date) {
        this.date = date;
        return this;
    }

    public TransactionBuilder withAmount(int amount) {
        this.amount = amount;
        return this;
    }

    public Transaction build() {
        return new Transaction(date, amount);
    }
}
