package tn.esprit.rh.achat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.rh.achat.entities.SecteurActivite;
import tn.esprit.rh.achat.repositories.SecteurActiviteRepository;
import tn.esprit.rh.achat.services.SecteurActiviteServiceImpl;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class SecteurActiviteServiceImplTest {

    @InjectMocks
    private SecteurActiviteServiceImpl secteurActiviteService;

    @Mock
    private SecteurActiviteRepository secteurActiviteRepository;

    @BeforeEach
    public void setUp() {
        // Initialisation des mocks avant chaque test
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testRetrieveAllSecteurActivite() {
        // Mock the repository behavior
        when(secteurActiviteRepository.findAll()).thenReturn(Arrays.asList(new SecteurActivite(), new SecteurActivite()));

        // Test the service method
        List<SecteurActivite> result = secteurActiviteService.retrieveAllSecteurActivite();

        // Assertions
        assertEquals(2, result.size());
    }

    @Test
    public void testAddSecteurActivite() {
        SecteurActivite sa = new SecteurActivite();

        // Mock the repository behavior
        when(secteurActiviteRepository.save(sa)).thenReturn(sa);

        // Test the service method
        SecteurActivite result = secteurActiviteService.addSecteurActivite(sa);

        // Assertions
        assertEquals(sa, result);
    }

    @Test
    public void testDeleteSecteurActivite() {
        Long idToDelete = 1L;

        // Test the service method
        secteurActiviteService.deleteSecteurActivite(idToDelete);

        // Verify that the repository's deleteById method was called with the correct argument
        verify(secteurActiviteRepository, times(1)).deleteById(idToDelete);
    }

    @Test
    public void testUpdateSecteurActivite() {
        SecteurActivite sa = new SecteurActivite();

        // Test the service method
        secteurActiviteService.updateSecteurActivite(sa);

        // Verify that the repository's save method was called with the correct argument
        verify(secteurActiviteRepository, times(1)).save(sa);
    }

    @Test
    public void testRetrieveSecteurActivite() {
        Long idToRetrieve = 1L;
        SecteurActivite sa = new SecteurActivite();

        // Mock the repository behavior
        when(secteurActiviteRepository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(sa));

        // Test the service method
        SecteurActivite result = secteurActiviteService.retrieveSecteurActivite(idToRetrieve);

        // Assertions
        assertEquals(sa, result);
    }
}
