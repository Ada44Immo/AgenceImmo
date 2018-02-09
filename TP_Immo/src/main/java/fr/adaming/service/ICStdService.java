package fr.adaming.service;

import java.util.List;

import fr.adaming.model.ClasseStandard;

public interface ICStdService {
	
	public ClasseStandard addCStd(ClasseStandard cStd);
	
	public int deleteCStd (int id);
	
	public ClasseStandard updateCStd(ClasseStandard cStd);

	public List<ClasseStandard> getAllCStd();
	
	public ClasseStandard getCStdByName(String name);

	public List<ClasseStandard> getCStdParClient(String nom);
}
