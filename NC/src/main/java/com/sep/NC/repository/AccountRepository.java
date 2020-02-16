package com.sep.NC.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sep.NC.model.Account;
import com.sep.NC.model.Authority;

import java.util.List;
import java.util.Set;

public interface AccountRepository extends JpaRepository<Account, Long> {

   Account findByUsername(String username);

   Account findByUsernameAndActiveIsTrue(String username);

   List<Account> findAllByAuthoritiesIn(Set<Authority> authorities);
}
