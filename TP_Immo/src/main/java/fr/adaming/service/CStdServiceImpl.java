package fr.adaming.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.ICStdDao;
import fr.adaming.model.ClasseStandard;

@Service
@Transactional
public class CStdServiceImpl implements ICStdService {
	
	@Autowired
	private ICStdDao cStdDao;

	@Override
	public ClasseStandard addCStd(ClasseStandard cStd) {
		return cStdDao.addCStd(cStd);
	}
}
