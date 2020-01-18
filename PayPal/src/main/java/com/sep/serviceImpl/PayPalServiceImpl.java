package com.sep.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import com.sep.model.PayPal;
import com.sep.service.PayPalService;

public class PayPalServiceImpl implements PayPalService{

	@Override
	public List<PayPal> returnAllAccounts(){
		List<PayPal> accounts = new ArrayList<PayPal>();
		accounts.add(new PayPal(1L,"1234","1234568789546",20000.00,"Petar", "Petrovic"));
		accounts.add(new PayPal(1L,"5678","1567894654984",30000.00,"Mika", "Mikic"));
		accounts.add(new PayPal(1L,"9012","8464816886885",40000.00,"Milan", "Milanovic"));
		accounts.add(new PayPal(1L,"3456","7486595153266",50000.00,"Jovan", "Jovanovic"));
		accounts.add(new PayPal(1L,"7890","8941684168461",70000.00,"Test", "Test"));
		accounts.add(new PayPal(1L,"1456","8527419685456",60000.00,"Dragan", "Vujanovic"));
		accounts.add(new PayPal(1L,"1598","7418521265478",90000.00,"Tatjana", "Zdravkovic"));
		return accounts;
	}
}
