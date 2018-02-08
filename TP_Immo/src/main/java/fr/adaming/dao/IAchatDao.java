package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Achat;
import fr.adaming.model.ClasseStandard;

public interface IAchatDao {
	
	public Achat addAchat(Achat achat);
	public List<Achat> getAllAchat();
	public List<Achat> getAchatByMotCle(String motCle);
	public Achat updateAchat(Achat achat);
	public int deleteAchat(int id);
	public Achat getAchatById(int id);
	public List<Achat> getAchatByCS(ClasseStandard cs);
	}
