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
public class GESTCOMPTEUR implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	
	// GESTCOMPTEUR : (idGestCompteur int, nom varchar (50), prenom varchar (50), email varchar (50), mdp varchar (150), etat bool, #idRole int, #idAdmin int)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idGestCompteur;
	@Column(length = 50 , nullable = false)
	private String nom;
	@Column(length = 50 , nullable = false)
	private String prenom;
	@Column(length = 50 , nullable = false)
	private String email;
	@Column(length = 150 , nullable = false)
	private String mdp;
	@Column
	private Boolean etat;
	@ManyToOne	// Un gestionnaire compteur peuvent avoir le meme role
	private Roles role;
	@ManyToOne	// plusieurs gestionnaires compteurs peuvent etre creer par un seule admin
	private Admin admin;
	@OneToMany(mappedBy = "gest_compteur")
	private List<Client> clients = new ArrayList<Client>();
	public GESTCOMPTEUR(int idGestCompteur, String nom, String prenom, String email, String mdp, Boolean etat,
			Roles role, Admin admin, List<Client> clients) {
		super();
		this.idGestCompteur = idGestCompteur;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.mdp = mdp;
		this.etat = etat;
		this.role = role;
		this.admin = admin;
		this.clients = clients;
	}
	public int getIdGestCompteur() {
		return idGestCompteur;
	}
	public void setIdGestCompteur(int idGestCompteur) {
		this.idGestCompteur = idGestCompteur;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	public Boolean getEtat() {
		return etat;
	}
	public void setEtat(Boolean etat) {
		this.etat = etat;
	}
	public Roles getRole() {
		return role;
	}
	public void setRole(Roles role) {
		this.role = role;
	}
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public List<Client> getClients() {
		return clients;
	}
	public void setClients(List<Client> clients) {
		this.clients = clients;
	}
	@Override
	public String toString() {
		return "GESTCOMPTEUR [idGestCompteur=" + idGestCompteur + ", nom=" + nom + ", prenom=" + prenom + ", email="
				+ email + ", mdp=" + mdp + ", etat=" + etat + ", role=" + role + ", admin=" + admin + ", clients="
				+ clients + "]";
	}
	
	

	
	
	

}
