package fr.adaming.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Client;

@Repository
public class ClientDaoImpl implements IClientDao{

	@Autowired
	private SessionFactory sf;
	
	private Session s;	
	
	
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public Client addClient(Client client) {
		s=sf.getCurrentSession();
		s.save(client);
		return client;
	}

	@Override
	public Client updateClient(Client client) {
		s=sf.getCurrentSession();
		//recup du client par son id
		Client cModif = (Client) s.get(Client.class, client.getId());
		//modif du client
		cModif.setNom(client.getNom());
		cModif.setAdresse(client.getAdresse());
		cModif.setTel(client.getTel());
		
		return cModif;
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
