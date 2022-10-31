package tn.esprit.rh.achat.services;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import tn.esprit.rh.achat.entities.Stock;
import tn.esprit.rh.achat.repositories.StockRepository;

@ExtendWith(MockitoExtension.class)
public class StockServiceImpMock {

	
	@Mock
	StockRepository stockRepository;

	@InjectMocks
	StockServiceImpl stockService;
	ProduitServiceImpl produitService;
	
	Stock stock = new Stock ("stock1", 50, 60);
	/*List<Stock> listStocks = new ArrayList<Stock>() {
	{
	add(new Stock ("stock2", 100, 70));
	add(new Stock ("stock3", 50, 100));
	}
	};*/
	
	/*Produit p = new Produit ("ba10", "banan", 6000 , new Date(), new Date() );
	List<Stock> listUsers = new ArrayList<Stock>() {
	{
	add(new Produit ("ba10", "banan", 6000 , new Date(), new Date() ));
	add(new Produit ("ba10", "banan", 6000 , new Date(), new Date() ));
	}
	};*/
	
	/*public void testRetrieveAllStocks() {
	
	Mockito.when(stockRepository.findAll()).thenReturn(listStocks);
	
	assertEquals(listStocks.size(), stockService.retrieveAllStocks().size());

}

public void retrieveStock(Long stockId) {
	
	Mockito.when(stockRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(stock) );
	
	Stock s = stockService.retrieveStock(3L);

	
	assertNotNull(s);
	
}*/
	
}
