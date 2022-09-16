package sn.isi.dao;

import java.util.List;

import sn.isi.entities.Roles;


public interface IRoles {
	public int create(Roles role);
	public int update(Roles role);
	public int delete(int id);
	public List<Roles> getAll();
	public Roles findById(int id);
}
