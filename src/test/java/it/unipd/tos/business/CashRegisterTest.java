////////////////////////////////////////////////////////////////////
// Marco Tesser 1201154
////////////////////////////////////////////////////////////////////


package it.unipd.tos.business;

import it.unipd.tos.model.User;

import java.util.List;
import java.util.ArrayList;
import java.time.LocalTime;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.Before;



public class CashRegisterTest {

    private List<Bill> bl;
	private List<User> ul;
    private CashRegister cr;
	
	@Before
	public void Setup() {
		
		ul = new ArrayList<User>();
		bl = new ArrayList<Bill>();
		for (int i = 0;i<25;i++) {
	    ul.add(new User(i,"Marco","Tesser",i%2==0 ? 10 : 20));
		}
		for (int i = 0;i<25;i++){
	    bl.add(new Bill(i%2==0 ? LocalTime.of(18, 30) : LocalTime.of(19, 30),ul.get(i)));
		}
	    cr = new CashRegister(bl,ul);
	}
	
	@Test
	public void giftcountertest(){
		
		assertEquals(0,cr.getGiftCounter());
	}
	
	@Test
	public void listBilltest(){
		assertEquals(bl,cr.getListBill());
	}
	
	@Test
	public void listUsertest(){
		assertEquals(ul,cr.getListUser());
	}
	
	@Test
	public void addBilltest(){
		Bill b = new Bill(LocalTime.of(12,0,0,0),new User(90,"Marco","Tesser",21));
		cr.AddBill(b);
		assertEquals(b,cr.getListBill().get(cr.getListBill().size()-1));
	}
    
	@Test
	public void gifttest1(){
		cr.AddBill(new Bill(LocalTime.of(18,40),new User(91,"Marco","Tesser",21)));
		assertFalse(cr.gift());
	}
	
	@Test
	public void gifttest2(){
		cr.AddBill(new Bill(LocalTime.of(19,40),new User(91,"Marco","Tesser",15)));
		assertFalse(cr.gift());
	}
	
	@Test
	public void gifttest3(){
		cr.AddBill(new Bill(LocalTime.of(19,40),new User(91,"Marco","Tesser",21)));
		assertFalse(cr.gift());
	}
	
    @Test
    public void gifttest4(){
        cr.AddBill(new Bill(LocalTime.of(18,40),new User(20,"Marco","Tesser",10)));
        assertFalse(cr.gift());
	}

    @Test
    public void gifttest5(){
    	boolean a = false,c = true;
        for(int i = 0;i < 1000;i++) {
        	cr.AddBill(new Bill(LocalTime.of(18,40),new User(i+25,"Marco","Tesser",10)));
        	boolean b = cr.gift();
    	    if(b) {
    	    	a=b;
    	    }
    	    else c=b;
        }
    	assertTrue(a && !c);
	}
}
