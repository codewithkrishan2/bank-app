package com.bank.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bank.entity.Services;
import com.bank.repo.ServiceRepo;
import com.bank.service.ServiceOfBankService;

@Service
class ServicesOfBankServiceImpl implements ServiceOfBankService {

	private ServiceRepo serviceRepo;
	
	public ServicesOfBankServiceImpl(ServiceRepo serviceRepo) {
		super();
		this.serviceRepo =serviceRepo;
		
	}
	
	@Override
	public List<Services> getServicesByBankName(String name) {
		return this.serviceRepo.findByBankName(name);
	}

}
