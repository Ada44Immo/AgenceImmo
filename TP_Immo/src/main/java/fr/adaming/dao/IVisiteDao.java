package fr.adaming.dao;

import fr.adaming.model.Visite;

public interface IVisiteDao {

	public Visite addVisite(Visite visite);
	
	public int deleteVisite(int id);
	
	public Visite updateVisite(Visite visite);
}
