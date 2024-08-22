package com.bank.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
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

	BankRestController(BankService bankService, BranchService branchService,
			ServiceOfBankService servicesOfBankService) {
		super();
		this.bankService = bankService;
		this.branchService = branchService;
		this.servicesOfBankService = servicesOfBankService;
	}

	@GetMapping("/list")
	public ResponseEntity<List<Bank>> listBanks(Model model) {
		return ResponseEntity.ok(bankService.getAllBanks());
	}

	@GetMapping("/branches/{bankName}")
	public ResponseEntity<?> getBranches(@PathVariable String bankName) {
		try {
			Bank bank = bankService.getBankByName(bankName);
			List<Branch> branches = branchService.getBranchesByBankName(bankName);
			return ResponseEntity.ok(branches);
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/services/{bankName}")
	public ResponseEntity<List<Services>> getServices(@PathVariable String bankName) {
		try {
			Bank bank = bankService.getBankByName(bankName);
			List<Services> services = servicesOfBankService.getServicesByBankName(bankName);
			return ResponseEntity.ok(services);
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}

	}

}
