package com.example.cm2115.model;

import java.io.IOException;

public class BasicAccount extends BankAccount implements CurrentAccount{
    public static void transfer(String targetAccount, String senderAccount, int amount, int balance, int balance1) throws IOException {
        BasicAccount.withdraw(amount,balance,senderAccount);
        BasicAccount.deposit(amount,balance1,targetAccount);

    }

    @Override
    public void processCardTransaction(int amount) {

    }

    // Additional methods specific to BasicCurrentAccount

}
