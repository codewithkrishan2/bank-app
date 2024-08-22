package com.bank.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.entity.Bank;
import com.bank.entity.Branch;
import com.bank.entity.Services;
import com.bank.service.BankService;
import com.bank.service.BranchService;
import com.bank.service.ServiceOfBankService;

@RestController
@RequestMapping("/api/bank")
public class BankRestController {

	private BankService bankService;
	private BranchService branchService;
	private ServiceOfBankService servicesOfBankService;
	
	BankRestController(BankService bankService, BranchService branchService, ServiceOfBankService servicesOfBankService) {
		super();
		this.bankService = bankService;
		this.branchService = branchService;
		this.servicesOfBankService = servicesOfBankService;
	}
	
	@GetMapping("/all-banks")
	public List<Bank> getAllBanks() {
		return bankService.getAllBanks();
	}
	
	@GetMapping("/all-branches")
	public List<Branch> getAllBranches() {
		return branchService.getBranchesByBankName("SBI");
	}
	
	@GetMapping("/all-services")
	public List<Services> getAllServices() {
		return servicesOfBankService.getServicesByBankName("SBI");
	}
	
	@GetMapping("/branches/{bankName}")
    public ResponseEntity<List<Branch>> getBranches(@PathVariable String bankName) {
		Bank bank = bankService.getBankByName(bankName);
        if (bank != null) {
        	List<Branch> branches = branchService.getBranchesByBankName(bankName);
            return ResponseEntity.ok(branches);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
	
	@GetMapping("/services/{bankName}")
    public ResponseEntity<List<Services>> getServices(@PathVariable String bankName) {
		Bank bank = bankService.getBankByName(bankName);
        if (bank != null) {
            List<Services> services = servicesOfBankService.getServicesByBankName(bankName);
            return ResponseEntity.ok(services);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
	
}
