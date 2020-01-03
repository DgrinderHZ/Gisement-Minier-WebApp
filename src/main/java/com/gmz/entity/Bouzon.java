package com.gmz.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "id_gisement")
public class Bouzon extends Gisement {
	
	@Column(name="coefficient_purte")
	private double coefficientPurte;
	
	public double calculerRevenue() {
		double res = this.getRendementMensuel() * this.coefficientPurte;
		return res;
	}
	
	public double calculerCoutMensuel() {
		double res  = 0;
		for(Equipe e: this.getEquipes()) {
			res += e.calculerCoutEquipe();
		}
		return res;
	}
	
	public double calculerRentabilite() {
		double revenue = this.calculerRevenue();
		double cout = this.calculerCoutMensuel();
		return revenue - cout;
	}
	public Bouzon() {
	}

	public Bouzon(double coefficientPurte) {
		super();
		this.coefficientPurte = coefficientPurte;
	}

	public double getCoefficientPurte() {
		return coefficientPurte;
	}

	public void setCoefficientPurte(double coefficientPurte) {
		this.coefficientPurte = coefficientPurte;
	}
	
}
