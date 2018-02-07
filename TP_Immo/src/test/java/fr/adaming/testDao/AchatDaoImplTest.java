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

import fr.adaming.dao.IAchatDao;
import fr.adaming.model.Achat;
import fr.adaming.model.Adresse;

@RunWith(SpringJUnit4ClassRunner.class) // Pour lancer les test avec le module
										// test de spring
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/application-context.xml" })
@Transactional
public class AchatDaoImplTest {

	@Autowired
	IAchatDao achatDao;

	// Ok
	@Ignore
	@Test
	public void testGetAllAchat() {
		assertEquals(2, achatDao.getAllAchat().size());
	}

	// OK
	@Ignore
	@Test
	@Rollback
	public void testAddAchat() {
		int verif = achatDao.getAllAchat().size();
		Achat a = new Achat();
		a.setAdresse(new Adresse());
		achatDao.addAchat(a);
		assertEquals(verif + 1, achatDao.getAllAchat().size());
	}

	// OK
	@Ignore
	@Test
	public void testgetAchatById() {
		assertEquals("ok", achatDao.getAchatById(1).getEtat());
	}

	//OK
	@Ignore
	@Test
	@Rollback
	public void testDeleteAchat() {
		int verif = achatDao.getAllAchat().size();
		Achat a = new Achat();
		a.setAdresse(new Adresse());
		a.setId(3);
		achatDao.deleteAchat(a.getId());
		assertEquals(verif - 1, achatDao.getAllAchat().size());
	}
	
	//OK
	@Ignore
	@Test
	@Rollback
	public void testUpdateAchat(){
		Achat aIn = achatDao.getAchatById(3);
		aIn.setEtat("KO");
		achatDao.updateAchat(aIn);
		Achat aOut=achatDao.getAchatById(3);
		assertEquals(aIn.getEtat(), aOut.getEtat());
	}
	
	//OK
	@Ignore
	@Test
	public void getAchatById(){
		assertEquals(2, achatDao.getAchatByMotCle("rennes").size());
	}
	
	

}
