package tn.esprit.rh.achat.service;

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
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.rh.achat.entities.Produit;

import tn.esprit.rh.achat.repositories.ProduitRepository;
import tn.esprit.rh.achat.services.ProduitServiceImpl;

@ExtendWith(MockitoExtension.class)
class TestProduitServiceImplMock {
    @Mock
    ProduitRepository produitReposotory;
    @InjectMocks
    ProduitServiceImpl produitService;
    Produit p=new Produit((long) 1,"123","libelle 1",50);
    Produit p1=new Produit((long) 2,"124","libelle 2",60);
    Produit p2=new Produit((long) 3,"125","libelle 3",70);
    List<Produit> listProduits = new ArrayList<Produit>() {
        {
            add(p1);
            add(p2);
        }
    };

    @Test
    void testAddProduit()
    {
        Produit p3=new Produit((long) 4,"126","libelle 4",50);
        Assertions.assertNotNull(produitService.addProduit(p3));
    }

    @Test
    void testRetrieveProduit() {
        Mockito.when(produitReposotory.findById(Mockito.anyLong())).thenReturn(Optional.of(p));
        Assertions.assertNotNull(produitService.retrieveProduit((long)(2)));
    }


    @Test
    void testUpdateProduit(){
        Mockito.when(produitReposotory.save(p)).thenReturn(p);
        p.setLibelleProduit("Libelle 1 updated");
        Produit produit = produitService.updateProduit(p);
        Assertions.assertEquals(p,produit);
    }

    @Test
    void testDeleteProduit(){
        produitService.deleteProduit(p1.getIdProduit());
        Assertions.assertNotNull(listProduits);
    }




}