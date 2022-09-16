package sn.isi.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Admin implements Serializable{
	
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	
	// ADMIN : (idAdmin int, nom varchar (50), prenom varchar (50), email varchar (50), mdp varchar (150), etat bool, #idRole int)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idAdmin;
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
	
	@OneToOne // un admin a un seule role
	private Roles role;
	
	@OneToMany(mappedBy = "admin")
	private List<GESTCLIENTELE> gestClients = new ArrayList<GESTCLIENTELE>();
	@OneToMany(mappedBy = "admin")
	private List<GESTCOMMERCIALE> gestCommerciales = new ArrayList<GESTCOMMERCIALE>();
	@OneToMany(mappedBy = "admin")
	private List<GESTCOMPTEUR> gestCompteurs = new ArrayList<GESTCOMPTEUR>();
	public Admin(int idAdmin, String nom, String prenom, String email, String mdp, Boolean etat, Roles role,
			List<GESTCLIENTELE> gestClients, List<GESTCOMMERCIALE> gestCommerciales, List<GESTCOMPTEUR> gestCompteurs) {
		super();
		this.idAdmin = idAdmin;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.mdp = mdp;
		this.etat = etat;
		this.role = role;
		this.gestClients = gestClients;
		this.gestCommerciales = gestCommerciales;
		this.gestCompteurs = gestCompteurs;
	}
	public int getIdAdmin() {
		return idAdmin;
	}
	public void setIdAdmin(int idAdmin) {
		this.idAdmin = idAdmin;
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
	public List<GESTCLIENTELE> getGestClients() {
		return gestClients;
	}
	public void setGestClients(List<GESTCLIENTELE> gestClients) {
		this.gestClients = gestClients;
	}
	public List<GESTCOMMERCIALE> getGestCommerciales() {
		return gestCommerciales;
	}
	public void setGestCommerciales(List<GESTCOMMERCIALE> gestCommerciales) {
		this.gestCommerciales = gestCommerciales;
	}
	public List<GESTCOMPTEUR> getGestCompteurs() {
		return gestCompteurs;
	}
	public void setGestCompteurs(List<GESTCOMPTEUR> gestCompteurs) {
		this.gestCompteurs = gestCompteurs;
	}
	@Override
	public String toString() {
		return "Admin [idAdmin=" + idAdmin + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", mdp=" + mdp
				+ ", etat=" + etat + ", role=" + role + ", gestClients=" + gestClients + ", gestCommerciales="
				+ gestCommerciales + ", gestCompteurs=" + gestCompteurs + "]";
	}
	
	
	
	
	
	
	
	
}
