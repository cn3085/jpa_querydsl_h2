package com.example.demo.home.repository;

import java.util.List;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import com.example.demo.home.entity.CompanyEntity;
import com.example.demo.home.entity.QCompanyEntity;
import com.querydsl.jpa.impl.JPAQueryFactory;


public class CompanyRepositoryImpl extends QuerydslRepositorySupport implements CompanyCustomRepository {

	private final JPAQueryFactory queryFactory;
	
	public CompanyRepositoryImpl(JPAQueryFactory queryFactory) {
		super(CompanyEntity.class);
		this.queryFactory = queryFactory;
	}

	@Override
	public List<CompanyEntity> findInSeoulCompanyLikeName(String name) {
		
		QCompanyEntity company = QCompanyEntity.companyEntity;
		
		return queryFactory.selectFrom(company)
								.where(company.address.contains("서울")
									.and(company.name.like("%" + name + "%")))
								.fetch();
	}
	
	
}
