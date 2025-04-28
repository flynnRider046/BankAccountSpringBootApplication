package com.example.BankManagementApp.entity;

import jakarta.persistence.*;

@Entity
@Table
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long accountNumber;
    @Column
    public String account_Holder_Name;
    @Column
    public Double account_balance;

    public Account() {
    }

    public Account(String account_Holder_Name, Double account_balance) {
        this.account_Holder_Name = account_Holder_Name;
        this.account_balance = account_balance;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccount_Holder_Name() {
        return account_Holder_Name;
    }

    public void setAccount_Holder_Name(String account_Holder_Name) {
        this.account_Holder_Name = account_Holder_Name;
    }

    public Double getAccount_balance() {
        return account_balance;
    }

    public void setAccount_balance(Double account_balance) {
        this.account_balance = account_balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber=" + accountNumber +
                ", account_Holder_Name='" + account_Holder_Name + '\'' +
                ", account_balance=" + account_balance +
                '}';
    }
}
