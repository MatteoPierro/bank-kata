package it.matteopierro.bankaccount;

import java.util.Objects;

public class Transaction {
    private final String date;
    private final int amount;

    public Transaction(String date, int amount) {

        this.date = date;
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Transaction)) return false;
        Transaction that = (Transaction) o;
        return amount == that.amount &&
                Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, amount);
    }
}
