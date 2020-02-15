package com.sep.BitCoin.service;

import java.util.List;
import java.util.Map;

import com.sep.BitCoin.model.BitCoin;
import com.sep.BitCoin.model.FormField;
import com.sep.BitCoin.model.RedirectDTO;

public interface BitCoinService {

	public List<BitCoin> returnAllAccounts();

	public List<FormField> getFormFieldsForBitcoin();

	public RedirectDTO pay(Map<String, String> items);
}
