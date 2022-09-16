package sn.isi.dao;

import java.util.List;

import org.hibernate.Transaction;

import hibernate.session.SessionHib;
import sn.isi.entities.Abonnement;

public class AbonnementImpl implements IAbonnement{
	
	SessionHib sh = new SessionHib();
	org.hibernate.Session session = (org.hibernate.Session) sh.getSession();
	
	@Override
	public int create(Abonnement abonnement) {
		try {
			Transaction tx = session.beginTransaction();
			session.save(abonnement);
			tx.commit();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int update(Abonnement abonnement) {
		try {
			Transaction tx = session.beginTransaction();
			session.merge(abonnement);
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
			session.delete(session.get(Abonnement.class, id));
			tx.commit();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Abonnement> getAll() {
		try {
			Transaction tx = session.beginTransaction();
			return session.createCriteria(Abonnement.class).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Abonnement findById(int id) {
		try {
			Transaction tx = session.beginTransaction();
			return (Abonnement) session.get(Abonnement.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
