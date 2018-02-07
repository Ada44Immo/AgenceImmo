package fr.adaming.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.adaming.model.Achat;
import fr.adaming.model.Proprietaire;
import fr.adaming.service.IProprietaireService;

@RestController
@RequestMapping(value="proprietaire")
public class ProprietaireRestController {

	@Autowired
	private IProprietaireService proprietaireService;

	public void setProprietaireService(IProprietaireService proprietaireService) {
		this.proprietaireService = proprietaireService;
	}
	
	@RequestMapping(value="liste", method= RequestMethod.GET, produces="application/json")
	public List<Proprietaire> getAllProprietaire(){
		return proprietaireService.getAllProprietaire();
	}
	
	@RequestMapping(value="add", method= RequestMethod.POST, produces="application/json",consumes="application/json")
	public Proprietaire addProprietaire(@RequestBody Proprietaire p){
		return proprietaireService.addProprietaire(p);
	}
	
	@RequestMapping(value="ById",method=RequestMethod.GET,produces="application/json")
	public Proprietaire getProprietaireById(@RequestParam("pId") int id){
		return proprietaireService.getProprietaireById(id);	
	}
	
	
	@RequestMapping(value="update", method= RequestMethod.PUT, produces="application/json",consumes="application/json")
	public Proprietaire updateProprietaire(@RequestBody Proprietaire p){
		return proprietaireService.updateProprietaire(p);
	}

	@RequestMapping(value="delete", method= RequestMethod.DELETE)
	public void deleteProprietaire(@RequestParam("pId") int id){
		proprietaireService.deleteProprietaire(id);
	}
	
}
