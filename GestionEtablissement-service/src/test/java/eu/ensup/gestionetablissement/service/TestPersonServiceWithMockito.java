package eu.ensup.gestionetablissement.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import eu.ensup.gestionetablissement.business.Person;
import eu.ensup.gestionetablissement.business.Role;
import eu.ensup.gestionetablissement.dao.ExceptionDao;
import eu.ensup.gestionetablissement.dao.IDao;
import eu.ensup.gestionetablissement.dao.IPersonDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class TestPersonServiceWithMockito {

    @Mock
    IPersonDao mockDao;

    @InjectMocks
    PersonService personService;

    @Test
    public void testUpdatePerson() throws ExceptionDao, ExceptionService {
        Person personne = new Person("Eric", "e.chaumont@ensup.eu", "34 rue du général De Gaule 75001", "0641458596", "Chaumont", Role.STUDENT, "e.chaumont");
        when(mockDao.update(any(Person.class))).thenReturn(1);
        boolean update = personService.update(6, "Dupont");
        assertTrue(update);
        Mockito.verify(mockDao).update(any(Person.class));
    }

    @Test
    public void testDeletePerson() throws ExceptionDao, ExceptionService {
        Person personne = new Person("Eric", "e.chaumont@ensup.eu", "34 rue du général De Gaule 75001", "0641458596", "Chaumont", Role.STUDENT, "e.chaumont");
        when(mockDao.delete(6)).thenReturn(1);
        int delete = personService.delete(6);
        assertEquals(1, delete);
    }
}
