package com.bank.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bank.entity.Branch;
import com.bank.repo.BranchRepo;
import com.bank.service.BranchService;

@Service
public class BranchServiceImpl implements BranchService {

	private BranchRepo branchRepo;
	
	public BranchServiceImpl(BranchRepo branchRepo){
		super();
		this.branchRepo = branchRepo;
	}
	
	
	@Override
	public List<Branch> getBranchesByBankName(String name) {
		return this.branchRepo.findByBankName(name);
	}

}
