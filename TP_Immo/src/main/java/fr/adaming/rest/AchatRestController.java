package fr.adaming.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.adaming.model.Achat;
import fr.adaming.model.ClasseStandard;
import fr.adaming.model.Proprietaire;
import fr.adaming.service.IAchatService;

@RestController
@RequestMapping(value="achat")
public class AchatRestController {
	@Autowired
	IAchatService achatService;

	public void setAchatService(IAchatService achatService) {
		this.achatService = achatService;
	}
	
	@RequestMapping(value="liste",method=RequestMethod.GET,produces="application/json")
	public List<Achat> getAll(){
		
		return achatService.getAllAchat();
		
	}
	
	@RequestMapping(value="ById",method=RequestMethod.GET,produces="application/json")
	public Achat getById(@RequestParam("pId") int id){
		return achatService.getAchatById(id);
		
	}
	
	@RequestMapping(value="add",method=RequestMethod.POST,consumes="application/json",produces="application/json")
	public Achat addAchat(@RequestBody Achat achat,@RequestBody Proprietaire proprietaire,@RequestBody ClasseStandard cStd){
		
		return achatService.addAchat(achat, proprietaire, cStd);
	}
	
	@RequestMapping(value="update",method=RequestMethod.PUT,consumes="application/json",produces="application/json")
	public Achat updateAchat(@RequestBody Achat achat){
		
		return achatService.updateAchat(achat);
	}
	
	@RequestMapping(value="delete",method=RequestMethod.DELETE,consumes="application/json")
	public int deleteAchat(@RequestBody Achat achat){
		return achatService.deleteAchat(achat);
	}
	
	@RequestMapping(value="ByMC",method=RequestMethod.GET,produces="application/json")
	public List<Achat> getByMC(@RequestParam("mKey")String motCle){
		return achatService.getAchatByMotCle(motCle);
	}
	
}
