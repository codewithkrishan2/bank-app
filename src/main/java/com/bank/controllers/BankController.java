package com.bank.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bank.entity.Bank;
import com.bank.entity.Branch;
import com.bank.entity.Services;
import com.bank.service.BankService;
import com.bank.service.BranchService;
import com.bank.service.ServiceOfBankService;

@Controller
@RequestMapping("/bank")
public class BankController {

	private BankService bankService;
	private BranchService branchService;
	private ServiceOfBankService servicesOfBankService;

	BankController(BankService bankService, BranchService branchService, ServiceOfBankService servicesOfBankService) {
		super();
		this.bankService = bankService;
		this.branchService = branchService;
		this.servicesOfBankService = servicesOfBankService;
	}

	@GetMapping("/branches/{bankName}")
	public String getBranches(@PathVariable String bankName, Model model) {
		Bank bank = bankService.getBankByName(bankName);
		List<Branch> branches = branchService.getBranchesByBankName(bankName);
		model.addAttribute("bank", bank);
		model.addAttribute("branches", branches);

		return "branches";
	}

	@GetMapping("/services/{bankName}")
	public String getServices(@PathVariable String bankName, Model model) {
		Bank bank = bankService.getBankByName(bankName);
		List<Services> services = servicesOfBankService.getServicesByBankName(bankName);
		model.addAttribute("bank", bank);
		model.addAttribute("services", services);

		return "services";
	}
	
	@GetMapping("/list")
    public String listBanks(Model model) {
        List<Bank> banks = bankService.getAllBanks();
        model.addAttribute("banks", banks);
        return "banks";
    }
}
