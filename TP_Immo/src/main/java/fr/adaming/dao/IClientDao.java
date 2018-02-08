package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Client;

public interface IClientDao {
	
	public Client addClient(Client client);
	public Client updateClient(Client client);
	public int deleteClient (int id);
	public List<Client> getAllClient();
	public Client getByNom(String nom);
	public Client getById(int id);
	

}
