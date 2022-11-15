package tn.esprit.rh.achat.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.jupiter.api.Order;
//import org.junit.jupiter.api.Test;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import lombok.extern.slf4j.Slf4j;
import tn.esprit.rh.achat.entities.SecteurActivite;


//@TestMethodOrder(OrderAnnotation.class)
@RunWith(SpringRunner.class)
@Slf4j
@SpringBootTest
public class SecteurActiviteImplTest2 {
	@Autowired
	ISecteurActiviteService iSecteurActiviteService;
	

	
	@Test
	public void testAddSecteurActivite() {

		List<SecteurActivite> secteurs = iSecteurActiviteService.retrieveAllSecteurActivite();
		int expected=secteurs.size();
		SecteurActivite s = new SecteurActivite();
		s.setLibelleSecteurActivite("secteur test");
		s.setCodeSecteurActivite("secteur amira");	
		
		
		SecteurActivite savedSecteurActivite= iSecteurActiviteService.addSecteurActivite(s);
		assertEquals(expected+1, iSecteurActiviteService.retrieveAllSecteurActivite().size());
		assertNotNull(savedSecteurActivite.getLibelleSecteurActivite());


	} 
	
	
	@Test
	public void testDeleteSecteurActivite()
	{
		iSecteurActiviteService.deleteSecteurActivite(7L);
		assertNull(iSecteurActiviteService.retrieveSecteurActivite(7L));
	}
	

	@Test
	public void testRetrieveAllSecteurActivites()
	{
		List<SecteurActivite> stocks = iSecteurActiviteService.retrieveAllSecteurActivite();
		assertEquals(4,stocks.size());
	}
	

	@Test
	public void testRetrieveSecteurActivite()
	{
		SecteurActivite stock = iSecteurActiviteService.retrieveSecteurActivite(6L);
		assertEquals(6L,stock.getIdSecteurActivite().longValue());
		
	}
	
	
	@Test
	public void testUpdateSecteurActivite()
	{
		SecteurActivite s = new SecteurActivite();
		s.setIdSecteurActivite(1L);
		s.setLibelleSecteurActivite("secteur test");
		s.setCodeSecteurActivite("secteur amira");	;
		SecteurActivite updatedSecteurActivite=iSecteurActiviteService.updateSecteurActivite(s);
		assertEquals(s.getLibelleSecteurActivite(),updatedSecteurActivite.getLibelleSecteurActivite());
	}
	

}
