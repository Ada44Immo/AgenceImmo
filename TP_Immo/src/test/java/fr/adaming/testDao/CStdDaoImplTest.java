package fr.adaming.testDao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.ICStdDao;
import fr.adaming.model.ClasseStandard;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/application-context.xml" })
public class CStdDaoImplTest {

	@Autowired
	ICStdDao cStdDao;

	ClasseStandard cs = new ClasseStandard("Manoir", true, 30000.0, 500.0);
	ClasseStandard csmodif = new ClasseStandard(1, "Chateau", true, 30000.0, 500.0);

	// test methode ajouter
	@Ignore
	@Test
	@Transactional
	public void testAddCStd() { // pas fini
		int tailleAvant = cStdDao.getAllCStd().size();
		ClasseStandard c = cStdDao.addCStd(cs);
		assertNotNull(c.getIdCode());
	}

	// methode getAllCStd
	@Ignore
	@Test
	@Transactional(readOnly = true)
	public void getAllCStdTest() {
		assertEquals(2, cStdDao.getAllCStd().size());
	}

	// test delete
	@Ignore
	@Test
	@Transactional
	public void deleteCStdTest() {
		assertEquals(1, cStdDao.deleteCStd(2));
	}

	// methode modifier
	@Ignore
	@Test
	@Transactional
	public void updateTest() {
		ClasseStandard c2 = cStdDao.getCStdByName("Manoir").get(0);
		c2.setType("Trololo");
		ClasseStandard cModif = cStdDao.updateCStd(c2);

		assertEquals("Trololo", cModif.getType());
	}

	//
	// ClasseStandard c1=clientDao.getByNom("TOTO");
	// assertEquals("Nantes", c1.getAdresse().getLocalite());
	// }
	//
	//
	//
	//
	// //methode modifier
	// @Ignore
	// @Test
	// @Rollback(true)
	// @Transactional
	// public void updateTest(){
	// Client c2=clientDao.getByNom("TOTO");
	// c2.setNom("TITI");
	// Client cModif=clientDao.updateClient(c2);
	//
	// assertEquals("TITI", cModif.getNom());
	//
	// }
	//
	// //test delete
	// @Ignore
	// @Test
	// @Rollback(true)
	// @Transactional
	// public void deleteTest(){
	// int tailleAvant=clientDao.getAllClient().size();
	// Client c3=clientDao.getByNom("TOTO");
	// int verif=clientDao.deleteClient(c3);
	// assertEquals(1, verif);
	//
	// }
	//
}
