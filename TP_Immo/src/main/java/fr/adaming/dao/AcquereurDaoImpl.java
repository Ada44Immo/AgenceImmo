package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Acquereur;

@Repository
public class AcquereurDaoImpl implements IAcquereurDao {

	@Autowired
	private SessionFactory sf;

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public List<Acquereur> getAllAcquereur() {
		Session s = sf.getCurrentSession();

		String req = "FROM Acquereur";

		Query query = s.createQuery(req);

		return query.list();
	}

	@Override
	public Acquereur addAcquereur(Acquereur a) {
		Session s = sf.getCurrentSession();

		s.save(a);

		return a;
	}

	@Override
	public Acquereur updateAcquereur(Acquereur a) {
		Session s = sf.getCurrentSession();

		Acquereur aOut = (Acquereur) s.get(Acquereur.class, a.getId());

		aOut.setAdresse(a.getAdresse());
		aOut.setDateAchat(a.getDateAchat());
		aOut.setNom(a.getNom());
		aOut.setPrix(a.getPrix());
		aOut.setTel(a.getTel());

		s.saveOrUpdate(aOut);

		return aOut;
	}

	@Override
	public int deleteAcquereur(int id) {
		Session s = sf.getCurrentSession();

		Acquereur aOut = (Acquereur) s.get(Acquereur.class, id);

		s.delete(aOut);

		if ((Acquereur) s.get(Acquereur.class, id) == null) {
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public Acquereur getAcquereurById(int id) {
		Session s = sf.getCurrentSession();

		return (Acquereur) s.get(Acquereur.class, id);
	}

}
