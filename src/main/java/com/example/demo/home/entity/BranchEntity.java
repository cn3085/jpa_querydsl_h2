package com.example.demo.home.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity(name = "TB_BRANCH")
public class BranchEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer brnId;
	
	private String brnCode;
	private String brnName;
	private String dbStatus;
	
	@Builder
	public BranchEntity(String brnCode, String brnName, String dbStatus) {
		this.brnCode = brnCode;
		this.brnName = brnName;
		this.dbStatus = dbStatus;
	}

}
