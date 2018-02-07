package fr.adaming.service;

import java.util.List;

import fr.adaming.model.ClasseStandard;
import fr.adaming.model.Location;
import fr.adaming.model.Proprietaire;

public interface ILocationService {
	
	public Location addLocation(Location location, Proprietaire proprietaire, ClasseStandard cStd);
	public Location updateLocation(Location location);
	public int deleteLocation (int id);
	public List<Location> getAllLocation();
	public List<Location> getLocationByLocalite(String localite);
	public Location getLocationById(int id);
	
}
