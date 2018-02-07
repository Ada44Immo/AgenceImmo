package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IAcquereurDao;
import fr.adaming.model.Acquereur;

@Service
@Transactional
public class AcquereurServiceImpl implements IAcquereurService {

	@Autowired
	private IAcquereurDao acquereurDao;
	
	public void setAcquereurDao(IAcquereurDao acquereurDao) {
		this.acquereurDao = acquereurDao;
	}

	@Override
	public List<Acquereur> getAllAcquereur() {
		return acquereurDao.getAllAcquereur();
	}

	@Override
	public Acquereur addAcquereur(Acquereur a) {
		return acquereurDao.addAcquereur(a);
	}

	@Override
	public Acquereur updateAcquereur(Acquereur a) {
		return acquereurDao.updateAcquereur(a);
	}

	@Override
	public int deleteAcquereur(int id) {
		return acquereurDao.deleteAcquereur(id);
	}

	@Override
	public Acquereur getAcquereurById(int id) {
		return acquereurDao.getAcquereurById(id);
	}

}
