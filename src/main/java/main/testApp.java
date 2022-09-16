package main;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import hibernate.session.SessionHib;
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
		
		Village balbala = new Village("Obock", "Ali Med Adou");
		
		VillageImpl daoVillage = new VillageImpl();
		
		List<Village> villages = daoVillage.getAll();
		
		for(Village v : villages) {
			System.out.println(v);
		}
	}
}
