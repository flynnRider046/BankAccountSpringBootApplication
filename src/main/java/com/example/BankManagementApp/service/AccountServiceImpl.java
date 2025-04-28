package com.example.BankManagementApp.service;

import com.example.BankManagementApp.entity.Account;
import com.example.BankManagementApp.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService{

    @Autowired
    AccountRepository accountRepository;

    @Override
    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Account getAccountDetailsByAccountNumber(Long accountNumber) {
        Optional<Account> accountDetails = accountRepository.findById(accountNumber);
        if(accountDetails.isEmpty()) {
            throw new RuntimeException("Account does not exist");
        } else {
            return accountDetails.get();
        }
    }

    @Override
    public List<Account> getAllAccountDetails() {
        List<Account> allAccounts = accountRepository.findAll();
        return allAccounts;
    }

    @Override
    public Account depositAmount(Long accountNumber, Double amount) {
        Optional<Account> account = accountRepository.findById(accountNumber);
        if(account.isEmpty()) {
            throw new RuntimeException("Account requested is not present");
        }
        Account accountDetails = account.get();
        Double amountUpdated = accountDetails.getAccount_balance() + amount;
        accountDetails.setAccount_balance(amountUpdated);
        accountRepository.save(accountDetails);
        return accountDetails;
    }

    @Override
    public Account withdrawAmount(Long accountNumber, Double amount) {
        Optional<Account> account = accountRepository.findById(accountNumber);
        if(account.isEmpty()) {
            throw new RuntimeException("The requested account is not present");
        }
        Account accountDetails = account.get();
        Double amountAfterRemoval = accountDetails.getAccount_balance() - amount;
        accountDetails.setAccount_balance(amountAfterRemoval);
        accountRepository.save(accountDetails);
        return accountDetails;
    }

    @Override
    public void closeAccount(Long AccountNumber) {
        Optional<Account> account = accountRepository.findById(AccountNumber);
        if(account.isEmpty()) {
            throw new RuntimeException("The requested account is not present");
        }
        Account accontDetails = account.get();
        accountRepository.delete(accontDetails);
    }
}
