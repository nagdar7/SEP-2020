package com.sep.NC.service.impl;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sep.NC.dto.AccountDTO;
import com.sep.NC.model.Account;
import com.sep.NC.model.Authority;
import com.sep.NC.repository.AccountRepository;
import com.sep.NC.service.AccountService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.sep.NC.repository.AuthorityRepository;

@Service
public class AccountServiceImpl implements AccountService {

    Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AuthorityRepository authorityRepository;

    // @Override
    // public Account save(Account account) {
    // log.info("save, account: {}", account.toString());
    // return this.accountRepository.save(account);
    // }

    @Override
    public Account findByUsername(String username) {
        log.info("findByUsername, username: {}", username);
        return this.accountRepository.findByUsernameAndActiveIsTrue(username);
    }

    @Override
    public Account findById(Long id) {
        log.info("findByUsername, id: {}", id);
        return this.accountRepository.getOne(id);
    }

    @Override
    public List<Account> getAllReviewers() {
        Set<Authority> authorities = new HashSet<>();
        authorities.add(new Authority("REVIEWER"));
        return this.accountRepository.findAllByAuthoritiesIn(authorities);
    }

    @Override
    public List<Account> getAllEditors() {
        Set<Authority> authorities = new HashSet<>();
        authorities.add(new Authority("EDITOR"));
        return this.accountRepository.findAllByAuthoritiesIn(authorities);
    }

    /**
     * @return a list of all the authorities
     */
    public List<String> getAuthorities() {
        log.info("getAuthorities");
        return authorityRepository.findAll().stream().map(Authority::getName).collect(Collectors.toList());
    }

    public AccountDTO createNewAccount(AccountDTO accountDTO) {
        log.info("createNewAccount, account: {}", accountDTO.toString());
        ModelMapper modelMapper = new ModelMapper();
        Account account = modelMapper.map(accountDTO, Account.class);
        account.setActive(true);
        Set<Authority> authorities = new HashSet<>();
        authorities.add(new Authority("AUTHOR"));
        account.setAuthorities(authorities);
        account = accountRepository.save(account);
        accountDTO = modelMapper.map(account, AccountDTO.class);
        return accountDTO;
    }
}
