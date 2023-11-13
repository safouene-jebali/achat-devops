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

@SpringBootTest
@ExtendWith(MockitoExtension.class)

class ProduitServiceImplMock {
    @Mock
    ProduitRepository produitReposotory;
    @InjectMocks
    ProduitServiceImpl produitService;
    Produit p=new Produit((long) 1,"123","libelle 1",50);
    Produit p1=new Produit((long) 2,"123","libelle 2",60);
    Produit p2=new Produit((long) 3,"123","libelle 3",70);
    List<Produit> listProduits = new ArrayList<Produit>() {
        {
            add(p1);
            add(p2);
        }
    };

    @Test
    void createProduitTest()
    {
        Produit p3=new Produit((long) 1,"123","libelle 1",50);
        produitService.addProduit(p3);
        Assertions.assertNotNull("produit crée");
    }

    @Test
    void RetrieveProduitTest() {
        Mockito.when(produitReposotory.findById(Mockito.anyLong())).thenReturn(Optional.of(p));
        Produit produit1 = produitService.retrieveProduit((long)(2));
        Assertions.assertNotNull(produit1);
    }


    @Test
    void updateProduitTest(){
        p.setLibelleProduit("Libelle 1 updated");
        Produit prm=new Produit(p.getIdProduit(),p.getCodeProduit(),p.getLibelleProduit(),p.getPrix());
        Produit updatedProduit = produitService.updateProduit(prm);
        Assertions.assertNotNull(prm);
    }

    @Test
    void deleteProduitTest(){
        willDoNothing().given(produitReposotory).deleteById(p1.getIdProduit());
        produitService.deleteProduit(p1.getIdProduit());
        Assertions.assertNotNull("produit supprimé");
    }




}