package com.example.demo.home.service;

import java.util.List;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import com.example.demo.home.entity.BranchEntity;
import com.example.demo.home.entity.QBranchEntity;
import com.example.demo.home.repository.BranchRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
public class BranchService {
	
	private final JPAQueryFactory queryFactory;
	private final BranchRepository branchRepository;
	
	public BranchService(JPAQueryFactory queryFactory, BranchRepository branchRepository) {
		this.queryFactory = queryFactory;
		this.branchRepository = branchRepository;
	}
	
	public List<BranchEntity> getBranchListWhereDbstatusA(){
		QBranchEntity branch = QBranchEntity.branchEntity;
		
		return queryFactory.selectFrom(branch).where(branch.dbStatus.eq("A")).fetch();
	}
	
	public BranchEntity getBranchById() {
		QBranchEntity branch = QBranchEntity.branchEntity;
		
		return queryFactory.selectFrom(branch).where(branch.brnId.eq(1)).fetchOne();
	}
	
	public void createBranch() {
		BranchEntity branch = BranchEntity.builder().brnCode("TEST").brnName("myName").dbStatus("A").build();
		branchRepository.save(branch);
	}
}
