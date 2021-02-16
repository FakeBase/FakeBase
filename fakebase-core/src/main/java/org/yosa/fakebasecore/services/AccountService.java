package org.yosa.fakebasecore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yosa.fakebasecore.domain.Account;
import org.yosa.fakebasecore.exceptions.AccountNotFoundException;
import org.yosa.fakebasecore.repositories.AccountRepository;

import java.util.Optional;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    public Account getByUsername(String username){
        return accountRepository.findByUsername(username)
                .orElseThrow(() -> new AccountNotFoundException("Account not found."));
    }

    public Optional<Account> getByUsernameOptional(String username){
        return accountRepository.findByUsername(username);
    }

    public Account create(Account account){
        return accountRepository.save(account);
    }

    public void delete(String id){
        accountRepository.deleteById(id);
    }
}
