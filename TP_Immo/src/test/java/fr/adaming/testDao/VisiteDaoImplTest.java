package fr.adaming.testDao;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IVisiteDao;
import fr.adaming.model.Achat;
import fr.adaming.model.Adresse;
import fr.adaming.model.Agent;
import fr.adaming.model.Location;
import fr.adaming.model.Proprietaire;
import fr.adaming.model.Visite;

@RunWith(SpringJUnit4ClassRunner.class) // Pour lancer les test avec le module
										// test de spring
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/application-context.xml" })
@Transactional
public class VisiteDaoImplTest {

	@Autowired
	IVisiteDao visiteDao;

	
	// OK
	@Ignore
	@Test
	public void testGetAllVisite() {
		assertEquals(4, visiteDao.getAllVisite().size());
	}

	// OK
	@Ignore
	@Test
	@Rollback
	public void testAddVisite() {
		visiteDao.addVisite(new Visite(new Date()));
		assertEquals(5, visiteDao.getAllVisite().size());
	}

	// OK
	@Ignore
	@Test
	public void testGetVisiteByAgent() {
		assertEquals(4, visiteDao.getVisiteByAgent(new Agent(1, "a@a", "a")).size());
	}

	// OK
	@Ignore
	@Test
	@Rollback
	public void testDeleteVisite() {
		int before = visiteDao.getAllVisite().size();
		visiteDao.deleteVisite(1);
		assertEquals(before - 1, visiteDao.getAllVisite().size());
	}

	// OK
	@Ignore
	@Test
	public void testGetVisiteById() {
		Visite vTest = new Visite(1, new Date());
		vTest.setAgent(new Agent(1, "a@a", "a"));
		assertEquals(vTest.getAgent().getMail(), visiteDao.getVisiteById(1).getAgent().getMail());
	}

	// OK
	@Ignore
	@Test
	@Rollback
	public void testUpdateVisite() {
		Visite vTest = visiteDao.getVisiteById(1);
		vTest.setAgent(new Agent(2, "b@b", "a"));
		visiteDao.updateVisite(vTest);
		assertEquals(visiteDao.getVisiteById(vTest.getId()).getAgent().getMail(), vTest.getAgent().getMail());
	}

	
//	 @Test
//	 public void testGetVisiteByDate(){
//		 SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
//		 Date dateIn = new Date();
//		try {
//			dateIn = sdf.parse("2038-01-19");
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		 System.out.println("Year" +dateIn.getYear());
//		 System.out.println(" Month" +dateIn.getMonth());
//		 System.out.println(" Day" +dateIn.getDate());
//		 int verif=	visiteDao.getVisiteByDate(dateIn).size();
//		 assertEquals(2, verif);
//		 
//	 }
	

}
