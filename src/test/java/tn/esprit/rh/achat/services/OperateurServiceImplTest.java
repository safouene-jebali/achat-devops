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
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.rh.achat.entities.Operateur;

import tn.esprit.rh.achat.repositories.OperateurRepository;
import tn.esprit.rh.achat.services.OperateurServiceImpl;

//@SpringBootTest
@ExtendWith(MockitoExtension.class)

class OperateurServiceImplMock {
    @Mock
    OperateurRepository OperateurRepository;
    @InjectMocks
    OperateurServiceImpl OperateurService;
    Operateur O=new Operateur((long) 1,"123","libelle 1","11");
    Operateur O1=new Operateur((long) 2,"123","libelle 2","60");
    Operateur O2=new Operateur((long) 3,"123","libelle 3","70");
    List<Operateur> listOperateurs = new ArrayList<Operateur>() {
        {
            add(O1);
            add(O2);
        }
    };

    @Test
    void createOperateurTest()
    {
        Operateur O3=new Operateur((long) 1,"123","libelle 1","50");
        OperateurService.addOperateur(O3);
        Assertions.assertNotNull("Operateur crée");
    }

    @Test
    void RetrieveOperateurTest() {
        Mockito.when(OperateurRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(O));
        Operateur Operateur1 = OperateurService.retrieveOperateur((long)(2));
        Assertions.assertNotNull(Operateur1);
    }
    @Test
    void updateOperateurTest(){
        O.setNom("Operateur nom 1 updated");
        Operateur prm=new Operateur(O.getIdOperateur(),O.getNom(),O.getPrenom(),O.getPassword());
        Operateur updatedOperateur = OperateurService.updateOperateur(prm);
        Assertions.assertNotNull(prm);
    }




    @Test
    void deleteProduitTest(){
        willDoNothing().given(OperateurRepository).deleteById(O1.getIdOperateur());
        OperateurService.deleteOperateur(O1.getIdOperateur());
        Assertions.assertNotNull("Operateur supprimé");
    }


}