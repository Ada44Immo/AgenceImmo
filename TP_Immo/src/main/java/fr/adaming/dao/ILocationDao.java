package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Client;
import fr.adaming.model.Location;

public interface ILocationDao {
	
	public Location addLocation(Location location);
	public Location updateLocation(Location location);
	public int deleteLocation (int id);
	public List<Location> getAllLocation();
	public List<Location> getLocationByLocalite(String localite);
	public Location getLocationById(int id);
	

}
