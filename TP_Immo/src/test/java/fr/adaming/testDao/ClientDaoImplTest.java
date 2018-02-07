package fr.adaming.testDao;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IClientDao;
import fr.adaming.model.Adresse;
import fr.adaming.model.Client;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/application-context.xml" })
@Transactional
public class ClientDaoImplTest {
	
	//test des methodes du Dao de Client
	@Autowired
	IClientDao clientDao;
	
	Adresse adresse=new Adresse("rue Crebillon", "24", 44000, "Nantes", "France");		
	Client client=new Client(adresse, 29, "TOTO");
	Client client2=new Client(adresse, 40, "FOFO",1);
	
	//methode getAllCLient
	@Ignore
	@Test
	@Transactional(readOnly=true)
	public void getAllTest(){
		
		assertNotNull(clientDao.getAllClient());
		
		
	}
	 //getbyNom
	@Ignore
	@Test
	@Transactional(readOnly=true)
	public void getByNomTest(){
		Client c1=clientDao.getByNom("TOTO");
		assertEquals("Nantes", c1.getAdresse().getLocalite());
	}
	
	
	//test methode ajouter
	@Ignore
	@Test
	@Rollback(true)
	@Transactional
	public void addClientTest(){
		int tailleAvant=clientDao.getAllClient().size();
		clientDao.addClient(client);
		assertEquals(tailleAvant+1,clientDao.getAllClient().size());
	}
	
	//methode modifier
	@Ignore
	@Test
	@Rollback(true)
	@Transactional
	public void updateTest(){
		Client c2=clientDao.getByNom("TOTO");
		c2.setNom("TITI");
		Client cModif=clientDao.updateClient(c2);
		
		assertEquals("TITI", cModif.getNom());
		
	}
	
	//test delete
	@Ignore
	@Test
	@Rollback(true)
	@Transactional
	 public void deleteTest(){
		 int tailleAvant=clientDao.getAllClient().size();
		 Client c3=clientDao.getByNom("TOTO");
		 int verif=clientDao.deleteClient(c3);
		 assertEquals(1, verif);
		 
	 }
	
}
