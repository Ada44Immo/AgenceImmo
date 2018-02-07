package fr.adaming.service;

import java.util.List;

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

	@Override
	public int deleteCStd(int id) {
		return cStdDao.deleteCStd(id);
	}

	@Override
	public ClasseStandard updateCStd(ClasseStandard cStd) {
		return cStdDao.updateCStd(cStd);
	}

	@Override
	public List<ClasseStandard> getAllCStd() {
		return cStdDao.getAllCStd();

	}

	@Override
	public ClasseStandard getCStdByName(String name) {
		return cStdDao.getCStdByName(name);
	}
	
	
}
