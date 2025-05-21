package org;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BankAccountTest {
  public BankAccount bankAccount;

  @BeforeEach
  public void setUpBankAccount(){
    this.bankAccount = new BankAccount("Bob", 100);
  }

  @Test
  public void testValidInitialBalance() {
    assertDoesNotThrow(() -> {
      new BankAccount("Bob", 5);
    });
  }

  @Test
  public void testInvalidInitialBalance() {
    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
      new BankAccount("Bob", -1);
    });
    assertEquals("Initial balance cannot be negative.", exception.getMessage());
  }

  @Test
  public void testValidDeposit() {
    assertDoesNotThrow(() -> {
      this.bankAccount.deposit(100);
    });
    assertEquals(200, this.bankAccount.getBalance());

  }

  @Test
  public void testInvalidDeposit() {
    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
      this.bankAccount.deposit(-100);
    });
    assertEquals("Deposit amount must be positive.", exception.getMessage());

    exception = assertThrows(IllegalArgumentException.class, () -> {
      this.bankAccount.deposit(0);
    });
    assertEquals("Deposit amount must be positive.", exception.getMessage());
  }

  @Test
  public void testValidWithdraw() {
    assertDoesNotThrow(() -> {
      this.bankAccount.withdraw(50);
    });
    assertEquals(50, this.bankAccount.getBalance());
  }

  @Test
  public void testInvalidWithdrawGreaterThanBalance(){
    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {this.bankAccount.withdraw(200);});
    assertEquals("Insufficient funds.", exception.getMessage());
  }

  @Test
  public void  testInvalidWithdrawNegativeAmount(){
    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {this.bankAccount.withdraw(-200);});
    assertEquals("Withdrawal amount must be positive.", exception.getMessage());

    exception = assertThrows(IllegalArgumentException.class, () -> {this.bankAccount.withdraw(0);});
    assertEquals("Withdrawal amount must be positive.", exception.getMessage());
  }
}
