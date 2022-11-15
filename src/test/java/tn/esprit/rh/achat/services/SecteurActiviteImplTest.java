package tn.esprit.rh.achat.services;


import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import lombok.extern.slf4j.Slf4j;
//import org.junit.Test;
import org.junit.jupiter.api.Test;
import tn.esprit.rh.achat.entities.SecteurActivite;
import tn.esprit.rh.achat.repositories.SecteurActiviteRepository;
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
public class SecteurActiviteImplTest {
	@Mock
	SecteurActiviteRepository stockRepository;

	@InjectMocks
	SecteurActiviteServiceImpl stockService;
	
	
    private SecteurActivite secteur1 = new SecteurActivite(1L,"secteur Mock1", "amiraActivite",null);
    private SecteurActivite secteur2 = new SecteurActivite(2L,"secteur Mock23", "amiraActivite2",null);

   
    @Test
    public void MockAddSecteurActivite() {
        when(stockRepository.save(secteur1)).thenReturn(secteur1);
        assertNotNull(secteur1);
        assertEquals(secteur1, stockService.addSecteurActivite(secteur1));
        log.info("add works !!");
    }
    @Test
    public void TestRetrieveAllSecteurActivites() {
        when(stockRepository.findAll()).thenReturn(Stream
                .of(secteur1,secteur2)
                .collect(Collectors.toList()));
        assertEquals(2,stockService.retrieveAllSecteurActivite().size());
        log.info("Retrieve stocks works !");
    }
    @Test
    public void TestDeleteSecteurActivite() {
        stockRepository.save(secteur1);
        stockService.deleteSecteurActivite(secteur1.getIdSecteurActivite());
        verify(stockRepository, times(1)).deleteById(secteur1.getIdSecteurActivite());
        log.info("Delete works !");
    }
    @Test
    public void TestUpdateSecteurActivite() {
        when(stockRepository.save(secteur1)).thenReturn(secteur1);
        assertNotNull(secteur1);
        assertEquals(secteur1, stockService.updateSecteurActivite(secteur1));
        log.info("Update works !!");
    }
    @Test
    public void TestRetrieveSecteurActivite() {
        when(stockRepository.findById(secteur1.getIdSecteurActivite())).thenReturn(Optional.of(secteur1));
        assertEquals(secteur1, stockService.retrieveSecteurActivite(secteur1.getIdSecteurActivite()));
        log.info("Retrieve works !!");
    }

}
