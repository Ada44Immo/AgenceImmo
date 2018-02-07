package fr.adaming.rest;

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
import fr.adaming.service.IVisiteService;

@RestController
@RequestMapping(value="visite")
public class VisiteRestController {

	@Autowired
	IVisiteService visiteService;
	
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
	
	@RequestMapping(value="update",method=RequestMethod.PUT,consumes="application/json",produces="application/json")
	public Visite updateVisite(@RequestBody Visite v){
		return visiteService.updateVisite(v);
	}
	
	@RequestMapping(value="liste",method=RequestMethod.GET,consumes="application/json",produces="application/json")
	public List<Visite> getVisiteByAgent(@RequestParam("agent") Agent agent){
		return visiteService.getVisiteByAgent(agent);
	}
	
	@RequestMapping(value="getById",method=RequestMethod.GET,produces="application/json")
	public Visite getVisiteById(@RequestParam("id") int id){
		return visiteService.getVisiteById(id);
	}
	
	@RequestMapping(value="liste",method=RequestMethod.GET,consumes="application/json",produces="application/json")
	public List<Visite> getVisiteByBienAchat(@RequestParam("achat") Achat achat){
		return visiteService.getVisiteByBienAchat(achat);
	}
	
	@RequestMapping(value="liste",method=RequestMethod.GET,consumes="application/json",produces="application/json")
	public List<Visite> getVisiteByBienlocation(@RequestParam("location") Location location){
		return visiteService.getVisiteByBienLocation(location);
	}
	
	

}
