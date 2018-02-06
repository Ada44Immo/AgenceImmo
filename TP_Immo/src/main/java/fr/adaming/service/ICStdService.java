package fr.adaming.service;

import fr.adaming.model.ClasseStandard;

public interface ICStdService {
	
	public ClasseStandard addCStd(ClasseStandard cStd);
	
	public int deleteCStd (int id);
	
	public ClasseStandard updateCStd(ClasseStandard cStd);


}
