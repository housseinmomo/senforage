package sn.isi.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
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
public class Abonnement implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	
	// Abonnement : (idAbonnement int, dateAbonnement DateTime, Description varchar (255), #idGestClient int)
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idAbonnement;
	@Column
	private LocalDate dateAbonnement;
	@Column(length = 255, nullable = false)
	private String description;
	@ManyToOne
	private GESTCLIENTELE gest_client;
	@OneToMany(mappedBy = "abonnement")
	private List<Client> clients = new ArrayList<Client>();
	
	public Abonnement(int idAbonnement, LocalDate dateAbonnement, String description, GESTCLIENTELE gest_client) {
		super();
		this.idAbonnement = idAbonnement;
		this.dateAbonnement = dateAbonnement;
		this.description = description;
		this.gest_client = gest_client;
		
	}
	
	

	public Abonnement(LocalDate dateAbonnement, String description, GESTCLIENTELE gest_client) {
		super();
		this.dateAbonnement = dateAbonnement;
		this.description = description;
		this.gest_client = gest_client;
	}
	
	



	public Abonnement() {
		super();
	}



	public int getIdAbonnement() {
		return idAbonnement;
	}

	public void setIdAbonnement(int idAbonnement) {
		this.idAbonnement = idAbonnement;
	}

	public LocalDate getDateAbonnement() {
		return dateAbonnement;
	}

	public void setDateAbonnement(LocalDate dateAbonnement) {
		this.dateAbonnement = dateAbonnement;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public GESTCLIENTELE getGest_client() {
		return gest_client;
	}

	public void setGest_client(GESTCLIENTELE gest_client) {
		this.gest_client = gest_client;
	}

	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	@Override
	public String toString() {
		return "Abonnement [idAbonnement=" + idAbonnement + ", dateAbonnement=" + dateAbonnement + ", description="
				+ description + ", gest_client=" + gest_client + ", clients=" + clients + "]";
	}
	
	
	
	

	
}
