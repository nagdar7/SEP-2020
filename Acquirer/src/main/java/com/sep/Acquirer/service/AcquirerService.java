package com.sep.Acquirer.service;

import java.util.List;

import com.sep.Acquirer.model.PaymentRequest;

import org.springframework.stereotype.Service;

public interface AcquirerService {

	public List<PaymentRequest> returnAllAccounts();

}
