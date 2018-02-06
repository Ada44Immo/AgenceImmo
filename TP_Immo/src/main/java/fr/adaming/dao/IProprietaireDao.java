package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Proprietaire;

public interface IProprietaireDao {

	public List<Proprietaire> getAllPropietaire(); 
	
	public Proprietaire addProprietaire(Proprietaire p);
	
	public Proprietaire updateProprietaire(Proprietaire p);
	
}
