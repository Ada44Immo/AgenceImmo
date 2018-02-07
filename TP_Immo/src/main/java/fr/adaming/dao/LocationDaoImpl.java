package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.ClasseStandard;
import fr.adaming.model.Client;
import fr.adaming.model.Location;

@Repository
public class LocationDaoImpl implements ILocationDao {

	@Autowired
	private SessionFactory sf;

	private Session s;

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public Location addLocation(Location location) {
		s = sf.getCurrentSession();
		s.save(location);
		return location;
	}

	@Override
	public Location updateLocation(Location location) {
		s = sf.getCurrentSession();
		// recup de location par son id
		Location locOut = (Location) s.get(Location.class, location.getId());
		// modif du client
		locOut.setAdresse(location.getAdresse());
		locOut.setBail(location.getBail());
		locOut.setCaution(location.getCaution());
		locOut.setCharge(location.getCharge());
		locOut.setDateDispo(location.getDateDispo());
		locOut.setDateMiseEnGerance(location.getDateMiseEnGerance());
		locOut.setDescription(location.getDescription());
		locOut.setGarniture(location.isGarniture());
		locOut.setLoyer(location.getLoyer());
		locOut.setPhoto(location.getPhoto());
		locOut.setRevenuCasdastral(location.getRevenuCasdastral());
		locOut.setStatut(location.getStatut());
		locOut.setSurface(location.getSurface());
		s.saveOrUpdate(locOut);
		return locOut;
	}

	@Override
	public int deleteLocation(int id) {
		// récupérer la session
		s = sf.getCurrentSession();

		// la requeteHQL
		// écriture de la requete HQL
		String req = "delete from Location l where l.id=:pId";

		// création d'un query
		Query query = s.createQuery(req);

		// assignation des paramètres
		query.setParameter("pId", id);

		return query.executeUpdate();
	}

	@Override
	public List<Location> getAllLocation() {
		// récupérer la session
		s = sf.getCurrentSession();

		// la requeteHQL
		// écriture de la requete HQL
		String req = "from Location l";

		// création d'un query
		Query query = s.createQuery(req);

		return query.list();
	}

	@Override
	public List<Location> getLocationByLocalite(String localite) {

		Session s = sf.getCurrentSession();

		String req = "FROM Location l";

		if (localite != null) {
			req = req + " WHERE l.localite LIKE :mKey";
		}
		Query query = s.createQuery(req);
		if (localite != null) {
			query.setString("mKey", "%" + localite + "%");
		}

		return query.list();
	}

	@Override
	public Location getLocationById(int id) {
		// ouverture de la session
		s = sf.getCurrentSession();

		// écriture de la requete HQL
		String req = "from Location l where l.id=:pId";

		// création d'un query
		Query query = s.createQuery(req);

		// assignation des paramètres
		query.setParameter("pId", id);

		Location locOut = (Location) query.uniqueResult();

		return locOut;
	}

}
