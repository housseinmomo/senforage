package sn.isi.dao;

import java.util.List;

import org.hibernate.Transaction;

import hibernate.session.SessionHib;
import sn.isi.entities.GESTCOMMERCIALE;

public class GESTCOMMERCIALEImpl implements IGESTCOMMERCIALE{

	SessionHib sh = new SessionHib();
	org.hibernate.Session session = (org.hibernate.Session) sh.getSession();
	
	@Override
	public int create(GESTCOMMERCIALE gestCommerciale) {
		try {
			Transaction tx = session.beginTransaction();
			session.save(gestCommerciale);
			tx.commit();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int update(GESTCOMMERCIALE gestCommerciale) {
		try {
			Transaction tx = session.beginTransaction();
			session.merge(gestCommerciale);
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
			session.delete(session.get(GESTCOMMERCIALE.class, id));
			tx.commit();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<GESTCOMMERCIALE> getAll() {
		try {
			Transaction tx = session.beginTransaction();
			return session.createCriteria(GESTCOMMERCIALE.class).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public GESTCOMMERCIALE findById(int id) {
		try {
			Transaction tx = session.beginTransaction();
			return (GESTCOMMERCIALE) session.get(GESTCOMMERCIALE.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
