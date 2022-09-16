package sn.isi.dao;

import java.util.List;

import sn.isi.entities.Client;



public interface IClient {
	public int create(Client client);
	public int update(Client client);
	public int delete(int id);
	public List<Client> getAll();
	public Client findById(int id);
}
