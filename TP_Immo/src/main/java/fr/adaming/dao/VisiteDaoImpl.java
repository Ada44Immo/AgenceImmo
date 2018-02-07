package fr.adaming.dao;


import java.util.Date;
import java.util.List;

import javax.persistence.criteria.Order;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Achat;
import fr.adaming.model.Agent;
import fr.adaming.model.Bien;
import fr.adaming.model.Location;
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

	@Override
	public List<Visite> getVisiteByBienAchat(Achat achat) {
		s=sf.getCurrentSession();
		String req="from Visite v where v.achat.id=:pId";
		Query query = s.createQuery(req);
		query.setParameter("pId", achat.getId());
		return query.list();
	}
	
	@Override
	public List<Visite> getVisiteByBienLocation(Location location) {
		s=sf.getCurrentSession();
		String req="from Visite v where v.location.id=:pId";
		Query query = s.createQuery(req);
		query.setParameter("pId", location.getId());
		return query.list();
	}

	@Override
	public List<Visite> getVisiteByDate(Date date) {
		
		//Création des dates max et min pour le between
		Date fromDate= date;
		Date toDate= date;
		toDate.setDate(date.getDate()+1);
		System.out.println("==============================================================");
		System.out.println(fromDate +"\n");
		System.out.println(toDate);
		System.out.println("==============================================================");
		//Création 
		Criteria criteria = s.createCriteria(Visite.class);
		criteria.add(Restrictions.ge("date", fromDate)); 
		criteria.add(Restrictions.lt("date", toDate));
		
		return criteria.list();
	}

	@Override
	public List<Visite> getVisiteByAgent(Agent agent) {
		s=sf.getCurrentSession();
		String req=" from Visite v where v.agent.id=:pId";
		Query query = s.createQuery(req);
		query.setParameter("pId", agent.getId());
		return query.list();
	}

	@Override
	public List<Visite> getAllVisite() {
		s=sf.getCurrentSession();
		String req="from Visite";
		Query query = s.createQuery(req);
		return query.list();
	}

	@Override
	public Visite getVisiteById(int id) {
		s=sf.getCurrentSession();
		String req=" from Visite v where v.id=:pId";
		Query query = s.createQuery(req);
		query.setParameter("pId", id);
		return (Visite) query.uniqueResult();
	}
	
	
	

	

}
