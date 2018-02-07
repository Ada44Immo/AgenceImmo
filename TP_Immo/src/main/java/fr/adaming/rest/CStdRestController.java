package fr.adaming.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import fr.adaming.service.ICStdService;

@RestController // pour déclarer un web service restful avec Spring MVC rest
public class CStdRestController {
	
	@Autowired
	private ICStdService cStdService;
	
	

}
