package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.ICStdDao;
import fr.adaming.dao.IClientDao;
import fr.adaming.model.ClasseStandard;
import fr.adaming.model.Client;

@Service
@Transactional
public class ClientServiceImpl implements IClientService{
	@Autowired
	IClientDao clientDao;	
	@Autowired
	ICStdDao cStdDao;
	
	
	public void setClientDao(IClientDao clientDao) {
		this.clientDao = clientDao;
	}

	@Override
	public Client addClient(Client client) {		
		return clientDao.addClient(client);
	}

	@Override
	public Client updateClient(Client client) {
		
		return clientDao.updateClient(client);
	}

	@Override
	public int deleteClient(int id) {
		
		return clientDao.deleteClient(id);
	}

	@Override
	public List<Client> getAllClient() {
		
		return clientDao.getAllClient();
	}

	@Override
	public Client getByNom(String nom) {
	
		return clientDao.getByNom(nom);
	}

	@Override
	public Client getById(int id) {
		return clientDao.getById(id);
	}
	
	@Override
	public Client setCStd(String nomCS, String nom) {
		Client c =clientDao.getByNom(nom);
		List<ClasseStandard> liste = c.getListeCStd();
		liste.add(cStdDao.getCStdByName(nomCS));
		c.setListeCStd(liste);
		return c;
	}

}
