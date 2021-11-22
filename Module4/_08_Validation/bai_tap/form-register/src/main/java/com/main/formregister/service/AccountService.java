package com.main.formregister.service;


import com.main.formregister.model.Account;
import com.main.formregister.repository.IAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService implements IAccountService {
    @Autowired
    IAccountRepository iAccountRepository;

    @Override
    public void saveAcc(Account account) {
        iAccountRepository.save(account);
    }

    @Override
    public List<Account> findAll() {
        return iAccountRepository.findAll();
    }
}
