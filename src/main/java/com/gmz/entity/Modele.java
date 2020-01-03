package com.gmz.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Modele {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_modele")
	private int idModel;
	
	@Column(name="date_de_conception")
	private Date conception;
	
	@Column(name="cout_exploitation_mensuel")
	private double coutExplMensuel;
	

	public Modele() {
		
	}

	public Modele(int idModel, Date conception, double coutExplMensuel) {
		super();
		this.idModel = idModel;
		this.conception = conception;
		this.coutExplMensuel = coutExplMensuel;
	}


	public int getIdModel() {
		return idModel;
	}


	public void setIdModel(int idModel) {
		this.idModel = idModel;
	}


	public Date getConception() {
		return conception;
	}


	public void setConception(Date conception) {
		this.conception = conception;
	}


	public double getCoutExplMensuel() {
		return coutExplMensuel;
	}


	public void setCoutExplMensuel(double coutExplMensuel) {
		this.coutExplMensuel = coutExplMensuel;
	}

	@Override
	public String toString() {
		return "Modele " + idModel + ": Date de conception : " + conception + ", coût d'exploitation mensuel : " + coutExplMensuel ;
	}

	
}
