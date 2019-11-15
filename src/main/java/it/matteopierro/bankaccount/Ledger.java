package it.matteopierro.bankaccount;


import java.util.List;

public class Ledger {

    private final BankClock bankClock;
    private final TransactionRepository transactionRepository;

    public Ledger(BankClock bankClock, TransactionRepository transactionRepository) {
        this.bankClock = bankClock;
        this.transactionRepository = transactionRepository;
    }

    public void addDeposit(int amount) {
        Transaction transaction = new Transaction(bankClock.getToday(), amount);
        transactionRepository.store(transaction);

    }

    public void addWithdrawal(int amount) {
        Transaction transaction = new Transaction(bankClock.getToday(), -amount);
        transactionRepository.store(transaction);
    }

    public List<Transaction> getTransactions() {
        return transactionRepository.getTransactions();
    }
}
