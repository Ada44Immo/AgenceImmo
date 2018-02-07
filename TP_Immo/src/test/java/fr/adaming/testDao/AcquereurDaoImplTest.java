package fr.adaming.testDao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IAcquereurDao;
import fr.adaming.model.Acquereur;
import fr.adaming.model.Adresse;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/application-context.xml" })
public class AcquereurDaoImplTest {

	@Autowired
	private IAcquereurDao acquereurDao;
	private Adresse adresse = new Adresse("a", "152", 456, "ko", "kol");

	// Test des methodes

	@Ignore
	@Test
	@Transactional(readOnly = true)
	public void testGetAllAcquereur() {
		assertEquals(2, acquereurDao.getAllAcquereur().size());
	}

	@Ignore
	@Test
	@Transactional
	@Rollback(true)
	public void testAddAcquereur() {
		int size = acquereurDao.getAllAcquereur().size();
		Acquereur aOut = new Acquereur(adresse, 756, "JITO", 756, new Date());
		acquereurDao.addAcquereur(aOut);
		assertEquals(size, acquereurDao.getAllAcquereur().size() - 1);
	}

	@Ignore
	@Test
	@Transactional(readOnly = true)
	public void testGetAcquereurById() {
		Acquereur aOut = acquereurDao.getAcquereurById(2);
		assertNotNull(aOut);
	}

	@Ignore
	@Test
	@Transactional
	@Rollback(true)
	public void testUpdateAcquereur() {
		Acquereur aOut = new Acquereur(adresse, 756, "JITO", 756, new Date());
		aOut.setId(2);
		aOut = acquereurDao.updateAcquereur(aOut);
		Acquereur a = acquereurDao.getAcquereurById(2);
		assertEquals(aOut.getNom(), a.getNom());
	}

	@Ignore
	@Test
	@Transactional
	@Rollback(true)
	public void testDeleteAcquereur() {
		int size = acquereurDao.getAllAcquereur().size();
		acquereurDao.deleteAcquereur(2);
		assertEquals(size, acquereurDao.getAllAcquereur().size() + 1);
	}

}
