package com.example.BankManagementApp.service;

import com.example.BankManagementApp.entity.Account;

import java.util.List;

public interface AccountService {

    /* Creating a bank account */
    public Account createAccount(Account account);

    /* get bank account details by account number */
    public Account getAccountDetailsByAccountNumber(Long accountNumber);

    /* Get all the bank account details */
    public List<Account> getAllAccountDetails();

    /* Deposit Money to account */
    public Account depositAmount(Long accountNumber, Double amount);

    /* Withdraw money from the account */
    public Account withdrawAmount(Long accountNumber, Double amount);

    /* Delete or close the account */
    public void closeAccount(Long AccountNumber);

}
