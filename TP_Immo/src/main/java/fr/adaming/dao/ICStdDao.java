package fr.adaming.dao;

import fr.adaming.model.ClasseStandard;

public interface ICStdDao {
	
	public ClasseStandard addCStd(ClasseStandard cStd);
	
	public int deleteCStd(int id);
	
	public ClasseStandard updateCStd(ClasseStandard cStd);

}
