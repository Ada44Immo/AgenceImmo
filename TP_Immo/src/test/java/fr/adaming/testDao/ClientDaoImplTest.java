//package fr.adaming.testDao;
//
//import static org.junit.Assert.*;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.annotation.Rollback;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.transaction.annotation.Transactional;
//
//import fr.adaming.dao.IClientDao;
//import fr.adaming.model.Adresse;
//import fr.adaming.model.Client;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/application-context.xml" })
//@Transactional
//public class ClientDaoImplTest {
//	
//	//test des methodes du Dao de Client
//	@Autowired
//	IClientDao clientDao;
//	
//	Adresse adresse=new Adresse("rue Crebillon", "24", 44000, "Nantes", "France");		
//	Client client=new Client(adresse, 29, "TOTO");
//	
//	//methode getAllCLient
//	@Test
//	@Transactional(readOnly=true)
//	public void getAllTest(){
//		
//		assertNotNull(clientDao.getAllClient());
//		
//		
//	}
//	
//	
//	//test methode ajouter
////	@Test
////	@Rollback(true)
////	@Transactional
////	public void addClientTest(){
////		int tailleAvant=clientDao.getAllClient().size();
////		clientDao.addClient(client);
////		assertEquals(tailleAvant+1,clientDao.getAllClient().size());
////	}
//	
//	//methode modifier
////	public void updateTest(){
////		client.setNom("FOFO");
////		Client cModif=clientDao.updateClient(client);
////		
////		assertEquals("FOFO", cModif.getNom());
////		
////	}
//	
//	
//	
//}
