package tn.esprit.rh.achat;
import tn.esprit.rh.achat.services.IFournisseurService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.rh.achat.entities.Fournisseur;
import java.util.List;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class FournisseurServiceImplTest {
    @Autowired
    IFournisseurService fs;
    @Test
    @Order(1)
    void testRetrieveAllUsers() {
        List<Fournisseur> listFournisseurs = fs.retrieveAllFournisseurs();
        Assertions.assertEquals(0, listFournisseurs.size());
    }
}
