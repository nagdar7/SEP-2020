package com.sep.NC.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sep.NC.model.Account;
import com.sep.NC.model.Authority;
import com.sep.NC.model.Magazine;
import com.sep.NC.model.enumeration.BillingType;
import com.sep.NC.model.enumeration.ScienceField;
import com.sep.NC.repository.AccountRepository;
import com.sep.NC.service.AccountService;
import com.sep.NC.service.MagazineService;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import com.sep.NC.repository.AuthorityRepository;
import com.sep.NC.repository.MagazineRepository;

@Service
public class MagazineServiceImpl implements MagazineService {

    Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MagazineRepository magazineRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AuthorityRepository authorityRepository;

    @Override
    public List<Magazine> findAll() {
        log.info("findAll");
        return magazineRepository.findByActiveIsTrue().stream().map(x -> {
            x.setOpenAccessAuthors(null);
            return x;
        }).collect(Collectors.toList());
    }

    @Override
    public Magazine getOne(Long id) {
        log.info("getOne, id: {}", id);
        return magazineRepository.findOneById(id);
    }

    @Override
    public void payMembership(Long id, String username) {
        log.info("payMembership, id: {}, user: {}", id, username);
        Magazine magazine = magazineRepository.findOneById(id);
        Account account = accountRepository.findByUsername(username);
        magazine.getOpenAccessAuthors().add(account);
        magazine = magazineRepository.save(magazine);
    }

    @Override
    public Magazine save(Magazine magazine) {
        magazine.setActive(true);
        UUID uuid = UUID.randomUUID();
        magazine.setIssn(uuid.toString());
        // TODO: OVO TREBA SA FRONTA DA DODJE IZ noviCasopis
        List<ScienceField> scienceFieldList = new ArrayList<>();
        scienceFieldList.add(ScienceField.COMPUTER_SCIENCE);
        magazine.setScienceFieldList(scienceFieldList);
        magazine.setBillingType(BillingType.AUTHORS);
        return magazineRepository.save(magazine);
    }
}
