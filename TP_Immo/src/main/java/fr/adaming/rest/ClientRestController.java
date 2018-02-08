package fr.adaming.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.adaming.model.Client;
import fr.adaming.service.IClientService;

@RestController
@RequestMapping(value="client")
public class ClientRestController {
	@Autowired
	IClientService clientService;

	public void setClientService(IClientService clientService) {
		this.clientService = clientService;
	}
	
	@RequestMapping(value="liste",method=RequestMethod.GET,produces="application/json")
	public List<Client> getAll(){
		
		return clientService.getAllClient();
	}
	
	@RequestMapping(value="ByNom",method=RequestMethod.GET,produces="application/json")
	public Client getByNom(@RequestParam("pNom") String nom){
		
		return clientService.getByNom(nom);
	}
	
	@RequestMapping(value="delete",method=RequestMethod.DELETE)
	public int deleteClient(@RequestParam("pId") int id){
		
		return clientService.deleteClient(id);
	}
	
	@RequestMapping(value="update",method=RequestMethod.PUT,consumes="application/json",produces="application/json")
	public Client updateCLient(@RequestBody Client client){
		
		return clientService.updateClient(client);
	}
	
	@RequestMapping(value="add",method=RequestMethod.POST,consumes="application/json",produces="application/json")
	public Client addCLient(@RequestBody Client client){
		
		return clientService.addClient(client);
	}
	
	@RequestMapping(value="ById",method=RequestMethod.DELETE)
	public Client getById(@RequestParam("pId") int id){
		return clientService.getById(id);
	}
	
}
