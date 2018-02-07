package fr.adaming.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.adaming.model.Location;
import fr.adaming.model.Achat;
import fr.adaming.model.ClasseStandard;
import fr.adaming.model.Proprietaire;
import fr.adaming.service.ILocationService;

@RestController
@RequestMapping(value="location")
public class LocationRestController {
	
	@Autowired
	ILocationService locationService;

	public void setLocationService(ILocationService locationService) {
		this.locationService = locationService;
	}
	
	@RequestMapping(value="liste",method=RequestMethod.GET,produces="application/json")
	public List<Location> getAll(){
		return locationService.getAllLocation();
		
	}
	
	@RequestMapping(value="ById",method=RequestMethod.GET,produces="application/json")
	public Location getById(@RequestParam("pId") int id){
		return locationService.getLocationById(id);
		
	}
	
	@RequestMapping(value="add",method=RequestMethod.POST,consumes="application/json",produces="application/json")
	public Location addLocation(@RequestBody Location location,@RequestParam("pIdP") int idProp,@RequestParam("pNomCS") String nameCstd){
				return locationService.addLocation(location, idProp, nameCstd);
	}	
	
	@RequestMapping(value="update",method=RequestMethod.PUT,consumes="application/json",produces="application/json")
	public Location updateLocation(@RequestBody Location location){
				return locationService.updateLocation(location);
	}
	
	@RequestMapping(value="delete",method=RequestMethod.DELETE,consumes="application/json")
	public int deleteLocation(@RequestBody Location location){
		return locationService.deleteLocation(location.getId());
	}
	
	@RequestMapping(value="ByMC",method=RequestMethod.GET,produces="application/json")
	public List<Location> getByMC(@RequestParam("mKey")String motCle){
		return locationService.getLocationByLocalite(motCle);
	}
}
