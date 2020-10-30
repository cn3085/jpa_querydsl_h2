package com.example.demo.home.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@NoArgsConstructor
@Getter
@ToString
public class CompanyEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String code;
	private String name;
	private String address;
	
	@Builder
	public CompanyEntity(String code, String name, String address) {
		this.code = code;
		this.name = name;
		this.address = address;
	}
	
	public void update(String code, String name, String address) {
		this.code = code;
		this.name = name;
		this.address = address;
	}
}
