package com.gmz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.gmz.DAO.GisementRepository;
import com.gmz.entity.Gisement;

@Controller
public class GisementController {

	@Autowired
	GisementRepository gisementRepo;

	
	/**************** Les Methodes permettant d'extraire les informations ************/
	
	@GetMapping(path = "/allGisements")
	public  String getAllGisements(Model model) {
		List<Gisement> gisements = gisementRepo.findAll();
		model.addAttribute("gisements", gisements);
		return "Gisement";
	}
	
}
