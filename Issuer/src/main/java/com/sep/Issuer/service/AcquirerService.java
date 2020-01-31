package com.sep.Issuer.service;

import java.util.List;

import com.sep.Issuerodel.Banka;

import org.springframework.stereotype.Service;

public interface Issuerrvice {

	public List<Banka> returnAllAccounts();

}
