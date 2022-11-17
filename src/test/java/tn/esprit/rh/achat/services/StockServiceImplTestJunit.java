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
import tn.esprit.rh.achat.entities.Stock;


//@TestMethodOrder(OrderAnnotation.class)
@RunWith(SpringRunner.class)
@Slf4j
@SpringBootTest
public class StockServiceImplTestJunit {

	@Autowired
	IStockService iStockService;
	

	
	@Test
	public void testAddStock() {

		List<Stock> stocks = iStockService.retrieveAllStocks();
		int expected=stocks.size();
		Stock s = new Stock();
		s.setLibelleStock("stock test");
		s.setQte(11);
		s.setQteMin(1001);
		Stock savedStock= iStockService.addStock(s);
		assertEquals(expected+1, iStockService.retrieveAllStocks().size());
		assertNotNull(savedStock.getLibelleStock());


	} 
	
	
	@Test
	public void testDeleteStock()
	{
		iStockService.deleteStock(7L);
		assertNull(iStockService.retrieveStock(7L));
	}
	

	@Test
	public void testRetrieveAllStocks()
	{
		List<Stock> stocks = iStockService.retrieveAllStocks();
		assertEquals(4,stocks.size());
	}
	

	@Test
	public void testRetrieveStock()
	{
		Stock stock = iStockService.retrieveStock(6L);
		assertEquals(6L,stock.getIdStock().longValue());
		
	}
	
	
	@Test
	public void testUpdateStock()
	{
		Stock s = new Stock();
		s.setIdStock(1L);
		s.setLibelleStock("stock test");
		s.setQte(500);
		s.setQteMin(5000);
		Stock updatedStock=iStockService.updateStock(s);
		assertEquals(s.getLibelleStock(),updatedStock.getLibelleStock());
	}
	
	
	
	
	



	
	

	
	

}