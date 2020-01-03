package com.gmz.entity;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;



@Entity
@PrimaryKeyJoinColumn(name = "id_gisement")
public class Hzk2 extends Gisement {
	
	private double densite ;

	public double calculerRevenue() {
		double res = this.getRendementMensuel() * this.densite * 18.987;
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
	
	public Hzk2() {
	}

	public Hzk2(double densite) {
		super();
		this.densite = densite;
	}

	public double getDensite() {
		return densite;
	}

	public void setDensite(double densite) {
		this.densite = densite;
	}

	@Override
	public String toString() {
		return "Hzk2 [densite=" + densite + "]";
	}
	

}
