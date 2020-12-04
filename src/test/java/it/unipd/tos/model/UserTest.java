////////////////////////////////////////////////////////////////////
// Marco Tesser 1201154
////////////////////////////////////////////////////////////////////

//import org.junit.rules.ExpectedException;
//import org.junit.Rule;

package it.unipd.tos.model;

import it.unipd.tos.model.User;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import org.junit.Test;
import org.junit.Before;

public class UserTest {

    User us;

    @Before
    public void setup (){
        us = new User(23,"Marco","Tesser",21);
    }

    @Test 
    public void getIdTest(){
        assertEquals(23,us.getId());
    }

    @Test
    public void getNameTest() {
        assertEquals("Marco",us.getName());
    }

    @Test
    public void getSurnameTest(){
        assertEquals("Tesser",us.getSurname());
    }

    @Test
    public void getAgeTest(){
        assertEquals(21,us.getAge());
    }

    @Test
    public void isMinorenneTest() {
        assertFalse(us.isMinorenne());
    }
}
