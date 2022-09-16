package sn.isi.dao;

import java.util.List;

import sn.isi.entities.Village;

public interface IVillage {
	public int create(Village village);
	public int update(Village village);
	public int delete(int id);
	public List<Village> getAll();
	public Village findById(int id);
}
