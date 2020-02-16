package com.sep.NC.service;

import java.util.List;

import com.sep.NC.model.Magazine;

public interface MagazineService {

    List<Magazine> findAll();

    Magazine getOne(Long id);

    void payMembership(Long id, String username);

    Magazine save(Magazine magazine);
}
