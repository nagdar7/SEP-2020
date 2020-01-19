package com.sep.Sellers.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import com.sep.Sellers.model.PaymentType;
import com.sep.Sellers.model.Seller;
import com.sep.Sellers.services.SellersService;

import org.springframework.stereotype.Service;

@Service
public class SellersServiceImpl implements SellersService {

	@Override
	public List<Seller> returnAllSellers() {
		List<Seller> sellers = new ArrayList<Seller>();
		Seller s1 = new Seller("name1", "pib1");
		s1.getPaymentTypes().add(PaymentType.CREDIT_CARD);
		s1.getPaymentTypes().add(PaymentType.PAY_PALL);
		Seller s2 = new Seller("name2", "pib2");
		s2.getPaymentTypes().add(PaymentType.PAY_PALL);
		s2.getPaymentTypes().add(PaymentType.BIT_COIN);
		sellers.add(s1);
		sellers.add(s2);
		return sellers;
	}
}
