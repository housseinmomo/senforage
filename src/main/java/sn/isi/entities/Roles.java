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

@Entity
public class Roles implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	
	// Roles : (idRole int, role varchar (50))
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idRole;
	@Column(length = 120, nullable = false)
	private String role;
	
	@OneToMany(mappedBy = "role")
	private List<GESTCLIENTELE> gestClients = new ArrayList<GESTCLIENTELE>();
	@OneToMany(mappedBy = "role")
	private List<GESTCOMMERCIALE> gestCommerciales = new ArrayList<GESTCOMMERCIALE>();
	@OneToMany(mappedBy = "role")
	private List<GESTCOMPTEUR> gestCompteurs = new ArrayList<GESTCOMPTEUR>();
	
	public Roles(int idRole, String role) {
		super();
		this.idRole = idRole;
		this.role = role;
	}
	
	

	public Roles(String role) {
		super();
		this.role = role;
	}
	
	
	public Roles() {
		super();
	}



	public int getIdRole() {
		return idRole;
	}

	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
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
		return "Roles [idRole=" + idRole + ", role=" + role + ", gestClients=" + gestClients + ", gestCommerciales="
				+ gestCommerciales + ", gestCompteurs=" + gestCompteurs + ", getIdRole()=" + getIdRole()
				+ ", getRole()=" + getRole() + ", getGestClients()=" + getGestClients() + ", getGestCommerciales()="
				+ getGestCommerciales() + ", getGestCompteurs()=" + getGestCompteurs() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
	
	

}
