package sn.isi.dao;

import java.util.List;

import org.hibernate.Transaction;

import hibernate.session.SessionHib;
import sn.isi.entities.Abonnement;
import sn.isi.entities.Admin;

public class AdminImpl implements IAdmin{

	SessionHib sh = new SessionHib();
	org.hibernate.Session session = (org.hibernate.Session) sh.getSession();
	
	@Override
	public int create(Admin admin) {
		try {
			Transaction tx = session.beginTransaction();
			session.save(admin);
			tx.commit();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int update(Admin admin) {
		try {
			Transaction tx = session.beginTransaction();
			session.merge(admin);
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
			session.delete(session.get(Admin.class, id));
			tx.commit();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Admin> getAll() {
		try {
			Transaction tx = session.beginTransaction();
			return session.createCriteria(Admin.class).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Admin findById(int id) {
		try {
			Transaction tx = session.beginTransaction();
			return (Admin) session.get(Admin.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
