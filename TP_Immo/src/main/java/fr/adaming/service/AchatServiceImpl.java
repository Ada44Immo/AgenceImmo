package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IAchatDao;
import fr.adaming.model.Achat;
import fr.adaming.model.Acquereur;
import fr.adaming.model.ClasseStandard;
import fr.adaming.model.Proprietaire;

@Service
@Transactional
public class AchatServiceImpl implements IAchatService{
	@Autowired
	IAchatDao achatDao;
	
	
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
	public int deleteAchat(Achat achat) {
		
		return achatDao.deleteAchat(achat);
	}

	@Override
	public Achat getAchatById(int id) {
		
		return achatDao.getAchatById(id);
	}



	@Override
	public Achat addAchat(Achat achat, Proprietaire proprietaire, ClasseStandard cStd) {		
		achat.setcStd(cStd);
		achat.setProprietaire(proprietaire);
		return achatDao.addAchat(achat);
	}

}
