package tn.esprit.rh.achat.services;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

import org.apache.commons.logging.Log;
import org.apache.logging.log4j.Logger;

import tn.esprit.rh.achat.entities.Facture;
import tn.esprit.rh.achat.repositories.FactureRepository;
import tn.esprit.rh.achat.services.FactureServiceImpl;

@ExtendWith(MockitoExtension.class)
@RunWith(SpringRunner.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Slf4j
@SpringBootTest(classes = FactureServiceImplTest.class)
class FactureServiceImplTest {
	
	@Mock
    FactureRepository factureRepository;
    @InjectMocks
    FactureServiceImpl factureService;

    Date dateCreationFacture = new Date("12/12/2002");
    Date dateDerniereModificationFacture = new Date("12/12/2012");

    //DetailFacture detailsFacture = new DetailFacture(2, )

    Facture facture = new Facture(1L, 3f, 2f, dateCreationFacture, dateDerniereModificationFacture, Boolean.FALSE);
    List<Facture> factureList = Arrays.asList(facture);

    @Test
    @Order(2)
    void retrieveAllFactures() {

        log.debug("Tester Retrive All fatures");
        when(factureRepository.findAll()).thenReturn(factureList);
        List<Facture> factureList = factureService.retrieveAllFactures();
        Assertions.assertNotNull(factureList);
    }


    @Test
    @Order(1)
    void addFacture() {

        log.debug("Tester Ajout du facture");
        when(factureRepository.save(ArgumentMatchers.any(Facture.class))).thenReturn(facture);

        // utiliser la methode dans le service
        Facture created = factureService.addFacture(facture);
        // verifier que produit existe
        Assertions.assertEquals(created.getIdFacture(), (facture.getIdFacture()));
    }

    /*@Test
    @Order(4)
    void cancelFacture() {
        log.debug("Test méthode cancel facture");
        when(factureRepository.save(ArgumentMatchers.any(Facture.class))).thenReturn(facture);
        factureService.cancelFacture(1L);
        //Assertions.assertTrue(facture.getArchivee());
    }*/

    @Test
    @Order(3)
    void retrieveFacture() {
        log.debug("Tester retrive du produit");
        when(factureRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(facture));
        // utiliser la methode dans le service
        Facture fatureRetrived = factureService.retrieveFacture(1L);
        // verifier que produit existe
        Assertions.assertNotNull(fatureRetrived);

    }

    /*@Test
    @Order(4)
    void getFacturesByFournisseur() {
    }
    @Test
    @Order(5)
    void assignOperateurToFacture() {
    }*/

    /*@Test
    @Order(4)
    void pourcentageRecouvrement() {
    }*/
	
}
