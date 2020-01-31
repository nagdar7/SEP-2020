package com.sep.PayPal.service;

import java.util.List;

import com.sep.PayPal.dto.UrlDTO;
import com.sep.PayPal.model.FormField;
import com.sep.PayPal.model.PayPal;

public interface PayPalService {

	public List<PayPal> returnAllAccounts();
	
	public String getPayPalUrl();
	
	public List<FormField> getFormFieldsForPaypal();
}
