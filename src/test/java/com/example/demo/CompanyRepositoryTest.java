package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import com.example.demo.config.QuerydslConfig;
import com.example.demo.home.entity.CompanyEntity;
import com.example.demo.home.repository.CompanyRepository;

import lombok.RequiredArgsConstructor;

@DataJpaTest
@RequiredArgsConstructor
@Import(QuerydslConfig.class)
class CompanyRepositoryTest {
	
	@Autowired
	private CompanyRepository companyRepository;
	
	@BeforeAll
	static void 회사_데이터_저장(@Autowired CompanyRepository companyRepository) {
		CompanyEntity company1 = CompanyEntity.builder().name("망한회사").code("MANG").address("서울시구로구").build();
		CompanyEntity company2 = CompanyEntity.builder().name("성공한회사").code("MANG").address("서울시구로구").build();
		CompanyEntity company3 = CompanyEntity.builder().name("망한회사").code("MANG").address("인천시남동구").build();
		
		companyRepository.save(company1);
		companyRepository.save(company2);
		companyRepository.save(company3);
	}
	
	@Test
	void CREATE_회사() {
		CompanyEntity company = CompanyEntity.builder()
												  .name("망한회사")
												  .code("MANG")
												  .address("서울시구로구")
											  .build();
		companyRepository.save(company);
		
		List<CompanyEntity> savedCompany = companyRepository.findByName("망한회사");
		
		System.out.println(savedCompany);
		assertThat(savedCompany).isNotNull();
	}
	
	@Test
	void SELECT_JPA_회사() {
		List<CompanyEntity> companyList = companyRepository.findAll();
		
		System.out.println(companyList);
		
		assertThat(companyList).hasSize(3);
	}
	
	@Test
	void SELECT_QUERYDSL_회사() {
		List<CompanyEntity> companyList = companyRepository.findInSeoulCompanyLikeName("성공");
		
		System.out.println(companyList);
		
		assertThat(companyList).hasSize(1);
	}
	
	@Test
	void UPDATE_회사() {
		CompanyEntity company = companyRepository.findById(1).orElseThrow(()-> new IllegalArgumentException("존재하지 않는 회사"));
		System.out.println(company);
		company.update("GOOD", "좋은회사", "nowhere");
		
		CompanyEntity savedCompany = companyRepository.findById(1).orElseThrow(()-> new IllegalArgumentException("존재하지 않는 회사"));
		System.out.println(savedCompany);
		
		assertThat(savedCompany.getCode()).isEqualTo("GOOD");
		assertThat(savedCompany.getName()).isEqualTo("좋은회사");
		assertThat(savedCompany.getAddress()).isEqualTo("nowhere");
	}
	
	@Test
	void DELETE_회사() {
		CompanyEntity company = companyRepository.findById(1).orElseThrow(()-> new IllegalArgumentException("존재하지 않는 회사"));
		
		companyRepository.delete(company);
		
		CompanyEntity savedCompany = companyRepository.findById(1).orElseThrow(()-> new IllegalArgumentException("존재하지 않는 회사"));
	}
	
	
	
	
}
