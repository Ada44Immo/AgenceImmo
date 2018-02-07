package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.ILocationDao;
import fr.adaming.model.ClasseStandard;
import fr.adaming.model.Location;
import fr.adaming.model.Proprietaire;

@Service
@Transactional
public class LocationServiceImpl implements ILocationService {

	@Autowired
	private ILocationDao locationDao;
	
	public void setLocationDao(ILocationDao locationDao) {
		this.locationDao = locationDao;
	}

	@Override
	public Location addLocation(Location location,Proprietaire proprietaire, ClasseStandard cStd) {
		location.setcStd(cStd);
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
