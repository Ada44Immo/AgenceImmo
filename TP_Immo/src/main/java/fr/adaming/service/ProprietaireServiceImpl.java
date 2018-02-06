package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IProprietaireDao;
import fr.adaming.model.Proprietaire;

@Service
@Transactional
public class ProprietaireServiceImpl implements IProprietaireService {

	@Autowired
	private IProprietaireDao proprietaireDao;
	
	public void setProprietaireDao(IProprietaireDao proprietaireDao) {
		this.proprietaireDao = proprietaireDao;
	}

	@Override
	public List<Proprietaire> getAllPropietaire() {
		return proprietaireDao.getAllPropietaire();
	}

	@Override
	public Proprietaire addProprietaire(Proprietaire p) {
		return proprietaireDao.addProprietaire(p);
	}

	@Override
	public Proprietaire updateProprietaire(Proprietaire p) {
		return proprietaireDao.updateProprietaire(p);
	}

}
