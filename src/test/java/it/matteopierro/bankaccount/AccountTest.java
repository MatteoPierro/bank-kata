package it.matteopierro.bankaccount;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class AccountTest {

    @Mock
    Ledger ledger;

    @Test
    void testDeposit() {
        Account account = new Account(ledger);

        account.deposit(1);

        verify(ledger).addDeposit(1);
    }

    @Test
    void testWithdraw() {
        Account account = new Account(ledger);

        account.withdrawal(1);

        verify(ledger).addWithdrawal(1);
    }
}
