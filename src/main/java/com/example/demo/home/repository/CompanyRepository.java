package com.example.demo.home.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.home.entity.CompanyEntity;

public interface CompanyRepository extends JpaRepository<CompanyEntity, Integer>, CompanyCustomRepository {
	public List<CompanyEntity> findByName(String name);
}
