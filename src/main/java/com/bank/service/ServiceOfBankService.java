package com.bank.service;

import java.util.List;

import com.bank.entity.Services;

public interface ServiceOfBankService {

	List<Services> getServicesByBankName(String name);
}
