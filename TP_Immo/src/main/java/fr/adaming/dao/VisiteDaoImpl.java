package fr.adaming.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Visite;

@Repository
public class VisiteDaoImpl implements IVisiteDao{

	
	@Autowired
	private SessionFactory sf;
	private Session s;

	// Setter pour l'injection de dépendance
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	
	@Override
	public Visite addVisite(Visite visite) {
		s=sf.getCurrentSession();
		s.save(visite);
		return visite;
	}

	@Override
	public int deleteVisite(int id) {
		s=sf.getCurrentSession();
		String req="delete from Visite v where v.id=:pId";
		Query query = s.createQuery(req);
		query.setParameter("pId", id);
		return query.executeUpdate();
	}

	@Override
	public Visite updateVisite(Visite visite) {
		s=sf.getCurrentSession();
		s.saveOrUpdate(visite);
		return visite;
	}
	
	

	

}
