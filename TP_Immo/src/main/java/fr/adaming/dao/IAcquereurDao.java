package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Acquereur;

public interface IAcquereurDao {

	public List<Acquereur> getAllAcquereur();
	
	public Acquereur addAcquereur(Acquereur a);
	
	public Acquereur updateAcquereur(Acquereur a);
	
	public int deleteAcquereur(int id);
	
	public Acquereur getAcquereurById(int id);
	
}
