package com.sep.service;

import java.util.List;

import com.sep.model.Banka;

import org.springframework.stereotype.Service;

public interface AcquirerService {

	public List<Banka> returnAllAccounts();

}
