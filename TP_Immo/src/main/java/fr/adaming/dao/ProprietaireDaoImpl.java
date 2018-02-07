package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Proprietaire;

@Repository
public class ProprietaireDaoImpl implements IProprietaireDao {

	@Autowired
	private SessionFactory sf;

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public List<Proprietaire> getAllProprietaire() {

		Session s = sf.getCurrentSession();

		String req = "FROM Proprietaire";

		Query query = s.createQuery(req);

		return query.list();
	}

	@Override
	public Proprietaire addProprietaire(Proprietaire p) {
		Session s = sf.getCurrentSession();
		s.save(p);
		return p;
	}

	@Override
	public Proprietaire updateProprietaire(Proprietaire p) {
		Session s = sf.getCurrentSession();

		Proprietaire pOut = (Proprietaire) s.get(Proprietaire.class, p.getId());

		pOut.setNom(p.getNom());
		pOut.setAdresse(p.getAdresse());
		pOut.setTel(p.getTel());

		s.saveOrUpdate(pOut);

		return pOut;
	}

	@Override
	public int deleteProprietaire(int id) {
		Session s = sf.getCurrentSession();

		Proprietaire pOut = (Proprietaire) s.get(Proprietaire.class, id);

		s.delete(pOut);

		Proprietaire pIn = (Proprietaire) s.get(Proprietaire.class, id);

		if ((Proprietaire) s.get(Proprietaire.class, id) == null) {
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public Proprietaire getProprietaireById(int id) {
		Session s = sf.getCurrentSession();

		return (Proprietaire) s.get(Proprietaire.class, id);
	}

}
