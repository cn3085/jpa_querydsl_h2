package com.example.demo.home.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicUpdate;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity(name="TB_KIOSK")
@DynamicUpdate //dirty checking. 변경된 필드만 대응
public class KioskEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String kioskId;
	
	private String kioskName;
	private String kioskCode;
	private String floorCode;
	private String dbStatus;
	
	@Builder(builderClassName = "KioskForSingleFloor")
	public KioskEntity(String kioskName, String kioskCode) {
		this.kioskName = kioskName;
		this.kioskCode = kioskCode;
		this.dbStatus = "A";
	}
	
	@Builder(builderClassName = "KioskForMultiFloor")
	public KioskEntity(String kioskName, String kioskCode, String floorCode) {
		this.kioskName = kioskName;
		this.kioskCode = kioskCode;
		this.floorCode = floorCode;
		this.dbStatus = "A";
	}
	
}
