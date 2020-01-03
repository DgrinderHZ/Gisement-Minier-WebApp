package com.gmz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.gmz.DAO.HumainRepository;
import com.gmz.entity.Humain;

@Controller
public class HumainController {
	@Autowired
	HumainRepository humainRepo;
	
	/**************** Les Methodes permettant d'extraire les informations ************/
	
	@GetMapping(path = "/allHumains")
	public  String getAllHumains(Model model) {
		List<Humain> humains = humainRepo.findAll();
		model.addAttribute("humains", humains);
		return "AllHumains";
	}
	
}
