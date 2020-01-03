package com.gmz.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Gisement {

	@Id
	@Column(name="id_gisement")
	private int idGisement;
	
	@Column(name="date_mise_en_service")
	private Date dateMiseEnServive;
	
	@Column(name="rendement_mensuel")
	private double rendementMensuel;
	
	@OneToMany(mappedBy = "gisement", fetch = FetchType.LAZY, cascade =  CascadeType.ALL)
	private List<Equipe> equipes;
	
	public Gisement() {
	}

	public Gisement(int idGisement, Date dateMiseEnServive, double rendementMensuel) {
		super();
		this.idGisement = idGisement;
		this.dateMiseEnServive = dateMiseEnServive;
		this.rendementMensuel = rendementMensuel;
	}

	public int getIdGisement() {
		return idGisement;
	}

	public void setIdGisement(int idGisement) {
		this.idGisement = idGisement;
	}

	public Date getDateMiseEnServive() {
		return dateMiseEnServive;
	}

	public void setDateMiseEnServive(Date dateMiseEnServive) {
		this.dateMiseEnServive = dateMiseEnServive;
	}

	public double getRendementMensuel() {
		return rendementMensuel;
	}

	public void setRendementMensuel(double rendementMensuel) {
		this.rendementMensuel = rendementMensuel;
	}

	public List<Equipe> getEquipes() {
		return equipes;
	}

	public void setEquipes(List<Equipe> equipes) {
		this.equipes = equipes;
	}
	
	public double calculerRevenue() {
		// Cette méthode est redéfinir dans les sous-classes
        return 0;
	}
	
	public double calculerCoutMensuel() {
		// Cette méthode est redéfinir dans les sous-classes
		return 0;
	}
	
	public double calculerRentabilite() {
		// Cette méthode est redéfinir dans les sous-classes
		return 0;
	}

}
