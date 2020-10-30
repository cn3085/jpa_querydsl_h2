package com.example.demo.home.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.home.repository.KioskRepository;
import com.example.demo.home.service.BranchService;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	private final KioskRepository kioskRepository;
	private final BranchService branchService;
	
	@Autowired
	public HomeController(KioskRepository kioskRepository, BranchService branchService) {
		this.kioskRepository = kioskRepository;
		this.branchService = branchService;
	}

	@GetMapping("")
	public void home() {

		kioskRepository.getKioskList();
		kioskRepository.createTouchKiosk();
		branchService.createBranch();
	}
}
