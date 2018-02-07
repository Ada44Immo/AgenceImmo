package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Achat;
import fr.adaming.model.Agent;
import fr.adaming.model.Location;
import fr.adaming.model.Visite;

public interface IVisiteService {

	public Visite addVisite(Visite visite);

	public int deleteVisite(int id);

	public Visite updateVisite(Visite visite);

	public List<Visite> getVisiteByBienAchat(Achat achat);
	
	public List<Visite> getVisiteByBienLocation(Location location);

	public List<Visite> getVisiteByAgent(Agent agent);

	public List<Visite> getAllVisite();
	
	public Visite getVisiteById(int id);

}
