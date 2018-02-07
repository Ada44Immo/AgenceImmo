package fr.adaming.testDao;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.ILocationDao;
import fr.adaming.model.Achat;
import fr.adaming.model.Adresse;
import fr.adaming.model.Location;

@RunWith(SpringJUnit4ClassRunner.class) // Pour lancer les test avec le module
// test de spring
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/application-context.xml" })
@Transactional
public class LocationDaoImplTest {

	@Autowired
	ILocationDao locationDao;

	//OK
	@Ignore
	@Test
	public void testGetAllLocation(){
		assertEquals(2, locationDao.getAllLocation().size());
	}
	
	//OK
	@Ignore
	@Test
	public void testGetLocationById(){
		Location loc=locationDao.getLocationById(2);
		Double d=(double) 100;
		assertEquals(d,(Double) loc.getCaution());
	}
	
	//OK
	@Ignore
	@Test
	@Rollback
	public void testAddLocation(){
		int verif = locationDao.getAllLocation().size();
		Location l = new Location();
		l.setAdresse(new Adresse());
		locationDao.addLocation(l);
		assertEquals(verif + 1, locationDao.getAllLocation().size());
	}
	
	//OK
	@Ignore
	@Test
	@Rollback
	public void testUpdateLocation(){
		Location lIn = locationDao.getLocationById(2);
		lIn.setCaution(5000);
		locationDao.updateLocation(lIn);
		Location lOut = locationDao.getLocationById(2);
		assertEquals((Double) lIn.getCaution(), (Double) lOut.getCaution());
	}
	
	//Ok
	@Ignore
	@Test
	@Rollback
	public void testDeleteLocation(){
		int verif = locationDao.getAllLocation().size();
		locationDao.deleteLocation(3);
		assertEquals(verif - 1, locationDao.getAllLocation().size());
	}
	
	//OK
	@Ignore
	@Test
	public void testgetLocationByLocalite(){
		assertEquals(2, locationDao.getLocationByLocalite("rennes").size());
	}
	
}
