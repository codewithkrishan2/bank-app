package com.bank.service;

import java.util.List;

import com.bank.entity.Bank;

public interface BankService {

	Bank getBankByName(String name);

	List<Bank> getAllBanks();
	
}
