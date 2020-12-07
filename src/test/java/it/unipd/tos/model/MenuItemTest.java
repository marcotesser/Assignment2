////////////////////////////////////////////////////////////////////
// Marco Tesser 1201154
////////////////////////////////////////////////////////////////////


package it.unipd.tos.model;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Before;


public class MenuItemTest {

    MenuItem mi;

    @Before
    public void setup ( ) {
        mi = new MenuItem("Pinguino",MenuItem.items.Budino,12.00);
    }

    @Test
    public void getNameTest() {
        assertEquals("Pinguino",mi.getName());
    }

    @Test
    public void getTypeTest() {
        assertEquals(MenuItem.items.Budino,mi.getType());
    }

    @Test
    public void getPriceTest() {
        assertEquals(12.00,mi.getPrice(),0.0);
    }
}
