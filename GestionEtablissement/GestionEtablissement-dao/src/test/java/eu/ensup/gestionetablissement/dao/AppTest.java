package eu.ensup.gestionetablissement.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


import eu.ensup.gestionetablissement.business.Person;
import eu.ensup.gestionetablissement.business.Role;
import eu.ensup.gestionetablissement.business.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    PersonDao person = new PersonDao();
    public List<Person> listpers;
    /**
     * Rigorous Test :-)
     */

    @BeforeEach
    public void getAllPerson() {

        try {
            PersonDao person = new PersonDao();
            listpers = person.getAll();

        } catch (ExceptionDao exceptionDao) {
            exceptionDao.printStackTrace();
        }
    }

    @Test
    @DisplayName("Test Last Name")
    public void testLastNameIs() throws ExceptionDao {

        assertEquals("Eric", person.get(6).getLastname());
    }

    @Test
    @DisplayName("Test FirstName")
    public void testFirstNameIsNot() throws ExceptionDao{
        assertThat(person.get(6).getFirstname(), is(not("Chaumont")));
    }

    @Test
    @DisplayName("Test if person is instance of Person")
    public void testInstanceOf() throws ExceptionDao{
        assertThat(person, instanceOf(PersonDao.class));
    }

    @Test
    @DisplayName("Test Champ vide")
    public void testNullValueField() throws ExceptionDao{
        assertThat(person.get(138).getPhoneNumber(), nullValue());
    }

    @Test
    @DisplayName("Test Creation Person")
    public void testCreatePerson() throws ExceptionDao {
        Person personne = new Person("Eric", "e.chaumont@ensup.eu", "34 rue du général De Gaule 75001", "0641458596", "Chaumont", Role.STUDENT, "e.chaumont");
        // String lastname, String mailAddress, String address, String phoneNumber, String firstname, Role role, String password
        assertThat(person.create(personne), equalTo(1));
    }

    @Test
    @DisplayName("Test Check Password")
    public void testCheckPassword() throws ExceptionDao {
        LoginDao login = new LoginDao();
        assertThat(login.checkPassword("e.chaumont@ensup.eu", "e.chaumont"), equalTo(6));
    }

    @Test
    @DisplayName("Test List not Empty")
    public void testListNotEmpty() throws ExceptionDao {
        assertThat(listpers, is(not(empty())));
    }

}
