package main;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import hibernate.session.SessionHib;
import sn.isi.dao.AbonnementImpl;
import sn.isi.dao.AdminImpl;
import sn.isi.dao.ClientImpl;
import sn.isi.dao.CompteurImpl;
import sn.isi.dao.FactureImpl;
import sn.isi.dao.GESTCLIENTEImpl;
import sn.isi.dao.GESTCOMMERCIALEImpl;
import sn.isi.dao.GESTCOMPTEURImpl;
import sn.isi.dao.RolesImpl;
import sn.isi.dao.VillageImpl;
import sn.isi.entities.Abonnement;
import sn.isi.entities.Admin;
import sn.isi.entities.Client;
import sn.isi.entities.Compteur;
import sn.isi.entities.Facture;
import sn.isi.entities.GESTCLIENTELE;
import sn.isi.entities.GESTCOMMERCIALE;
import sn.isi.entities.GESTCOMPTEUR;
import sn.isi.entities.Roles;
import sn.isi.entities.Village;

public class testApp {

	public static void main(String[] args) {
		
		// Objet DAO
		VillageImpl daoVillage = new VillageImpl();
		RolesImpl daoRoles = new RolesImpl();
		AdminImpl daoAdmin = new AdminImpl();
		GESTCLIENTEImpl daoGestClient = new GESTCLIENTEImpl();
		GESTCOMMERCIALEImpl daoGestCommerciale = new GESTCOMMERCIALEImpl();
		GESTCOMPTEURImpl daoGestCompteur = new GESTCOMPTEURImpl();
		AbonnementImpl daoAbonnment = new AbonnementImpl();
		ClientImpl daoClient = new ClientImpl();
		CompteurImpl daoCompteur = new CompteurImpl();
		FactureImpl daoFacture = new FactureImpl();
		
		//Initialisation des villages
		Village djibouti = new Village("Obock", "Ali Med Adou");
		Village dakar = new Village("dakar", "Ibrahima Diop");
		Village mali = new Village("bamako", "Youssou Mbop");
		Village ethiopie = new Village("Polo Mikael", "Sangasu Hamara");
		
		// Initialisation des roles 
		Roles ROLE_ADMIN = new Roles("ROLE_ADMIN");
		Roles ROLE_GESCLIENTELE = new Roles("ROLE_GESCLIENTELE");
		Roles ROLE_GESCOMMERCIALE = new Roles("ROLE_GESCOMMERCIALE");
		Roles ROLE_GESCOMPTEUR = new Roles("ROLE_GESCOMPTEUR");
		
		// Initialisation des utilisateurs
		Admin admin = 
				new Admin("Abdoulfatah", "Houssein", "smrobla34@gmail.com", "malyoun123", true, ROLE_ADMIN);
		GESTCLIENTELE gestClient = 
				new GESTCLIENTELE("Ahmed","Youssoupha","youah@gmail.com","pass@123", true, ROLE_GESCLIENTELE, admin);
		GESTCOMPTEUR gestCompteur = 
				new GESTCOMPTEUR("Hasna", "Mohamed", "hasna12@gmail.com", "hasnamo@123", true, ROLE_GESCOMPTEUR, admin);
		GESTCOMMERCIALE gestCommerciale =
				new GESTCOMMERCIALE("Houssein", "Kaire", "housskaire@gmail.com", "houss93", true, ROLE_GESCOMMERCIALE, admin);;
		
		// Initialisation des abonnements 
				
		LocalDate date = LocalDate.now(); // Recuperer la date et l'heure courante 		   
		Abonnement abonnement1 = new Abonnement(date , "Abonnement niveau 01", gestClient);
		Abonnement abonnement2 = new Abonnement(date , "Abonnement niveau 02", gestClient);
		Abonnement abonnement3 = new Abonnement(date , "Abonnement niveau 03", gestClient);
		
		// Initialisations des clients 
		Client client1 = new Client("Ekobe", djibouti, "CCO", 77157979, gestClient, abonnement1, gestCompteur);
		Client client2 = new Client("Bouh", dakar, "TML", 77125424, gestClient, abonnement2, gestCompteur);
		Client client3 = new Client("Charlotte", mali, "HTML", 77129384, gestClient, abonnement1, gestCompteur);
		Client client4 = new Client("Ekobe", ethiopie, "KTM", 77983452, gestClient, abonnement3, gestCompteur);
		
		// Initialisation des Compteurs 
		Compteur compteur1 = new Compteur(60, client1);
		Compteur compteur2 = new Compteur(30, client2);
		Compteur compteur3 = new Compteur(120, client3);
		Compteur compteur4 = new Compteur(40, client4);
		
		// Initialisation des factures 
		Facture facture1 = new Facture(60 , 2, 120, "cent vingt mille", gestCommerciale, client1);
		Facture facture2 = new Facture(30 , 3, 90, "quatre vingt dix mille", gestCommerciale, client2);
		Facture facture3 = new Facture(120 , 2, 240, "deux cent quarante mille", gestCommerciale, client3);
		Facture facture4 = new Facture(40 , 3, 120, "cent vingt mille", gestCommerciale, client4);
		
		// Enregistrement des roles dans la base de donnees 
		daoRoles.create(ROLE_ADMIN);
		daoRoles.create(ROLE_GESCLIENTELE);
		daoRoles.create(ROLE_GESCOMMERCIALE);
		daoRoles.create(ROLE_GESCOMPTEUR);
		
		// Enregistrement des villages 
		daoVillage.create(djibouti);
		daoVillage.create(dakar);
		daoVillage.create(mali);
		daoVillage.create(ethiopie);
		
		// Enregistrement des utilisateurs 
		daoAdmin.create(admin);
		daoGestClient.create(gestClient);
		daoGestCommerciale.create(gestCommerciale);
		daoGestCompteur.create(gestCompteur);
		
		// Enregistrement des abonnement
		daoAbonnment.create(abonnement1);
		daoAbonnment.create(abonnement2);
		daoAbonnment.create(abonnement3);
		
		// Enregistrement des clients 
		daoClient.create(client1);
		daoClient.create(client2);
		daoClient.create(client3);
		daoClient.create(client4);
		
		// Enregistrement des compteurs
		daoCompteur.create(compteur1);
		daoCompteur.create(compteur2);
		daoCompteur.create(compteur3);
		daoCompteur.create(compteur4);
		
		// Enregistrement des factures 
		daoFacture.create(facture1);
		daoFacture.create(facture2);
		daoFacture.create(facture3);
		daoFacture.create(facture4);
		
	}
}
