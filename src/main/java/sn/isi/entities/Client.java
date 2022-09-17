package sn.isi.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Client implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	
	// Client : (idClient int, nomFamille varchar (150), #idVillage int, adresse varchar (150), telephone int, #idAbonnement int, #idGestClient int, #idGestCompteur int)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idClient;
	@Column(length = 150, nullable = false)
	private String nomFamille;
	@ManyToOne
	private Village village;
	@Column(length = 150, nullable = false)
	private String adresse;
	@Column(length = 100, nullable = false)
	private int telephone;
	@ManyToOne
	private GESTCLIENTELE gest_client;
	@ManyToOne
	private Abonnement abonnement;
	@ManyToOne
	private GESTCOMPTEUR gest_compteur;
	@OneToMany(mappedBy = "client")
	private List<Facture> factures = new ArrayList<Facture>();
	
	public Client(int idClient, String nomFamille, Village village, String adresse, int telephone,
			GESTCLIENTELE gest_client, Abonnement abonnement, GESTCOMPTEUR gest_compteur) {
		super();
		this.idClient = idClient;
		this.nomFamille = nomFamille;
		this.village = village;
		this.adresse = adresse;
		this.telephone = telephone;
		this.gest_client = gest_client;
		this.abonnement = abonnement;
		this.gest_compteur = gest_compteur;
	}
	
	
	
	
	public Client(String nomFamille, Village village, String adresse, int telephone, GESTCLIENTELE gest_client,
			Abonnement abonnement, GESTCOMPTEUR gest_compteur) {
		super();
		this.nomFamille = nomFamille;
		this.village = village;
		this.adresse = adresse;
		this.telephone = telephone;
		this.gest_client = gest_client;
		this.abonnement = abonnement;
		this.gest_compteur = gest_compteur;
	}




	public Client() {
		super();
	}




	public int getIdClient() {
		return idClient;
	}
	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}
	public String getNomFamille() {
		return nomFamille;
	}
	public void setNomFamille(String nomFamille) {
		this.nomFamille = nomFamille;
	}
	public Village getVillage() {
		return village;
	}
	public void setVillage(Village village) {
		this.village = village;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public int getTelephone() {
		return telephone;
	}
	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}
	public GESTCLIENTELE getGest_client() {
		return gest_client;
	}
	public void setGest_client(GESTCLIENTELE gest_client) {
		this.gest_client = gest_client;
	}
	public Abonnement getAbonnement() {
		return abonnement;
	}
	public void setAbonnement(Abonnement abonnement) {
		this.abonnement = abonnement;
	}
	public GESTCOMPTEUR getGest_compteur() {
		return gest_compteur;
	}
	public void setGest_compteur(GESTCOMPTEUR gest_compteur) {
		this.gest_compteur = gest_compteur;
	}
	public List<Facture> getFactures() {
		return factures;
	}
	public void setFactures(List<Facture> factures) {
		this.factures = factures;
	}
	@Override
	public String toString() {
		return "Client [idClient=" + idClient + ", nomFamille=" + nomFamille + ", village=" + village + ", adresse="
				+ adresse + ", telephone=" + telephone + ", gest_client=" + gest_client + ", abonnement=" + abonnement
				+ ", gest_compteur=" + gest_compteur + ", factures=" + factures + "]";
	}
	
	
	
	
	
}
