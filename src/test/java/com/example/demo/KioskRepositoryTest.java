package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.demo.config.QuerydslConfig;
import com.example.demo.home.entity.KioskEntity;
import com.example.demo.home.repository.KioskRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@Import(QuerydslConfig.class)
@AutoConfigureTestDatabase(replace = Replace.NONE)
class KioskRepositoryTest {

	@Autowired
	private KioskRepository kioskRepository;
	
	@Test
	void querydsl() {
		List<KioskEntity> list = kioskRepository.getKioskList();
		assertThat(list).hasSize(36);
	}
}
