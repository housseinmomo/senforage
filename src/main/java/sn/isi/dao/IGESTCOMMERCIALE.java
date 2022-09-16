package sn.isi.dao;

import java.util.List;

import sn.isi.entities.GESTCOMMERCIALE;



public interface IGESTCOMMERCIALE {
	public int create(GESTCOMMERCIALE gestCommerciale);
	public int update(GESTCOMMERCIALE gestCommerciale);
	public int delete(int id);
	public List<GESTCOMMERCIALE> getAll();
	public GESTCOMMERCIALE findById(int id);
}
