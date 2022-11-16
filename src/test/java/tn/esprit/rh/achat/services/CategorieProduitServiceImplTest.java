package tn.esprit.rh.achat.services;


import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import lombok.extern.slf4j.Slf4j;
//import org.junit.Test;
import org.junit.jupiter.api.Test;
import tn.esprit.rh.achat.entities.CategorieProduit;
import tn.esprit.rh.achat.repositories.CategorieProduitRepository;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;



import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@ExtendWith(MockitoExtension.class)
public class CategorieProduitServiceImplTest {
	@Mock
	CategorieProduitRepository categorieProduitRepository;

	@InjectMocks
	CategorieProduitServiceImpl categorieProduitService;
	
	
    private CategorieProduit categorieProduit1 = new CategorieProduit(1L,"categorieProduit Mock1", "gadu",null);
    private CategorieProduit categorieProduit2 = new CategorieProduit(2L,"categorieProduit Mock23", "9adour",null);

   
    @Test
    public void MockAddCategorieProduit() {
        when(categorieProduitRepository.save(categorieProduit1)).thenReturn(categorieProduit1);
        assertNotNull(categorieProduit1);
        assertEquals(categorieProduit1, categorieProduitService.addCategorieProduit(categorieProduit1));
        log.info("add works !!");
    }
    @Test
    public void TestRetrieveAllCategorieProduits() {
        when(categorieProduitRepository.findAll()).thenReturn(Stream
                .of(categorieProduit1,categorieProduit2)
                .collect(Collectors.toList()));
        assertEquals(2,categorieProduitService.retrieveAllCategorieProduits().size());
        log.info("Retrieve  works !");
    }
    @Test
    public void TestDeleteCategorieProduit() {
        categorieProduitRepository.save(categorieProduit1);
        categorieProduitService.deleteCategorieProduit(categorieProduit1.getIdCategorieProduit());
        verify(categorieProduitRepository, times(1)).deleteById(categorieProduit1.getIdCategorieProduit());
        log.info("Delete works !");
    }
    @Test
    public void TestUpdateCategorieProduit() {
        when(categorieProduitRepository.save(categorieProduit1)).thenReturn(categorieProduit1);
        assertNotNull(categorieProduit1);
        assertEquals(categorieProduit1, categorieProduitService.updateCategorieProduit(categorieProduit1));
        log.info("Update works !!");
    }
    @Test
    public void TestRetrieveCategorieProduit() {
        when(categorieProduitRepository.findById(categorieProduit1.getIdCategorieProduit())).thenReturn(Optional.of(categorieProduit1));
        assertEquals(categorieProduit1, categorieProduitService.retrieveCategorieProduit(categorieProduit1.getIdCategorieProduit()));
        log.info("Retrieve works !!");
    }

}