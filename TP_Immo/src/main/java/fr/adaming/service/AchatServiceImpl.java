package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.model.Achat;
import fr.adaming.model.Acquereur;
import fr.adaming.model.ClasseStandard;
import fr.adaming.model.Proprietaire;

@Service
@Transactional
public class AchatServiceImpl implements IAchatService{
	@Autowired
	IAchatService achatService;
	
	
	public void setAchatService(IAchatService achatService) {
		this.achatService = achatService;
	}



	@Override
	public List<Achat> getAllAchat() {
		
		return achatService.getAllAchat();
	}

	@Override
	public List<Achat> getAchatByMotCle(String motCle) {
		
		return achatService.getAchatByMotCle(motCle);
	}

	@Override
	public Achat updateAchat(Achat achat) {
		
		return achatService.updateAchat(achat);
	}

	@Override
	public int deleteAchat(Achat achat) {
		
		return achatService.deleteAchat(achat);
	}

	@Override
	public Achat getAchatById(int id) {
		
		return achatService.getAchatById(id);
	}



	@Override
	public Achat addAchat(Achat achat, Proprietaire proprietaire, ClasseStandard cStd) {		
		achat.setcStd(cStd);
		achat.setProprietaire(proprietaire);
		return achatService.addAchat(achat, proprietaire, cStd);
	}

}
