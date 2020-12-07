package it.unipd.tos.business.exception;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Before;


public class TakeAwayBillExceptionTest {


    TakeAwayBillException ex;
    
    @Before
    public void setup (){
        ex = new TakeAwayBillException("Errore");
    }

	@Test
    public void ComputeTotalTest() {
        assertEquals("Errore",ex.getMessage());
    }
}
