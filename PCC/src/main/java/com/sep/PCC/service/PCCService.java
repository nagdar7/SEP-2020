package com.sep.PCC.service;

import java.util.List;

import com.sep.PCC.model.Banka;

import org.springframework.stereotype.Service;

public interface PCCService {

	public List<Banka> returnAllAccounts();

}
