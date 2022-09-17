package sn.isi.dao;

import java.util.List;

import org.hibernate.Transaction;

import hibernate.session.SessionHib;
import sn.isi.entities.Admin;
import sn.isi.entities.Compteur;

public class CompteurImpl implements ICompteur{

	SessionHib sh = new SessionHib();
	org.hibernate.Session session = (org.hibernate.Session) sh.getSession();
	
	@Override
	public int create(Compteur compteur) {
		try {
			Transaction tx = session.beginTransaction();
			session.save(compteur);
			tx.commit();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int update(Compteur compteur) {
		try {
			Transaction tx = session.beginTransaction();
			session.merge(compteur);
			tx.commit();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int delete(int id) {
		try {
			Transaction tx = session.beginTransaction();
			session.delete(session.get(Compteur.class, id));
			tx.commit();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Compteur> getAll() {
		try {
			Transaction tx = session.beginTransaction();
			return session.createCriteria(Compteur.class).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Compteur findById(int id) {
		try {
			Transaction tx = session.beginTransaction();
			return (Compteur) session.get(Compteur.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
