package sn.isi.dao;

import java.util.List;

import org.hibernate.Transaction;

import hibernate.session.SessionHib;
import sn.isi.entities.Admin;
import sn.isi.entities.Client;

public class ClientImpl implements IClient{

	SessionHib sh = new SessionHib();
	org.hibernate.Session session = (org.hibernate.Session) sh.getSession();
	
	@Override
	public int create(Client client) {
		try {
			Transaction tx = session.beginTransaction();
			session.save(client);
			tx.commit();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int update(Client client) {
		try {
			Transaction tx = session.beginTransaction();
			session.merge(client);
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
			session.delete(session.get(Client.class, id));
			tx.commit();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Client> getAll() {
		try {
			Transaction tx = session.beginTransaction();
			return session.createCriteria(Client.class).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Client findById(int id) {
		try {
			Transaction tx = session.beginTransaction();
			return (Client) session.get(Client.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
