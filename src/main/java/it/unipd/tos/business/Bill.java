////////////////////////////////////////////////////////////////////
// Marco Tesser 1201154
////////////////////////////////////////////////////////////////////


package it.unipd.tos.business;

import java.util.List;
import java.time.LocalTime;

import it.unipd.tos.business.exception.TakeAwayBillException;
import it.unipd.tos.model.MenuItem;
import it.unipd.tos.model.MenuItem.items;
import it.unipd.tos.model.User;
public class Bill implements TakeAwayBill {

    private LocalTime t;
    private User us;
    private boolean gifted;
    private static CashRegister cr = new CashRegister();

    public Bill(LocalTime t, User user){
        this.t = t;
        this.us = user;
        cr.AddBill(this);
        this.gifted = cr.gift();
    }
    
    public LocalTime getLocalTime() {
        return t;
    }    
    
    public User getUser() {
        return us;
    }
    
    public boolean getGifted() {
        return gifted;
    }

    public double getOrderPrice(List<MenuItem> itemsOrdered, User user) throws TakeAwayBillException {
        
        double tot = 0;
        int icecreamcounter = 0;
        double minicecreamprice = Double.MAX_VALUE;
        double icecreamandpuddingpricecount = 0;
        
        if(itemsOrdered.size() >= 30) {
            throw new TakeAwayBillException("Numero massimo ordini superato");
        }
        
        if(!gifted){
        for(MenuItem mi : itemsOrdered) {
            if(mi.getType() == items.Gelato) {
                icecreamcounter ++;
                if(mi.getPrice() < minicecreamprice) {
                    minicecreamprice = mi.getPrice();
                }
            }
            if(mi.getType() != items.Bevanda) {
                icecreamandpuddingpricecount += mi.getPrice();
            }
            tot += mi.getPrice();
        }
        if (icecreamcounter >= 5){
            tot -= minicecreamprice/2;
        }
        if (icecreamandpuddingpricecount >= 50){
            tot *= 0.9;
        }
        if (tot < 10) {
            tot += 0.5;
        }
        }
        return tot;
         
    }

}
