package com.bank.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.entity.Bank;
import com.bank.entity.Branch;

public interface BranchRepo extends JpaRepository<Branch, Integer> {

	List<Branch> findByBankName(String bankName);
	boolean existsByNameAndBank(String name, Bank bank);
}
