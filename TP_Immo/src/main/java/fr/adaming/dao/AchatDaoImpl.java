package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Achat;

@Repository
public class AchatDaoImpl implements IAchatDao{
	
	@Autowired
	private SessionFactory sf;
	
	private Session s;
	
	
	@Override
	public Achat addAchat(Achat achat) {
		s=sf.getCurrentSession();
		s.save(achat);
		return achat;
	}

	@Override
	public List<Achat> getAllAchat() {
		s=sf.getCurrentSession();
		
		String req="FROM Achat";
		
		Query query=s.createQuery(req);		
		
		return query.list();
	}

	@Override
	public List<Achat> getAchatByMotCle(String motCle) {
		s=sf.getCurrentSession();
		
		String req="FROM Achat a";
		
		if (motCle != null) {
			req = req + " WHERE a.adresse.localite LIKE :mKey";
		}
		
		Query query = s.createQuery(req);
		
		if (motCle != null) {
			query.setString("mKey", "%" + motCle + "%");
		}
		
		return query.list();
	}

	@Override
	public Achat updateAchat(Achat achat) {
		s=sf.getCurrentSession();
		
		Achat aModif=(Achat) s.get(Achat.class, achat.getId());
		
		aModif.setEtat(achat.getEtat());
		aModif.setPrix(achat.getPrix());
		aModif.setAdresse(achat.getAdresse());	
		aModif.setDateDispo(achat.getDateDispo());
		aModif.setDateMiseEnGerance(achat.getDateMiseEnGerance());
		aModif.setDescription(achat.getDescription());
		aModif.setPhoto(achat.getPhoto());
		aModif.setRevenuCasdastral(achat.getRevenuCasdastral());
		aModif.setStatut(achat.getStatut());
		aModif.setSurface(achat.getSurface());
		
		s.saveOrUpdate(aModif);
		
		return aModif;
	}

	@Override
	public int deleteAchat(Achat achat) {
		s=sf.getCurrentSession();
		String req="delete from Achat a where a.id=:pId";
		Query query = s.createQuery(req);
		query.setParameter("pId", achat.getId());
		return query.executeUpdate();
	}

	@Override
	public Achat getAchatById(int id) {
		s=sf.getCurrentSession();
		
		String req="FROM Achat as a WHERE a.id=:pId";
		
		Query query=s.createQuery(req);
		
		query.setParameter("pId", id);		
		
		return (Achat) query.uniqueResult();
	}

}
