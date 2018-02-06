package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import fr.adaming.dao.IClientDao;
import fr.adaming.model.Client;

public class ClientServiceImpl implements IClientService{
	@Autowired
	IClientDao clientDao;	
	
	
	public void setClientDao(IClientDao clientDao) {
		this.clientDao = clientDao;
	}

	@Override
	public Client addClient(Client client) {		
		return clientDao.addClient(client);
	}

	@Override
	public Client updateClient(Client client) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteClient(Client client) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Client> getAllClient() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Client getByNom(String nom) {
		// TODO Auto-generated method stub
		return null;
	}

}
