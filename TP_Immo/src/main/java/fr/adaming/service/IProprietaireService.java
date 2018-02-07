package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Proprietaire;

public interface IProprietaireService {

	public List<Proprietaire> getAllPropietaire(); 

	public Proprietaire addProprietaire(Proprietaire p);

	public Proprietaire updateProprietaire(Proprietaire p);

	public int deleteProprietaire(int id);

	public Proprietaire getProprietaireById(int id);
	
}
