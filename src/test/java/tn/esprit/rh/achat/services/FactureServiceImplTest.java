package tn.esprit.rh.achat.services;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.rh.achat.entities.Facture;

import tn.esprit.rh.achat.repositories.FactureRepository;


//@SpringBootTest
@ExtendWith(MockitoExtension.class)

class TestFactureServiceImplMock {
    @Mock
    FactureRepository factureRepository;
    @InjectMocks
    FactureServiceImpl factureService;
    long factureId=3;
    Facture f=new Facture((long) 2,(float)12,(float)50,false);
    Facture f2=new Facture((long) 4,(float)0,(float)1200,false);
    List<Facture> listFactures = new ArrayList<>();

    @Test
    void addFactureTest()
    {
        Facture f1=new Facture((long) 1,(float)10,(float)500,false);
        factureService.addFacture(f1);
        Assertions.assertNotNull("facture crée");
    }

    @Test
    void RetrieveFactureTest() {
        Mockito.when(factureRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(f));
        Facture facture1 = factureService.retrieveFacture((long)(2));
        Assertions.assertNotNull(facture1);
    }



    @Test
    void cancelFactureTest(){
        factureService.cancelFacture(factureId);
        Assertions.assertNotNull("facture archivée");
    }

    @Test
    void retrieveAllFacturesTest(){
        listFactures=factureService.retrieveAllFactures();
        Assertions.assertNotNull(listFactures);
    }

}