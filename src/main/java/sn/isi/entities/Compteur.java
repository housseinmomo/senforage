package sn.isi.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Compteur implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	
	// Compteur : (idCompteur int, cumulConso double, #idClient int)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCompteur;
	@Column
	private double cumulConso;
	@OneToOne
	private Client client;
	
	public Compteur(int idCompteur, double cumulConso, Client client) {
		super();
		this.idCompteur = idCompteur;
		this.cumulConso = cumulConso;
		this.client = client;
	}
	
	

	public Compteur(double cumulConso, Client client) {
		super();
		this.cumulConso = cumulConso;
		this.client = client;
	}
	

	public Compteur() {
		super();
	}



	public int getIdCompteur() {
		return idCompteur;
	}

	public void setIdCompteur(int idCompteur) {
		this.idCompteur = idCompteur;
	}

	public double getCumulConso() {
		return cumulConso;
	}

	public void setCumulConso(double cumulConso) {
		this.cumulConso = cumulConso;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public String toString() {
		return "Compteur [idCompteur=" + idCompteur + ", cumulConso=" + cumulConso + ", client=" + client + "]";
	}
	
	
	

	
	
	
}
