package sn.isi.dao;

import java.util.List;

import org.hibernate.Transaction;

import hibernate.session.SessionHib;
import sn.isi.entities.Admin;
import sn.isi.entities.GESTCLIENTELE;

public class GESTCLIENTEImpl implements IGESTCLIENTE{

	SessionHib sh = new SessionHib();
	org.hibernate.Session session = (org.hibernate.Session) sh.getSession();
	
	@Override
	public int create(GESTCLIENTELE gestClient) {
		try {
			Transaction tx = session.beginTransaction();
			session.save(gestClient);
			tx.commit();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int update(GESTCLIENTELE gestClient) {
		try {
			Transaction tx = session.beginTransaction();
			session.merge(gestClient);
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
			session.delete(session.get(GESTCLIENTELE.class, id));
			tx.commit();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<GESTCLIENTELE> getAll() {
		try {
			Transaction tx = session.beginTransaction();
			return session.createCriteria(GESTCLIENTELE.class).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public GESTCLIENTELE findById(int id) {
		try {
			Transaction tx = session.beginTransaction();
			return (GESTCLIENTELE) session.get(GESTCLIENTELE.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
