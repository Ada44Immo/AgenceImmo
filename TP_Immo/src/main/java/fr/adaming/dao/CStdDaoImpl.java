package fr.adaming.dao;

import java.util.List;

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
	public ClasseStandard updateCStd(ClasseStandard cStd) {
		s = sf.getCurrentSession();

		ClasseStandard cStdOut = (ClasseStandard) s.get(ClasseStandard.class, cStd.getIdCode());
		cStdOut.setModeOffre(cStd.isModeOffre());
		cStdOut.setPrixMax(cStd.getPrixMax());
		cStdOut.setSurfaceMin(cStd.getSurfaceMin());
		cStdOut.setType(cStd.getType());
		s.saveOrUpdate(cStdOut);
		return cStdOut;
	}

	@Override
	public List<ClasseStandard> getAllCStd() {
		// récupérer la session
		s = sf.getCurrentSession();

		// la requeteHQL
		// écriture de la requete HQL
		String req = "from ClasseStandard cs";

		// création d'un query
		Query query = s.createQuery(req);

		return query.list();
	}

	@Override
	public ClasseStandard getPaysByName(String name) {
		// ouverture de la session
		s = sf.getCurrentSession();

		// écriture de la requete HQL
		String req = "from ClasseStandard cs where cs.type=:pName";

		// création d'un query
		Query query = s.createQuery(req);

		// assignation des paramètres
		query.setParameter("pName", name);

		ClasseStandard cStdOut = (ClasseStandard) query.uniqueResult();
		
		return cStdOut;
	}

}
