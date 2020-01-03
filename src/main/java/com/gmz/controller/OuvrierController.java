package com.gmz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.gmz.DAO.OuvrierRepository;
import com.gmz.entity.Ouvrier;

@Controller
public class OuvrierController {

	@Autowired
	OuvrierRepository ouvrierRepo;
	
	
	/**************** Les Methodes permettant d'extraire les informations ************/

	@GetMapping(path = "/allOuvriers")
	public  String getAllOuvriers(Model model) {
		List<Ouvrier> ouvriers = ouvrierRepo.findAll();
		model.addAttribute("ouvriers", ouvriers);
		return "AllOuvriers";	
	}
	
}
