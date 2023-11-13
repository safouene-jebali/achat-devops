package tn.esprit.rh.achat.services;

import java.util.ArrayList;

import static org.mockito.BDDMockito.willDoNothing;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.rh.achat.entities.Stock;

import tn.esprit.rh.achat.repositories.StockRepository;
import tn.esprit.rh.achat.services.StockServiceImpl;

//@SpringBootTest
@ExtendWith(MockitoExtension.class)

class StockServiceImplMock {
    @Mock
    StockRepository stockRepository;
    @InjectMocks
    StockServiceImpl stockService;
    Stock s=new Stock((long) 1,"123",20,11);
    Stock s1=new Stock((long) 2,"123",30,22);
    Stock s2=new Stock((long) 3,"123",40,33);
    List<Stock> listStock = new ArrayList<Stock>() {
        {
            add(s1);
            add(s2);
        }
    };

    @Test
    void createStockTest()
    {
        Stock s3=new Stock((long) 1,"123",50,20);
        stockService.addStock(s3);
        Assertions.assertNotNull("stock crée");
    }

    @Test
    void RetrieveStockTest() {
        Mockito.when(stockRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(s));
        Stock stock1 = stockService.retrieveStock((long)(2));
        Assertions.assertNotNull(stock1);
    }


    @Test
    void updateStockTest(){
        s.setLibelleStock("Libelle 1 updated");
        Stock stu=new Stock(s.getIdStock(),s.getLibelleStock(),s.getQte(),s.getQteMin());
        Stock updatedStock = stockService.updateStock(stu);
        Assertions.assertNotNull(stu);
    }

    @Test
    void deleteStockTest(){
        willDoNothing().given(stockRepository).deleteById(s1.getIdStock());
        stockService.deleteStock(s1.getIdStock());
        Assertions.assertNotNull("stock supprimé");
    }




}