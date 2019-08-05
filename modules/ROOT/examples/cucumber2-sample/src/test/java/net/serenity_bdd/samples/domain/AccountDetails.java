package net.serenity_bdd.samples.domain;

public class AccountDetails {
    public AccountDetails(AccountType account, int balance) {
        this.account = account;
        this.balance = balance;
    }

    private final AccountType account;
    private final int balance;

    public AccountType getAccount() {
        return account;
    }

    public int getBalance() {
        return balance;
    }
}