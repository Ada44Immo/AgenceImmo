package fr.adaming.rest;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import fr.adaming.model.Achat;
import fr.adaming.model.Acquereur;
import fr.adaming.model.Client;
import fr.adaming.model.Location;
import fr.adaming.service.IAchatService;
import fr.adaming.service.IAcquereurService;
import fr.adaming.service.IClientService;
import fr.adaming.service.ILocationService;

@RestController
@RequestMapping(value="acquereur")
public class AcquereurRestController {
	
	@Autowired
	private IAcquereurService acquereurService;
	@Autowired
	private IAchatService achatService;
	@Autowired
	private ILocationService locationService;
	@Autowired
	private IClientService clientService;

	public void setAcquereurService(IAcquereurService acquereurService) {
		this.acquereurService = acquereurService;
	}
	
	@RequestMapping(value="liste", method= RequestMethod.GET, produces="application/json")
	public List<Acquereur> getAllAcquereur(){
		return acquereurService.getAllAcquereur();
	}
	
	@RequestMapping(value="add", method= RequestMethod.POST, produces="application/json",consumes="application/json")
	public Acquereur addAcquereur(@RequestBody Acquereur a){
		return acquereurService.addAcquereur(a);
	}
	
	@RequestMapping(value="ById",method=RequestMethod.GET,produces="application/json")
	public Acquereur getAcquereurById(@RequestParam("pId") int id){
		return acquereurService.getAcquereurById(id);
	}

	@RequestMapping(value="update", method= RequestMethod.PUT, produces="application/json",consumes="application/json")
	public Acquereur updateAcquereur(@RequestBody Acquereur a){
		return acquereurService.updateAcquereur(a);
	}
	
	@RequestMapping(value="delete", method= RequestMethod.DELETE)
	public void deleteAcquereur(@RequestParam("pId") int id){
		acquereurService.deleteAcquereur(id);
	}
	
	@RequestMapping(value="attribuer", method=RequestMethod.GET)
	public Acquereur attribuerBien(@RequestParam("idAchat") int idA,@RequestParam("idClient") int idC){
		
		Achat achat= achatService.getAchatById(idA);
		Client client=clientService.getById(idC);
		Acquereur acquereur= new Acquereur();
		acquereur.setPrix(achat.getPrix());
		acquereur.setTel(client.getTel());
		acquereur.setNom(client.getNom());
		acquereur.setDateAchat(new Date());
		acquereur.setAchat(achat);
		acquereur.setAdresse(client.getAdresse());
		achat.setStatut("acheté");
		achatService.updateAchat(achat);
		acquereurService.addAcquereur(acquereur);
		//clientService.deleteClient(idC);
		
		return acquereur;
	}
	
	@RequestMapping(value="attribuerLoc", method=RequestMethod.GET)
	public Acquereur attribuerBienloc(@RequestParam("idLoc") int idL,@RequestParam("idClient") int idC){
		
		Location location= locationService.getLocationById(idL);
		Client client=clientService.getById(idC);
		Acquereur acquereur= new Acquereur();
		acquereur.setPrix(location.getLoyer()+location.getCharge());
		acquereur.setTel(client.getTel());
		acquereur.setNom(client.getNom());
		acquereur.setDateAchat(new Date());
		acquereur.setLocation(location);
		acquereur.setAdresse(client.getAdresse());
		location.setStatut("loué");
		locationService.updateLocation(location);
		acquereurService.addAcquereur(acquereur);
		//clientService.deleteClient(idC);
		
		return acquereur;
	}
}
