package com.sep.Sellers.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sep.Sellers.model.Seller;


public interface SellerRepository extends JpaRepository<Seller, String>{
}
