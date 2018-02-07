package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.ICStdDao;
import fr.adaming.dao.ILocationDao;
import fr.adaming.dao.IProprietaireDao;
import fr.adaming.model.ClasseStandard;
import fr.adaming.model.Location;
import fr.adaming.model.Proprietaire;

@Service
@Transactional
public class LocationServiceImpl implements ILocationService {

	@Autowired
	private ILocationDao locationDao;
	@Autowired
	ICStdDao cStdDao;
	@Autowired
	IProprietaireDao propDao;
	
	public void setLocationDao(ILocationDao locationDao) {
		this.locationDao = locationDao;
	}

	@Override
	public Location addLocation(Location location, int idProp,String nameCstd) {
		ClasseStandard cStd=cStdDao.getCStdByName(nameCstd);
		location.setcStd(cStd);
		Proprietaire proprietaire=propDao.getProprietaireById(idProp);
		location.setProprietaire(proprietaire);
		return locationDao.addLocation(location);

	}

	@Override
	public Location updateLocation(Location location) {
		return locationDao.updateLocation(location);
	}

	@Override
	public int deleteLocation(int id) {
		return locationDao.deleteLocation(id);
	}

	@Override
	public List<Location> getAllLocation() {
		return locationDao.getAllLocation();
	}

	@Override
	public List<Location> getLocationByLocalite(String localite) {
		return locationDao.getLocationByLocalite(localite);
	}

	@Override
	public Location getLocationById(int id) {
		return locationDao.getLocationById(id);
	}
	
}
