package com.gmz.entity;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "id_ouvrier")
public class Humain extends Ouvrier {
	
	private double salaire;
	
	public double calculerCoutOuvrier() {
		return (this.salaire + 5000);
	}
	
	public Humain() {
	}
	
	public Humain(double salaire) {
		super();
		this.salaire = salaire;
	}
	public double getSalaire() {
		return salaire;
	}
	public void setSalaire(double salaire) {
		this.salaire = salaire;
	}

	@Override
	public String toString() {
		return "Humain "+ this.getIdOuvrier() + ":     Nom :"+ this.getNom()+ ", salaire: " + salaire + ", Date d'affectation: " + this.getDateAffectation() + ", Equipe: "+ this.getEquipe().getNomEquipe();
	}
	
	
}
