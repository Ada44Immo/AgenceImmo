package fr.adaming.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.ClasseStandard;

@Repository
public class CStdDaoImpl implements ICStdDao {

	@Autowired
	private SessionFactory sf;

	private Session s;
	
	@Override
	public ClasseStandard addCStd(ClasseStandard cStd) {
		// récupérer la session
		s = sf.getCurrentSession();

		// ajout de l'étudiant dans la BD
		s.save(cStd);

		return cStd;
	}

}
