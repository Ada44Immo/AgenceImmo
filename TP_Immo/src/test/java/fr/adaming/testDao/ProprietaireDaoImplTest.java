package fr.adaming.testDao;

import static org.junit.Assert.assertNotNull;

import java.util.List;

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
	@Transactional
	@Rollback(true)
	public void testAddProprietaire(){
		Proprietaire p = new Proprietaire(adresse, 2558, "dolt");
		p=proprietaireDao.addProprietaire(p);
		assertNotNull(p.getId());
	}
	
	// public List<Proprietaire> getAllPropietaire(); 


//	public Proprietaire updateProprietaire(Proprietaire p);
//
//	public int deleteProprietaire(int id);
//
//	public Proprietaire getProprietaireById(int id);
}
