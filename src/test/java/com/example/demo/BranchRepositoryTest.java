package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.demo.config.QuerydslConfig;
import com.example.demo.home.entity.BranchEntity;
import com.example.demo.home.service.BranchService;

import lombok.extern.log4j.Log4j2;

@DataJpaTest // JPA 관련 빈들만 등록
@ComponentScan("com.example.demo.home.repository") //JpaRepository를 구현하지 않고 있기 때문에 자동으로 scan 안 됨. 수동으로 스캔
@Import(QuerydslConfig.class)
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Log4j2
class BranchRepositoryTest {
	
	@Autowired
	private BranchService branchRepository;
	
	@Test 
	void getBranchList() {
		List<BranchEntity> branchList = branchRepository.getBranchListWhereDbstatusA();
		
		assertThat(branchList).hasSize(2);
	}
	
	@Test
	void isRepostory인스턴스_타입_체크() {
		assertThat(branchRepository).isInstanceOf(BranchService.class);
	}

}
