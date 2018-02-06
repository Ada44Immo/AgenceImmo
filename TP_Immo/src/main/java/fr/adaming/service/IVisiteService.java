package fr.adaming.service;

import fr.adaming.model.Visite;

public interface IVisiteService {

	public Visite addVisite(Visite visite);
	
	public int deleteVisite(int id);
	
	public Visite updateVisite(Visite visite);
}
