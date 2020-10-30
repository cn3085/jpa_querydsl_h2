package com.example.demo.home.repository;

import java.util.List;

import com.example.demo.home.entity.CompanyEntity;

public interface CompanyCustomRepository {
	
	List<CompanyEntity> findInSeoulCompanyLikeName(String name);
}
