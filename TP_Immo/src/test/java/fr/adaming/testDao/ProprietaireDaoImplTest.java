package fr.adaming.testDao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IProprietaireDao;
import fr.adaming.model.Adresse;
import fr.adaming.model.Proprietaire;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/application-context.xml" })
public class ProprietaireDaoImplTest {

	@Autowired
	private IProprietaireDao proprietaireDao;
	private Adresse adresse = new Adresse("a", "152", 456, "ko", "kol");

	// Test des methodes

	@Ignore
	@Test
	@Transactional(readOnly = true)
	public void testGetAllPropietaire() {
		assertEquals(2, proprietaireDao.getAllProprietaire().size());
	}

	@Ignore
	@Test
	@Transactional
	@Rollback(true)
	public void testAddProprietaire() {
		Proprietaire p = new Proprietaire(adresse, 2558, "dolt");
		p = proprietaireDao.addProprietaire(p);
		assertNotNull(p.getId());
	}

	@Ignore
	@Test
	@Transactional(readOnly = true)
	public void testGetProprietaireById() {
		Proprietaire p = proprietaireDao.getProprietaireById(2);
		assertNotNull(p);
	}

	@Ignore
	@Test
	@Transactional
	@Rollback(true)
	public void testUpdateProprietaire() {
		Proprietaire p = new Proprietaire(adresse, 2558, "dolt");
		p.setId(2);
		p = proprietaireDao.updateProprietaire(p);
		Proprietaire pOut = proprietaireDao.getProprietaireById(2);
		assertEquals(p.getNom(), pOut.getNom());
	}

	@Ignore
	@Test
	@Transactional
	@Rollback(true)
	public void testDeleteProprietaire() {
		int size = proprietaireDao.getAllProprietaire().size();
		proprietaireDao.deleteProprietaire(2);
		assertEquals(size, proprietaireDao.getAllProprietaire().size() + 1);
	}
}
