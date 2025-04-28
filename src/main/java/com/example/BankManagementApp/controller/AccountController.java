package com.example.BankManagementApp.controller;

import com.example.BankManagementApp.entity.Account;
import com.example.BankManagementApp.service.AccountService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountService service;

    // create an account
    @PostMapping("/create")
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
        Account savedAccount = service.createAccount(account);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAccount);
    }

    @GetMapping("/{accountNumber}")
    public Account getAccountDetailsByAccountNumber(@PathVariable Long accountNumber) {
        Account accountDetails = service.getAccountDetailsByAccountNumber(accountNumber);
        return accountDetails;
    }

    @GetMapping("/getallaccounts")
    public List<Account> getAllAccountDetails() {
        List<Account> allAccountDetails = service.getAllAccountDetails();
        return allAccountDetails;
    }

    @PutMapping("/deposit/{accountNumber}/{amount}")
    public Account depositAmount(@PathVariable Long accountNumber,@PathVariable Double amount) {
        Account account = service.depositAmount(accountNumber,amount);
        return account;
    }

    @PutMapping("/withdraw/{accountNumber}/{amount}")
    public Account withdrawAmount(@PathVariable Long accountNumber, @PathVariable Double amount) {
        Account account = service.withdrawAmount(accountNumber, amount);
        return account;
    }

    @DeleteMapping("/delete/{accountNumber}")
    public ResponseEntity<String> closeAccount(@PathVariable Long accountNumber) {
         service.closeAccount(accountNumber);
         return ResponseEntity.status(HttpStatus.ACCEPTED).body("Account Closed");
    }


}
