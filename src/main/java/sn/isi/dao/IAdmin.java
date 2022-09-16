package sn.isi.dao;

import java.util.List;
import sn.isi.entities.Admin;

public interface IAdmin {
	public int create(Admin admin);
	public int update(Admin admin);
	public int delete(int id);
	public List<Admin> getAll();
	public Admin findById(int id);
}
