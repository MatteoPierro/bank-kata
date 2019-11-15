package it.matteopierro.bankaccount;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class LedgerTest {
    @Mock
    private TransactionRepository transactionRepository;

    @Mock
    private BankClock bankClock;

    @Test
    void testAddDeposit() {
        Ledger ledger = new Ledger(bankClock, transactionRepository);
        String date = "04/09/1980";
        when(bankClock.getToday()).thenReturn(date);

        int amount = 500;
        ledger.addDeposit(amount);

        Transaction transaction = new Transaction(date, amount);
        verify(transactionRepository).store(transaction);
    }

    @Test
    void testWithdraw() {
        Ledger ledger = new Ledger(bankClock, transactionRepository);
        String date = "04/09/1980";
        when(bankClock.getToday()).thenReturn(date);

        int amount = 500;
        ledger.addWithdrawal(amount);

        Transaction transaction = new Transaction(date, -amount);
        verify(transactionRepository).store(transaction);

    }
}