package org;

public class BankAccount {
  private String owner;
  private double balance;

  public BankAccount(String owner, double initialBalance) {
    if (initialBalance < 0) {
      throw new IllegalArgumentException("Initial balance cannot be negative.");
    }
    this.owner = owner;
    this.balance = initialBalance;
  }

  public double getBalance() {
    return balance;
  }

  public String getOwner() {
    return owner;
  }

  public void deposit(double amount) {
    if (amount <= 0) {
      throw new IllegalArgumentException("Deposit amount must be positive.");
    }
    balance += amount;
  }

  public void withdraw(double amount) {
    if (amount <= 0) {
      throw new IllegalArgumentException("Withdrawal amount must be positive.");
    }
    if (amount > balance) {
      throw new IllegalArgumentException("Insufficient funds.");
    }
    balance -= amount;
  }
}
