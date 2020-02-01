package com.sep.Issuer.service;

import java.util.List;

import com.sep.Issuer.model.*;

import org.springframework.stereotype.Service;

public interface IssuerService {

	public List<Banka> returnAllAccounts();

}
