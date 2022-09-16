package sn.isi.dao;

import java.util.List;

import sn.isi.entities.Abonnement;


public interface IAbonnement {
	public int create(Abonnement abonnement);
	public int update(Abonnement abonnement);
	public int delete(int id);
	public List<Abonnement> getAll();
	public Abonnement findById(int id);
}
