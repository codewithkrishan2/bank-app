package com.bank.runner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.bank.entity.Bank;
import com.bank.entity.Branch;
import com.bank.entity.Services;
import com.bank.repo.BankRepo;
import com.bank.repo.BranchRepo;
import com.bank.repo.ServiceRepo;

@Component
public class DataLoader implements ApplicationRunner {

	private final BankRepo bankRepo;
    private final BranchRepo branchRepo;
    private final ServiceRepo serviceRepo;

    public DataLoader(BankRepo bankRepo, BranchRepo branchRepo, ServiceRepo serviceRepo) {
        this.bankRepo = bankRepo;
        this.branchRepo = branchRepo;
        this.serviceRepo = serviceRepo;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<String> bankNames = Arrays.asList(
            "State Bank of India", "HDFC Bank", "ICICI Bank", "Axis Bank", "Punjab National Bank"
        );

        List<Bank> banks = new ArrayList<>();
        List<Branch> branches = new ArrayList<>();
        List<Services> services = new ArrayList<>();

        for (String bankName : bankNames) {
            // Check if the bank already exists
            Bank bank = bankRepo.findByName(bankName).orElse(null);
            if (bank == null) {
                // Create a new Bank if it doesn't exist
                bank = new Bank();
                bank.setName(bankName);
                bankRepo.save(bank);
            }
            banks.add(bank);

            // Create Branches for each Bank
            for (int i = 1; i <= 10; i++) {
                String branchName = bankName + " Branch " + i;
                // Check if the branch already exists for this bank
                if (!branchRepo.existsByNameAndBank(branchName, bank)) {
                    Branch branch = new Branch();
                    branch.setName(branchName);
                    branch.setAddress(i * 100 + " " + bankName + " St, Bangalore");
                    branch.setBank(bank);
                    branches.add(branch);
                }
            }

            // Create Services for each Bank
            List<String> serviceDescriptions = getServiceDescriptionsForBank(bankName);
            for (String description : serviceDescriptions) {
                // Check if the service already exists for this bank
                if (!serviceRepo.existsByDescriptionAndBank(description, bank)) {
                    services.add(createService(description, bank));
                }
            }
        }

        // Save branches and services
        branchRepo.saveAll(branches);
        serviceRepo.saveAll(services);
    }

    private List<String> getServiceDescriptionsForBank(String bankName) {
        switch (bankName) {
            case "State Bank of India":
                return Arrays.asList("Online Banking", "ATM Services", "Home Loans", "Personal Loans", "Corporate Loans",
                                     "Fixed Deposits", "Savings Accounts", "Current Accounts", "Wealth Management", "Insurance");
            case "HDFC Bank":
                return Arrays.asList("Online Banking", "ATM Services", "Personal Loans", "Credit Cards", "Home Loans",
                                     "Business Loans", "Insurance", "Investment Services", "Savings Accounts", "Current Accounts");
            case "ICICI Bank":
                return Arrays.asList("Online Banking", "ATM Services", "Home Loans", "Personal Loans", "Auto Loans",
                                     "Credit Cards", "Savings Accounts", "Current Accounts", "Investment Services", "Insurance");
            case "Axis Bank":
                return Arrays.asList("Online Banking", "ATM Services", "Home Loans", "Personal Loans", "Auto Loans",
                                     "Credit Cards", "Savings Accounts", "Current Accounts", "Investment Services", "Insurance");
            case "Punjab National Bank":
                return Arrays.asList("Online Banking", "ATM Services", "Home Loans", "Personal Loans", "Education Loans",
                                     "Fixed Deposits", "Savings Accounts", "Current Accounts", "Insurance", "Investment Services");
            default:
                return Arrays.asList("General Banking Services");
        }
    }

    private Services createService(String description, Bank bank) {
        Services service = new Services();
        service.setDescription(description);
        service.setBank(bank);
        return service;
    }

}
