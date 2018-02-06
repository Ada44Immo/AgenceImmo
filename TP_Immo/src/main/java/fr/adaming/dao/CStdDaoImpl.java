package fr.adaming.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.ClasseStandard;

@Repository
public class CStdDaoImpl implements ICStdDao {

	@Autowired
	private SessionFactory sf;
	
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	private Session s;
	
	@Override
	public ClasseStandard addCStd(ClasseStandard cStd) {
		// récupérer la session
		s = sf.getCurrentSession();

		// ajout de l'étudiant dans la BD
		s.save(cStd);

		return cStd;
	}

	@Override
	public int deleteCStd(int id) {
		// récupérer la session
		s = sf.getCurrentSession();

		// la requeteHQL
		// écriture de la requete HQL
		String req = "delete from ClasseStandard cs where cs.idCode=:pId";

		// création d'un query
		Query query = s.createQuery(req);

		// assignation des paramètres
		query.setParameter("pId", id);

		return query.executeUpdate();
	}

	@Override
	public int updateCStd(ClasseStandard cStd) {
		// TODO Auto-generated method stub
		return 0;
	}

}
