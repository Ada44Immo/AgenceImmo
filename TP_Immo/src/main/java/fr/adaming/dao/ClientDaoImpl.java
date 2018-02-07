package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
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
		s.saveOrUpdate(cModif);
		return cModif;
	}

	@Override
	public int deleteClient(int id) {
		s=sf.getCurrentSession();
		//recup client par son id
		Client cSupp = (Client) s.get(Client.class, id);
		//suppresion du client
		s.delete(cSupp);
		return 1;
	}

	@Override
	public List<Client> getAllClient() {
		s=sf.getCurrentSession();
		
		//requete HQL
		String req="FROM Client";
		
		Query query=s.createQuery(req);		
		
		return query.list();
	}

	@Override
	public Client getByNom(String nom) {
		s=sf.getCurrentSession();
		
		//requete HQL
		String req="FROM Client as c WHERE c.nom=:pNom";
		
		Query query=s.createQuery(req);
		
		query.setParameter("pNom", nom);
		
		Client c=(Client) query.uniqueResult();
		
		return c;
	}

}
