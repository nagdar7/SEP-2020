package com.sep.Sellers.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sep.Sellers.model.PaymentType;

import java.util.List;

public interface PaymentTypeRepository extends JpaRepository<PaymentType, Integer>{

    List<PaymentType> findBySellerPib(String pib);
}
