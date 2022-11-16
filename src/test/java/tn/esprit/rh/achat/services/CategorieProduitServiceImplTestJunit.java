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
import tn.esprit.rh.achat.entities.CategorieProduit;
import tn.esprit.rh.achat.entities.CategorieProduit;

//@TestMethodOrder(OrderAnnotation.class)
@RunWith(SpringRunner.class)
@Slf4j
@SpringBootTest
public class CategorieProduitServiceImplTestJunit {

	@Autowired
	ICategorieProduitService iCategorieProduitService;
	

	
	@Test
	public void testAddCategorieProduit() {
		List<CategorieProduit> categorieProduits = iCategorieProduitService.retrieveAllCategorieProduits();
		int expected=categorieProduits.size();
		CategorieProduit s = new CategorieProduit();
		s.setCodeCategorie("cat1");;
		s.setLibelleCategorie("sport");
		
		CategorieProduit savedCategorieProduit= iCategorieProduitService.addCategorieProduit(s);
		assertEquals(expected+1, iCategorieProduitService.retrieveAllCategorieProduits().size());
		assertNotNull(savedCategorieProduit.getLibelleCategorie());
	} 
	
	
	@Test
	public void testDeleteCategorieProduit()
	{
		iCategorieProduitService.deleteCategorieProduit(2L);
		assertNull(iCategorieProduitService.retrieveCategorieProduit(2L));
	}
	
	@Test
	public void testRetrieveAllCategorieProduits()
	{
		List<CategorieProduit> CategorieProduits = iCategorieProduitService.retrieveAllCategorieProduits();
		assertEquals(4,CategorieProduits.size());
	}
	
	@Test
	public void testRetrieveCategorieProduit()
	{
		CategorieProduit CategorieProduit = iCategorieProduitService.retrieveCategorieProduit(5L);
		assertEquals(5L,CategorieProduit.getIdCategorieProduit().longValue());
		
	}
	
	
	@Test
	public void testUpdateCategorieProduit()
	{
		CategorieProduit s = new CategorieProduit();
		s.setIdCategorieProduit(1L);
		s.setCodeCategorie("Cat2");
		s.setLibelleCategorie("cuisine");
		
		CategorieProduit updatedCategorieProduit=iCategorieProduitService.updateCategorieProduit(s);
		assertEquals(s.getLibelleCategorie(),updatedCategorieProduit.getLibelleCategorie());
	}
	
	
	
	




	
	

	
	

}