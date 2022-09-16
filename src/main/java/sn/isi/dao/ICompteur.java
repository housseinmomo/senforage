package sn.isi.dao;

import java.util.List;

import sn.isi.entities.Compteur;



public interface ICompteur {
	public int create(Compteur compteuu);
	public int update(Compteur compteur);
	public int delete(int id);
	public List<Compteur> getAll();
	public Compteur findById(int id);
}
