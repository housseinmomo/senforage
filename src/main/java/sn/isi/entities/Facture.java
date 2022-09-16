package sn.isi.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Facture implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	
	// Facture : (idFacture int, consoMensuelle double, prixLitre double, sommeChiffre double, sommeLettre varchar (255), #idGestCommerciale int, #idClient int)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idFacture;
	@Column(nullable = false)
	private double consoMensuelle;
	@Column(nullable = false)
	private double sommeChiffre;
	@Column(length = 200, nullable = false)
	private String sommeLettre;
	@ManyToOne // plusieurs factures peuvent etre enregistrer par le gestionnaire commerciale
	private GESTCOMMERCIALE gest_commerciale;
	@ManyToOne
	private Client client;
	
	public Facture(int idFacture, double consoMensuelle, double sommeChiffre, String sommeLettre,
			GESTCOMMERCIALE gest_commerciale, Client client) {
		super();
		this.idFacture = idFacture;
		this.consoMensuelle = consoMensuelle;
		this.sommeChiffre = sommeChiffre;
		this.sommeLettre = sommeLettre;
		this.gest_commerciale = gest_commerciale;
		this.client = client;
	}

	public int getIdFacture() {
		return idFacture;
	}

	public void setIdFacture(int idFacture) {
		this.idFacture = idFacture;
	}

	public double getConsoMensuelle() {
		return consoMensuelle;
	}

	public void setConsoMensuelle(double consoMensuelle) {
		this.consoMensuelle = consoMensuelle;
	}

	public double getSommeChiffre() {
		return sommeChiffre;
	}

	public void setSommeChiffre(double sommeChiffre) {
		this.sommeChiffre = sommeChiffre;
	}

	public String getSommeLettre() {
		return sommeLettre;
	}

	public void setSommeLettre(String sommeLettre) {
		this.sommeLettre = sommeLettre;
	}

	public GESTCOMMERCIALE getGest_commerciale() {
		return gest_commerciale;
	}

	public void setGest_commerciale(GESTCOMMERCIALE gest_commerciale) {
		this.gest_commerciale = gest_commerciale;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public String toString() {
		return "Facture [idFacture=" + idFacture + ", consoMensuelle=" + consoMensuelle + ", sommeChiffre="
				+ sommeChiffre + ", sommeLettre=" + sommeLettre + ", gest_commerciale=" + gest_commerciale + ", client="
				+ client + "]";
	}
	
	
	
	
	
}
