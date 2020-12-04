////////////////////////////////////////////////////////////////////
// Marco Tesser 1201154
////////////////////////////////////////////////////////////////////

package it.unipd.tos.business;

import it.unipd.tos.business.Bill;
import it.unipd.tos.model.User;
import it.unipd.tos.model.MenuItem;
import it.unipd.tos.business.exception.TakeAwayBillException;

import java.util.List;
import java.util.ArrayList;
import java.time.LocalTime;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Before;

public class BillTest {

    Bill bi; 
    List<MenuItem> li;
    User us;

    @Before
    public void setup (){
        bi = new Bill(LocalTime.of(12,0,0,0));
        li = new ArrayList<MenuItem>();
        li.add(new MenuItem("Pinguino",MenuItem.items.Budino,12.00));
        li.add(new MenuItem("Banana Split",MenuItem.items.Gelato,13.00));
        us = new User(1,"Marco","Tesser",21);
    }

    @Test
    public void ComputeTotalTest() {
        
        try {
        assertEquals(25.00,bi.getOrderPrice(li,us),0.0);
        } catch (TakeAwayBillException e) {
        System.out.println("Errore");
        }
    }
}

