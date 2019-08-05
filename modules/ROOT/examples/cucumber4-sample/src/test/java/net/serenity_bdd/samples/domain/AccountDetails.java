package net.serenity_bdd.samples.domain;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.annotation.JsonProperty;

public class AccountDetails {
    private AccountType account;
    private int balance;

    public AccountDetails(AccountType account, int balance) {
        this.account = account;
        this.balance = balance;
    }

    public AccountDetails() {}

    @JsonProperty("Account")
    public AccountType getAccount() {
        return account;
    }

    @JsonProperty("Balance")
    public int getBalance() {
        return balance;
    }
}