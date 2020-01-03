package com.gmz.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gmz.DAO.ModeleRepository;
import com.gmz.entity.Modele;

@Controller
public class ModeleController {

	@Autowired
	ModeleRepository modelRepo;
	
	/**************** Les Methodes permettant d'extraire les informations ************/
	
	@GetMapping(path = "/allModeles")
	public  String getAllRobotModels(Model model) {
		List<Modele> listeModeles = modelRepo.findAll();
		model.addAttribute("modeles", listeModeles);
		return "AllModeles";	
		}
	
/**************** Les Methodes permettant d'envoyer les informations vers la base de données ************/

	 @RequestMapping(value="/ajouterModele", method=RequestMethod.GET)
	public String ajouterModele(Model model) {
		 Modele modele = new Modele();
		model.addAttribute("modele", modele);
		return "AjouterModele";
	}
	 
	 @RequestMapping(value="/ajouterModele", method=RequestMethod.POST)
	    public String ajouterModeleProce(@Valid @ModelAttribute Modele modele,Model model) {
	        model.addAttribute("modele", modele);
			modelRepo.save(modele);
	        return "redirect:/allModeles";
	    }
	
}
