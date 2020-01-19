package com.sep.Acquirer.service;

import java.util.List;

import com.sep.Acquirer.model.Banka;

import org.springframework.stereotype.Service;

public interface AcquirerService {

	public List<Banka> returnAllAccounts();

}
