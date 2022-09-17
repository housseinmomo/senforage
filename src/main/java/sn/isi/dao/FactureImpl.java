package sn.isi.dao;

import java.util.List;

import org.hibernate.Transaction;

import hibernate.session.SessionHib;
import sn.isi.entities.Admin;
import sn.isi.entities.Facture;

public class FactureImpl implements IFacture{

	SessionHib sh = new SessionHib();
	org.hibernate.Session session = (org.hibernate.Session) sh.getSession();
	
	@Override
	public int create(Facture facture) {
		try {
			Transaction tx = session.beginTransaction();
			session.save(facture);
			tx.commit();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int update(Facture facture) {
		try {
			Transaction tx = session.beginTransaction();
			session.merge(facture);
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
			session.delete(session.get(Facture.class, id));
			tx.commit();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Facture> getAll() {
		try {
			Transaction tx = session.beginTransaction();
			return session.createCriteria(Facture.class).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Facture findById(int id) {
		try {
			Transaction tx = session.beginTransaction();
			return (Facture) session.get(Facture.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
