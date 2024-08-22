package com.bank.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.entity.Services;

public interface ServiceRepo extends JpaRepository<Services, Integer> {

	List<Services> findByBankName(String bankName);
}
