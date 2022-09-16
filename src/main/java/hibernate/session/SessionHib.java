package hibernate.session;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

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



public class SessionHib {
	
	public  org.hibernate.Session getSession() {
		Configuration conf = new Configuration().configure()
				.addAnnotatedClass(Abonnement.class)
				.addAnnotatedClass(Admin.class)
				.addAnnotatedClass(Client.class)
				.addAnnotatedClass(Compteur.class)
				.addAnnotatedClass(Facture.class)
				.addAnnotatedClass(GESTCLIENTELE.class)
				.addAnnotatedClass(GESTCOMMERCIALE.class)
				.addAnnotatedClass(GESTCOMPTEUR.class)
				.addAnnotatedClass(Roles.class)
				.addAnnotatedClass(Village.class)
				;
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(conf.getProperties()).buildServiceRegistry();
		
		SessionFactory sf = conf.buildSessionFactory(reg);
		
		org.hibernate.Session session = (org.hibernate.Session) sf.openSession();
		
		return  (org.hibernate.Session) session;
	}
}
