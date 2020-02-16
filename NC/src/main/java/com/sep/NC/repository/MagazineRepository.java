package com.sep.NC.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sep.NC.model.Magazine;

/**
 * Spring Data JPA repository for the Authority entity.
 */
public interface MagazineRepository extends JpaRepository<Magazine, String> {

    Magazine findOneById(Long id);

    List<Magazine> findByActiveIsTrue();
}
