package fr.adaming.testDao;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IAchatDao;


@RunWith(SpringJUnit4ClassRunner.class) // Pour lancer les test avec le module
										// test de spring
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/application-context.xml" })
@Transactional
public class AchatDaoImplTest {

	@Autowired
	IAchatDao achatDao;
	
	//Ok
	@Ignore
	@Test
	public void testGetAllAchat(){
		assertEquals(2, achatDao.getAllAchat().size());
	}

}
