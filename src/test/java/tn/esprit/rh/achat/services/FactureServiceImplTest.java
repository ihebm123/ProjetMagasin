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
@Slf4j
@SpringBootTest
class FactureServiceImplTest {
	
	@Mock
	FactureRepository factureRepository;
	
	@Autowired
	FactureServiceImpl factureServiceImpl;
	
	
//	@BeforeEach
//	void setUp() {
//		this.factureServiceImpl = new FactureServiceImpl(factureRepository);
//	}
	
	@Test
	@Order(0)
	void createFactureTest() {
		Facture f = new Facture();
		f.setMontantRemise(15);
		f.setMontantFacture(15000);
		f.setDateCreationFacture(new Date());
		f.setDateDerniereModificationFacture(new Date());
		f.setArchivee(false);
		Facture savedFacture = factureServiceImpl.addFacture(f);
		log.info("SAVED FACTURE => "+savedFacture.toString());
		assertNotNull(savedFacture.getIdFacture());
	}
	
	@Test
	@Order(1)
	void getFacturesTest() {
		List<Facture> factures = this.factureServiceImpl.retrieveAllFactures();
		log.info("LIST FACTURES DESSOUS:");
		int i = 1;
		for (Facture facture : factures) {
			log.info(i+" - : "+facture.toString());
			i++;
		}
		assertNotNull(factures);
	}
	
	
	
	
	
}
