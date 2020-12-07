////////////////////////////////////////////////////////////////////
// Marco Tesser 1201154
////////////////////////////////////////////////////////////////////

package it.unipd.tos.business;

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
        li = new ArrayList<MenuItem>();
        us = new User(1,"Marco","Tesser",21);
    	bi = new Bill(LocalTime.of(12,0,0,0),us);

    }
    
    @Test
    public void getUserTest() {
        assertEquals(us,bi.getUser());
    }
    
    @Test
    public void getLocalTimeTest() {
        assertEquals(LocalTime.of(12,0,0,0),bi.getLocalTime());
    }
    

    @Test
    public void ComputeTotalTest() {
    	li.add(new MenuItem("Banana Split",MenuItem.items.Gelato,13.00));
    	li.add(new MenuItem("Pinguino",MenuItem.items.Budino,12.00));
        try {
        assertEquals(25.00,bi.getOrderPrice(li,us),0.0);
        } catch (TakeAwayBillException e) {
        System.out.println("Errore");
        }
    }
    
    @Test
    public void CinqueGelati50Test() {
        for(int i = 0;i<5;i++) {
        	li.add(new MenuItem("Banana Split",MenuItem.items.Gelato,5.00));
        }
    	try {
            assertEquals(22.50,bi.getOrderPrice(li,us),0.0);
        } catch (TakeAwayBillException e) {
        System.out.println("Errore");
            }
    }

    @Test 
    public void Plus50Discount10Test() {
        li.add(new MenuItem("Banana Split",MenuItem.items.Gelato,40.00));
        li.add(new MenuItem("Pinguino",MenuItem.items.Budino,20.00));
    	try {
            assertEquals(54.00,bi.getOrderPrice(li,us),0.0);
        } catch (TakeAwayBillException e) {
        System.out.println("Errore");
        }
    }
    
    @Test (expected = TakeAwayBillException.class)
    public void Max30OrdersTest() throws TakeAwayBillException{
        for(int i = 0; i < 30; i++) {
            li.add(new MenuItem("Banana Split",MenuItem.items.Gelato,40.00));
        }
        bi.getOrderPrice(li, us);
    }
    
    @Test
    public void Less10AddCommissionTest() {
    	li.add(new MenuItem("Banana Split",MenuItem.items.Gelato,2.50));
    	try {
            assertEquals(3.00,bi.getOrderPrice(li,us),0.0);
        } catch (TakeAwayBillException e) {
        System.out.println("Errore");
        }
    }
    
    
    
}

