package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Proprietaire;

@Repository
public class PropietaireDaoImpl implements IProprietaireDao {

	@Autowired
	private SessionFactory sf;
	
	@Override
	public List<Proprietaire> getAllPropietaire() {
		
		Session s = sf.getCurrentSession();
		
		String req = "FROM Proprietaire";
		
		Query query = s.createQuery(req);
		
		return query.list();
	}

}
