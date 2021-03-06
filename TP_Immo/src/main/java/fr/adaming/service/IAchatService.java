package fr.adaming.service;

import java.util.List;



import fr.adaming.model.Achat;
import fr.adaming.model.Acquereur;
import fr.adaming.model.ClasseStandard;
import fr.adaming.model.Proprietaire;

public interface IAchatService {
	
	public Achat addAchat(Achat achat,int idProp,String nameCstd);
	public List<Achat> getAllAchat();
	public List<Achat> getAchatByMotCle(String motCle);
	public Achat updateAchat(Achat achat);
	public int deleteAchat(int id);
	public Achat getAchatById(int id);
	public List<Achat> getAchatByCS(String name);
	public List<Achat> getAchatByCSByClient(String nomClient);

}
