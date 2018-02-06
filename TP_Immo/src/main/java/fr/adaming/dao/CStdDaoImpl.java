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
		// r�cup�rer la session
		s = sf.getCurrentSession();

		// ajout de l'�tudiant dans la BD
		s.save(cStd);

		return cStd;
	}

}
