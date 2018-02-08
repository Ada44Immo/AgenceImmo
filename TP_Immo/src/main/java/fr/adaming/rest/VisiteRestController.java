package fr.adaming.rest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.adaming.model.Achat;
import fr.adaming.model.Agent;
import fr.adaming.model.Location;
import fr.adaming.model.Visite;
import fr.adaming.service.IAchatService;
import fr.adaming.service.IAgentService;
import fr.adaming.service.IClientService;
import fr.adaming.service.ILocationService;
import fr.adaming.service.IVisiteService;

@RestController
@RequestMapping(value="visite")
public class VisiteRestController {

	@Autowired
	IVisiteService visiteService;
	@Autowired
	IAchatService achatService;
	@Autowired
	ILocationService locationService;
	@Autowired
	IClientService clientService;
	@Autowired
	IAgentService agentService;
	
	
	@RequestMapping(value="liste",method=RequestMethod.GET,produces="application/json")
	public List<Visite> getAllVisite(){
		return visiteService.getAllVisite();
	}
	
	@RequestMapping(value="add",method=RequestMethod.POST,consumes="application/json",produces="application/json")
	public Visite addVisite(@RequestBody Visite v){
		return visiteService.addVisite(v);
	}
	
	@RequestMapping(value="/{pId}", method=RequestMethod.DELETE)
	public int deleteVisite(@PathVariable ("pId") int id){
		return visiteService.deleteVisite(id);	
	}
	
	@RequestMapping(value="update",method=RequestMethod.PUT,produces="application/json")
	public Visite updateVisite(@RequestParam("idClient") int idC,@RequestParam("date") String date,@RequestParam("idAgent") int idAg,@RequestParam("choix") int choix ,@RequestParam("idBien") int idBien,@RequestParam("idVisite") int idVisite){
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date dateM;
		try {
			Visite v=visiteService.getVisiteById(idVisite);
			dateM = formatter.parse(date);
			v.setAgent(agentService.getAgentById(idAg));
			
			if (choix==1){
				v.setAchat(null);
				v.setLocation(locationService.getLocationById(idBien));
			}else{
				v.setLocation(null);
				v.setAchat(achatService.getAchatById(idBien));
			}
			v.setClient(clientService.getById(idC));
			return visiteService.updateVisite(v);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping(value="ByAgent",method=RequestMethod.GET,produces="application/json")
	public List<Visite> getVisiteByAgent(@RequestParam("idAgent") int idA){
		return visiteService.getVisiteByAgent(agentService.getAgentById(idA));
	}
	
	@RequestMapping(value="getById",method=RequestMethod.GET,produces="application/json")
	public Visite getVisiteById(@RequestParam("id") int id){
		return visiteService.getVisiteById(id);
	}
	
	@RequestMapping(value="ByAchat",method=RequestMethod.GET,produces="application/json")
	public List<Visite> getVisiteByBienAchat(@RequestParam("idAchat") int idA){
		Achat achat= achatService.getAchatById(idA);
		return visiteService.getVisiteByBienAchat(achat);
	}
	
	@RequestMapping(value="ByLoc",method=RequestMethod.GET,produces="application/json")
	public List<Visite> getVisiteByBienlocation(@RequestParam("idLoc") int idLoc){
		
		return visiteService.getVisiteByBienLocation(locationService.getLocationById(idLoc));
	}
	
	@RequestMapping(value="addVisite",method=RequestMethod.POST,produces="application/json")
	public Visite addVisite(@RequestParam("idClient") int idC,@RequestParam("date") String date,@RequestParam("idAgent") int idAg,@RequestParam("choix") int choix ,@RequestParam("idBien") int idBien){
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date dateM;
		try {
			dateM = formatter.parse(date);
			Visite v= new Visite(dateM);
			v.setAgent(agentService.getAgentById(idAg));
			
			if (choix==1){
				v.setLocation(locationService.getLocationById(idBien));
			}else{
				v.setAchat(achatService.getAchatById(idBien));
			}
			v.setClient(clientService.getById(idC));
			return visiteService.addVisite(v);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

		
		
	}
	
	

}
