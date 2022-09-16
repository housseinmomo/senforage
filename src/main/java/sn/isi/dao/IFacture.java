package sn.isi.dao;

import java.util.List;

import sn.isi.entities.Facture;



public interface IFacture {
	public int create(Facture facture);
	public int update(Facture facture);
	public int delete(int id);
	public List<Facture> getAll();
	public Facture findById(int id);
}
