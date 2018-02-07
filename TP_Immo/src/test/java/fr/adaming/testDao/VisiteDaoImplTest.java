//package fr.adaming.testDao;
//
//import static org.junit.Assert.assertEquals;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//import org.junit.Ignore;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.annotation.Rollback;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.transaction.annotation.Transactional;
//
//import fr.adaming.dao.IVisiteDao;
//import fr.adaming.model.Achat;
//import fr.adaming.model.Adresse;
//import fr.adaming.model.Agent;
//import fr.adaming.model.Location;
//import fr.adaming.model.Proprietaire;
//import fr.adaming.model.Visite;
//
////@RunWith(SpringJUnit4ClassRunner.class) // Pour lancer les test avec le module
//										// test de spring
////@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/application-context.xml" })
////@Transactional
//public class VisiteDaoImplTest {
//
//	@Autowired
//	IVisiteDao visiteDao;
//
//	@Test
//	public void testGetAllVisite() {
//		assertEquals(4, visiteDao.getAllVisite().size());
//	}
//
//	@Test
//	@Rollback
//	public void testAddVisite() {
//		visiteDao.addVisite(new Visite(new Date()));
//		assertEquals(5, visiteDao.getAllVisite().size());
//	}
//
//	@Test
//	public void testGetVisiteByAgent() {
//		assertEquals(4, visiteDao.getVisiteByAgent(new Agent(1, "a@a", "a")).size());
//	}
//
//	@Test
//	@Rollback
//	public void testDeleteVisite() {
//		int before = visiteDao.getAllVisite().size();
//		visiteDao.deleteVisite(1);
//		assertEquals(before - 1, visiteDao.getAllVisite().size());
//	}
//
//	@Test
//	public void testGetVisiteById() {
//		 Visite vTest=new Visite(1,new Date());
//		 vTest.setAgent(new Agent(1, "a@a", "a"));
//		assertEquals(vTest.getAgent().getMail(), visiteDao.getVisiteById(1).getAgent().getMail());
//	}
//
//	 @Test
//	 @Rollback
//	 public void testUpdateVisite() {
//		 Visite vTest =visiteDao.getVisiteById(1);
//		 vTest.setAgent(new Agent(2, "b@b", "a"));
//	 visiteDao.updateVisite(vTest);
//	 assertEquals(visiteDao.getVisiteById(vTest.getId()).getAgent().getMail(), vTest.getAgent().getMail());
//	 }
//
////	 @Test
////	 public void testGetVisiteByBienLocation(){
////		assertEquals(2,visiteDao.getVisiteByBienLocation(new Location("statut", null, null , null, "description",null,null,1,null,null,null,null,null,null,null)).size());
////	 }
//	 
//		
//
//}
