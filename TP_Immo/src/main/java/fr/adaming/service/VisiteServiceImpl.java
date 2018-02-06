package fr.adaming.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IVisiteDao;
import fr.adaming.model.Visite;

@Service
@Transactional
public class VisiteServiceImpl implements IVisiteService{

	@Autowired
	private IVisiteDao visiteService;
	
	@Override
	public Visite addVisite(Visite visite) {
		return visiteService.addVisite(visite);
	}

	@Override
	public int deleteVisite(int id) {
		return visiteService.deleteVisite(id);
	}

	@Override
	public Visite updateVisite(Visite visite) {
		return visiteService.updateVisite(visite);
	}
	
	

	

}
