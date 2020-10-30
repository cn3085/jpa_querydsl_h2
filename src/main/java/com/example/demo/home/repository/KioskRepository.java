package com.example.demo.home.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import com.example.demo.home.entity.KioskEntity;
import com.example.demo.home.entity.QKioskEntity;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
public class KioskRepository extends QuerydslRepositorySupport {

	@PersistenceContext
	private EntityManager entityManager;
	
	private final JPAQueryFactory queryFactory;
	
	public KioskRepository(JPAQueryFactory queryFactory) {
		super(KioskEntity.class);
		this.queryFactory = queryFactory;
	}
	
	public List<KioskEntity> getKioskList() {
		QKioskEntity kiosk = QKioskEntity.kioskEntity;
		return queryFactory.selectFrom(kiosk).where(kiosk.dbStatus.eq("A")).fetch();
		
	}
	
	@Transactional
	public void createTouchKiosk() {
		KioskEntity kiosk = KioskEntity.builder()
											.kioskName("지하1층세로형")
											.kioskCode("KIOSK01")
										.build();
		entityManager.persist(kiosk);
	}
	
	public void getKioskListWhenDBStatusA() {
		
	}
	
	
}
