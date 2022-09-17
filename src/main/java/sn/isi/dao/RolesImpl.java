package sn.isi.dao;

import java.util.List;

import org.hibernate.Transaction;

import hibernate.session.SessionHib;
import sn.isi.entities.Abonnement;
import sn.isi.entities.Roles;

public class RolesImpl implements IRoles{

	SessionHib sh = new SessionHib();
	org.hibernate.Session session = (org.hibernate.Session) sh.getSession();
	
	@Override
	public int create(Roles role) {
		try {
			Transaction tx = session.beginTransaction();
			session.save(role);
			tx.commit();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int update(Roles role) {
		try {
			Transaction tx = session.beginTransaction();
			session.merge(role);
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
			session.delete(session.get(Roles.class, id));
			tx.commit();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Roles> getAll() {
		try {
			Transaction tx = session.beginTransaction();
			return session.createCriteria(Roles.class).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Roles findById(int id) {
		try {
			Transaction tx = session.beginTransaction();
			return (Roles) session.get(Roles.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
