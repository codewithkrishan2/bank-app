package com.bank.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bank.entity.Bank;
import com.bank.exception.BankNotFoundException;
import com.bank.repo.BankRepo;
import com.bank.service.BankService;

@Service
public class BankServiceImpl implements BankService {

	
	private BankRepo bankRepo;
	
	public BankServiceImpl(BankRepo bankRepo) {
		super();
		this.bankRepo = bankRepo;
	}
	
	@Override
	public Bank getBankByName(String name) {
		 return this.bankRepo.findByName(name).orElseThrow(()->new BankNotFoundException("Bank with name " + name + " not found"));
		 
	}

	@Override
	public List<Bank> getAllBanks() {
		return this.bankRepo.findAll();
	}

}
