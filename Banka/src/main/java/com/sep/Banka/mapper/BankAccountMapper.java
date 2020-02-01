package com.sep.Banka.mapper;

import java.util.Date;

import com.sep.Banka.model.BankAccount;
import com.sep.Banka.model.BankAccountDTO;

public class BankAccountMapper {
    public static BankAccount toBankAccount(BankAccountDTO bankAccountDTO) {
        return new BankAccount(bankAccountDTO.getPan(), bankAccountDTO.getSecurityCode(),
                bankAccountDTO.getCardHolderName(), new Date(2021, 12, 1), 0.0, 0.0);
    }
}