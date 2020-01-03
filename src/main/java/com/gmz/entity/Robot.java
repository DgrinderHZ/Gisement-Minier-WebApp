package com.gmz.entity;


import java.sql.Date;
import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "id_ouvrier")
public class Robot extends Ouvrier {
	
	
	private int numeroSerie ;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_model")
	private Modele model;

	public int getNombreDeJours() {
		Date aujourdhui = new Date(Calendar.getInstance().getTime().getTime());
		int nbr = (int) (aujourdhui.getTime() - this.getDateAffectation().getTime())/(1000*60*60*24);
		return nbr;
	}
	
	public double calculerCoutOuvrier() {
		
		int nbJourTravail =  getNombreDeJours();
		double res = this.model.getCoutExplMensuel() + 0.3546 * nbJourTravail;
		return res;
	}
	
	public Robot() {
	}

	public Robot(int numeroSerie) {
		super();
		this.numeroSerie = numeroSerie;
	}

	public int getNumeroSerie() {
		return numeroSerie;
	}

	public void setNumeroSerie(int numeroSerie) {
		this.numeroSerie = numeroSerie;
	}

	public Modele getModel() {
		return model;
	}

	public void setModel(Modele model) {
		this.model = model;
	}

	@Override
	public String toString() {
		return "Robot "+ this.getIdOuvrier() + ":     Nom :"+ this.getNom()+ ", N° serie: " + numeroSerie + ", Date d'affectation: " + this.getDateAffectation() + ", Equipe: "+ this.getEquipe().getNomEquipe();
	}

	
	
}
