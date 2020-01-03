package com.gmz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.gmz.DAO.RobotRepository;
import com.gmz.entity.Robot;

@Controller
public class RobotController {

	@Autowired
	RobotRepository robotRepo;
	
	/**************** Les Methodes permettant d'extraire les informations ************/
	
	
	@GetMapping(path = "/allRobots")
	public  String getAllRobots(Model model) {
		
		List<Robot> robots = robotRepo.findAll();
		model.addAttribute("robots", robots);
		
		return "AllRobots";
	}
	
}
