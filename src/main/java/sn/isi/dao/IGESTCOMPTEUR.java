package sn.isi.dao;

import java.util.List;

import sn.isi.entities.GESTCOMPTEUR;


public interface IGESTCOMPTEUR {
	public int create(GESTCOMPTEUR gestCompteur);
	public int update(GESTCOMPTEUR gestCompteur);
	public int delete(int id);
	public List<GESTCOMPTEUR> getAll();
	public GESTCOMPTEUR findById(int id);
}
