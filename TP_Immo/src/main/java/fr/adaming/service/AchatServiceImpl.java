package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IAchatDao;
import fr.adaming.dao.ICStdDao;
import fr.adaming.dao.IProprietaireDao;
import fr.adaming.model.Achat;
import fr.adaming.model.Acquereur;
import fr.adaming.model.ClasseStandard;
import fr.adaming.model.Proprietaire;

@Service
@Transactional
public class AchatServiceImpl implements IAchatService{
	@Autowired
	IAchatDao achatDao;
	@Autowired
	ICStdDao cStdDao;
	@Autowired
	IProprietaireDao propDao;
	
	public void setAchatDao(IAchatDao achatDao) {
		this.achatDao = achatDao;
	}

	@Override
	public List<Achat> getAllAchat() {
		
		return achatDao.getAllAchat();
	}

	@Override
	public List<Achat> getAchatByMotCle(String motCle) {
		
		return achatDao.getAchatByMotCle(motCle);
	}

	@Override
	public Achat updateAchat(Achat achat) {
		
		return achatDao.updateAchat(achat);
	}

	@Override
	public int deleteAchat(int id) {
		
		return achatDao.deleteAchat(id);
	}

	@Override
	public Achat getAchatById(int id) {
		
		return achatDao.getAchatById(id);
	}



	@Override
	public Achat addAchat(Achat achat, int idProp,String nameCstd) {	
		ClasseStandard cStd=cStdDao.getCStdByName(nameCstd);
		achat.setcStd(cStd);
		Proprietaire proprietaire=propDao.getProprietaireById(idProp);
		achat.setProprietaire(proprietaire);
		return achatDao.addAchat(achat);
	}

	@Override
	public List<Achat> getAchatByCS(String nom) {
		return achatDao.getAchatByCS(cStdDao.getCStdByName(nom));
	}

}
