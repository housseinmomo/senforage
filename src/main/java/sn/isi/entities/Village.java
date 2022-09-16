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
public class Village implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	
	// Village : (idVillage int, nomVillage varchar (150), chefVillage varchar (150))
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idVillage;
	@Column(length = 150 , nullable = false)
	private String nomVillage;
	@Column(length = 150 , nullable = false)
	private String chefVillage;
	@OneToMany(mappedBy = "village")
	private List<Client> clients = new ArrayList<Client>();
	
	public Village(int idVillage, String nomVillage, String chefVillage) {
		super();
		this.idVillage = idVillage;
		this.nomVillage = nomVillage;
		this.chefVillage = chefVillage;
		
	}

	
	public Village(String nomVillage, String chefVillage) {
		super();
		this.nomVillage = nomVillage;
		this.chefVillage = chefVillage;
	}
	
	


	public Village() {
		super();
	}


	public int getIdVillage() {
		return idVillage;
	}

	public void setIdVillage(int idVillage) {
		this.idVillage = idVillage;
	}

	public String getNomVillage() {
		return nomVillage;
	}

	public void setNomVillage(String nomVillage) {
		this.nomVillage = nomVillage;
	}

	public String getChefVillage() {
		return chefVillage;
	}

	public void setChefVillage(String chefVillage) {
		this.chefVillage = chefVillage;
	}

	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	@Override
	public String toString() {
		return "Village [idVillage=" + idVillage + ", nomVillage=" + nomVillage + ", chefVillage=" + chefVillage
				+ ", clients=" + clients + ", getIdVillage()=" + getIdVillage() + ", getNomVillage()=" + getNomVillage()
				+ ", getChefVillage()=" + getChefVillage() + ", getClients()=" + getClients() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
	
	
	
}
