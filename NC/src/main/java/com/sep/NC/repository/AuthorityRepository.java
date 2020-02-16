package com.sep.NC.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sep.NC.model.Authority;

/**
 * Spring Data JPA repository for the Authority entity.
 */
public interface AuthorityRepository extends JpaRepository<Authority, String> {
}
