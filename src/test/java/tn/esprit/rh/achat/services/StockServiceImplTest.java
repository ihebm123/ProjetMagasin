package tn.esprit.rh.achat.services;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.rh.achat.entities.Stock;



//@RunWith(SpringRunner.class)
@Slf4j
//@TestMethodOrder(OrderAnnotation.class)
@SpringBootTest
public class StockServiceImplTest {

	@Autowired
	IStockService stockService;

	Stock s = new Stock();



	@Test
	//@Order(0)
	public void testAddStock() {

		s.setLibelleStock("stock test");
		s.setQte(11);
		s.setQteMin(1001);

		//Stock savedStock= stockService.addStock(s);

		assertNotNull(s.getLibelleStock());

	} 

}
