package fr.adaming.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.adaming.model.ClasseStandard;
import fr.adaming.service.ICStdService;

@RestController // pour déclarer un web service restful avec Spring MVC rest
public class CStdRestController {
	
	@Autowired
	private ICStdService cStdService;
	
	@RequestMapping(value="/CStd/liste",method=RequestMethod.GET, produces="application/json")
	public List<ClasseStandard> getAllCStd(){
		return cStdService.getAllCStd();
	}
	
	@RequestMapping(value="/CStd",method=RequestMethod.GET, produces="application/json")
	public List<ClasseStandard> getCStdByName(@RequestParam("pName") String name){
		return cStdService.getCStdByName(name);
	}
	
	@RequestMapping(value="/CStd", method=RequestMethod.POST, produces="application/json", consumes="application/json" )
	public ClasseStandard addCStd(@RequestBody ClasseStandard cStd){ //annotation req body ca veut dire que l'objet est a recupérer dans le corps de la requete (lié a post)
		return cStdService.addCStd(cStd);
	}

	@RequestMapping(value="/CStd", method=RequestMethod.PUT, produces="application/json", consumes="application/json" )
	public ClasseStandard updateCStd(@RequestBody ClasseStandard cStd){ //annotation req body ca veut dire que l'objet est a recupérer dans le corps de la requete (lié a post)
		return cStdService.updateCStd(cStd);
	}
	
	@RequestMapping(value="/CStd/{pId}", method=RequestMethod.DELETE)
	public void deleteCStd(@PathVariable ("pId") int id){
		cStdService.deleteCStd(id);		
	}
}
