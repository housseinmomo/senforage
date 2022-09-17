package sn.isi.dao;

import java.util.List;

import org.hibernate.Transaction;

import hibernate.session.SessionHib;
import sn.isi.entities.GESTCOMMERCIALE;
import sn.isi.entities.GESTCOMPTEUR;

public class GESTCOMPTEURImpl implements IGESTCOMPTEUR{

	SessionHib sh = new SessionHib();
	org.hibernate.Session session = (org.hibernate.Session) sh.getSession();
	
	@Override
	public int create(GESTCOMPTEUR gestCompteur) {
		try {
			Transaction tx = session.beginTransaction();
			session.save(gestCompteur);
			tx.commit();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int update(GESTCOMPTEUR gestCompteur) {
		try {
			Transaction tx = session.beginTransaction();
			session.merge(gestCompteur);
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
			session.delete(session.get(GESTCOMPTEUR.class, id));
			tx.commit();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<GESTCOMPTEUR> getAll() {
		try {
			Transaction tx = session.beginTransaction();
			return session.createCriteria(GESTCOMPTEUR.class).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public GESTCOMPTEUR findById(int id) {
		try {
			Transaction tx = session.beginTransaction();
			return (GESTCOMPTEUR) session.get(GESTCOMPTEUR.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
