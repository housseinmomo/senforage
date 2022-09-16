package sn.isi.dao;

import java.util.List;

import sn.isi.entities.GESTCLIENTELE;



public interface IGESTCLIENTE {
	public int create(GESTCLIENTELE gestClient);
	public int update(GESTCLIENTELE gestClient);
	public int delete(int id);
	public List<GESTCLIENTELE> getAll();
	public GESTCLIENTELE findById(int id);
}
