package com.sep.NC.service;

import java.util.List;

import com.sep.NC.dto.AccountDTO;
import com.sep.NC.model.Account;

public interface AccountService {

    // Account save(Account account);

    Account findByUsername(String username);

    Account findById(Long id);

    List<Account> getAllReviewers();

    List<Account> getAllEditors();

    AccountDTO createNewAccount(AccountDTO accountDTO);
}
