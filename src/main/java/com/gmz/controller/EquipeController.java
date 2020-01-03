package com.gmz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.gmz.DAO.EquipeRepository;
import com.gmz.entity.Equipe;

@Controller
public class EquipeController {

	@Autowired
	EquipeRepository equipeRepo;
	
	/**************** Les Methodes permettant d'extraire les informations ************/

	@GetMapping(path = "/allEquipes")
	public String getAllEquipes(Model model) {
		List<Equipe> equipes = equipeRepo.findAll();
		model.addAttribute("equipes", equipes);
		return "AllEquipes";
	}
	
}
