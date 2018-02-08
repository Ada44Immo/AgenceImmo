package fr.adaming.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Agent;

@Repository
public class AgentDaoImpl implements IAgentDao {

	@Autowired
	private SessionFactory sf;

	private Session s;

	@Override
	public Agent getAgentById(int id) {
		s = sf.getCurrentSession();

		String req = "FROM Agent as a WHERE a.id=:pId";

		Query query = s.createQuery(req);

		query.setParameter("pId", id);

		return (Agent) query.uniqueResult();
	}

}
