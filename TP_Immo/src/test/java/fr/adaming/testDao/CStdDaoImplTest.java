package fr.adaming.testDao;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.ICStdDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/application-context.xml"})
public class CStdDaoImplTest {

	@Autowired
	ICStdDao cStdDao;
	
	@Ignore
	@Test
	@Transactional(readOnly=true)
	public void testAddCStd(){ //pas fini
		assertEquals(0, cStdDao.getAllCStd().size());
	}
	
}
