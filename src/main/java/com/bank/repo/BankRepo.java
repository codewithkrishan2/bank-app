package com.bank.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.entity.Bank;

public interface BankRepo extends JpaRepository<Bank, Integer> {

	Optional<Bank> findByName(String name);
}
