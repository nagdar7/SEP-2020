package com.sep.Sellers.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.sep.Sellers.model.Seller;
import com.sep.Sellers.services.SellersService;

import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.sep.Sellers.repository.SellerRepository;

@Service
public class SellersServiceImpl implements SellersService {

//	@Override
//	public List<Seller> returnAllSellers() {
//		System.out.println("Usao sam u service");
//		List<Seller> sellers = new ArrayList<Seller>();
//		Seller s1 = new Seller("Magazin 1", "256487");
//		s1.getPaymentTypes().add("BANKA");
//		s1.getPaymentTypes().add("PAYPAL");
//		Seller s2 = new Seller("Magazin 2", "214365");
//		s2.getPaymentTypes().add("PAYPAL");
//		s2.getPaymentTypes().add("BITCOIN");
//		sellers.add(s1);
//		sellers.add(s2);
//		return sellers;
//	}

    Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SellerRepository sellerRepository;

    @Override
    public List<Seller> findAll() {
        log.info("findAll");
        return sellerRepository.findAll();
    }
}
