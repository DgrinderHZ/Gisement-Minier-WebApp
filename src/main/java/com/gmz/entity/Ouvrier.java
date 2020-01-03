package com.gmz.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Ouvrier {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_ouvrier")
	private int idOuvrier;
	
	@Column(name="nom_ouvrier")
	private String nom;
	
	@Column(name="date_affectation")
	private Date dateAffectation; 

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_equipe")
	private Equipe equipe;
	
	public Ouvrier() {
	}

	public Ouvrier(int idOuvrier, String nom, Date dateAffectation) {
		super();
		this.idOuvrier = idOuvrier;
		this.nom = nom;
		this.dateAffectation = dateAffectation;
	}

	public int getIdOuvrier() {
		return idOuvrier;
	}

	public void setIdOuvrier(int idOuvrier) {
		this.idOuvrier = idOuvrier;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Date getDateAffectation() {
		return dateAffectation;
	}

	public void setDateAffectation(Date dateAffectation) {
		this.dateAffectation = dateAffectation;
	}

	public Equipe getEquipe() {
		return equipe;
	}

	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}

	@Override
	public String toString() {
		return "Ouvrier [idOuvrier=" + idOuvrier + ", nom=" + nom + ", dateAffectation=" + dateAffectation + ", equipe="
				+ equipe + "]";
	}

	public double calculerCoutOuvrier() {
		// Cette méthode est redéfinir dans les sous-classes
		return 0;
	}

	
}
