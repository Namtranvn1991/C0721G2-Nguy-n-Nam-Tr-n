package com.main.formregister.service;

import com.main.formregister.model.Account;

import java.util.List;

public interface IAccountService {
    void saveAcc(Account account);

     List<Account> findAll();
}
