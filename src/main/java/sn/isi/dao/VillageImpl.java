package sn.isi.dao;

import java.util.List;

import org.hibernate.Transaction;

import hibernate.session.SessionHib;
import sn.isi.entities.Abonnement;
import sn.isi.entities.Village;

public class VillageImpl implements IVillage{

	SessionHib sh = new SessionHib();
	org.hibernate.Session session = (org.hibernate.Session) sh.getSession();
	
	@Override
	public int create(Village village) {
		try {
			Transaction tx = session.beginTransaction();
			session.save(village);
			tx.commit();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int update(Village village) {
		try {
			Transaction tx = session.beginTransaction();
			session.merge(village);
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
			session.delete(session.get(Village.class, id));
			tx.commit();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Village> getAll() {
		try {
			Transaction tx = session.beginTransaction();
			return session.createCriteria(Village.class).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Village findById(int id) {
		try {
			Transaction tx = session.beginTransaction();
			return (Village) session.get(Village.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
