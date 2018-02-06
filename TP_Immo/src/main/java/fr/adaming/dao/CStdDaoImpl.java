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
		// r�cup�rer la session
		s = sf.getCurrentSession();

		// ajout de l'�tudiant dans la BD
		s.save(cStd);

		return cStd;
	}

	@Override
	public int deleteCStd(int id) {
		// r�cup�rer la session
		s = sf.getCurrentSession();

		// la requeteHQL
		// �criture de la requete HQL
		String req = "delete from ClasseStandard cs where cs.idCode=:pId";

		// cr�ation d'un query
		Query query = s.createQuery(req);

		// assignation des param�tres
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
		// r�cup�rer la session
		s = sf.getCurrentSession();

		// la requeteHQL
		// �criture de la requete HQL
		String req = "from ClasseStandard cs";

		// cr�ation d'un query
		Query query = s.createQuery(req);

		return query.list();
	}

	@Override
	public ClasseStandard getPaysByName(String name) {
		// ouverture de la session
		s = sf.getCurrentSession();

		// �criture de la requete HQL
		String req = "from ClasseStandard cs where cs.type=:pName";

		// cr�ation d'un query
		Query query = s.createQuery(req);

		// assignation des param�tres
		query.setParameter("pName", name);

		ClasseStandard cStdOut = (ClasseStandard) query.uniqueResult();
		
		return cStdOut;
	}

}
