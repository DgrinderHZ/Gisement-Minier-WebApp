package com.gmz.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Equipe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEquipe;
	
	@Column(name="nom_equipe")
	private String nomEquipe;
	
	
	@OneToMany(mappedBy = "equipe", fetch = FetchType.LAZY, cascade =  CascadeType.ALL)
	private List<Ouvrier> ouvriers;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "chef_id")
	private Humain chefProjet;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_gisement")
	private Gisement gisement;
	
	public double calculerCoutEquipe() {
		double res = 0;
		for(Ouvrier o : this.ouvriers) {
			res += o.calculerCoutOuvrier();
		}
		return res;
	}
	
	public Equipe() {
		
	}


	public Equipe(int idEquipe, String nomEquipe, int nombreOuvrier) {
		super();
		this.idEquipe = idEquipe;
		this.nomEquipe = nomEquipe;
	}

	
	public int getIdEquipe() {
		return idEquipe;
	}

	public void setIdEquipe(int idEquipe) {
		this.idEquipe = idEquipe;
	}

	public String getNomEquipe() {
		return nomEquipe;
	}

	public void setNomEquipe(String nomEquipe) {
		this.nomEquipe = nomEquipe;
	}

	
	public List<Ouvrier> getOuvriers() {
		return ouvriers;
	}

	public void setOuvriers(List<Ouvrier> ouvriers) {
		this.ouvriers = ouvriers;
	}

	public Humain getChefProjet() {
		return chefProjet;
	}

	public void setChefProjet(Humain chefProjet) {
		this.chefProjet = chefProjet;
	}

	public Gisement getGisement() {
		return gisement;
	}

	public void setGisement(Gisement gisement) {
		this.gisement = gisement;
	}

	@Override
	public String toString() {
		return "Equipe " + idEquipe + ": nomEquipe: " + nomEquipe + ", chef d'équipe: "
				+ chefProjet + ", gisement: " + (gisement.getIdGisement() == 1? "Bouzon" :"HzK2");
	}

	

}
