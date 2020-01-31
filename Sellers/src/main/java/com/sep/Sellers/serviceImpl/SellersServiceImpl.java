package com.sep.Sellers.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import com.sep.Sellers.model.Seller;
import com.sep.Sellers.services.SellersService;

import org.springframework.stereotype.Service;

@Service
public class SellersServiceImpl implements SellersService {

	@Override
	public List<Seller> returnAllSellers() {
		List<Seller> sellers = new ArrayList<Seller>();
		Seller s1 = new Seller("Magazin 1", "256487");
		s1.getPaymentTypes().add("CREDITCARD");
		s1.getPaymentTypes().add("PAYPAL");
		Seller s2 = new Seller("Magazin 2", "214365");
		s2.getPaymentTypes().add("PAYPAL");
		s2.getPaymentTypes().add("BITCOIN");
		sellers.add(s1);
		sellers.add(s2);
		return sellers;
	}
}
