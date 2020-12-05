////////////////////////////////////////////////////////////////////
// Marco Tesser 1201154
////////////////////////////////////////////////////////////////////


package it.unipd.tos.business;

import java.util.List;
import java.util.ArrayList;
import java.time.LocalTime;

import it.unipd.tos.business.exception.TakeAwayBillException;
import it.unipd.tos.model.MenuItem;
import it.unipd.tos.model.MenuItem.items;
import it.unipd.tos.model.User;

public class Bill implements TakeAwayBill {

    private LocalTime t;

    public Bill(LocalTime t){
        this.t = t;
    }

    public double getOrderPrice(List<MenuItem> itemsOrdered, User user) throws TakeAwayBillException {
        
        double tot = 0;
        int icecreamcounter = 0;
        double minicecreamprice = Double.MAX_VALUE;
        double icecreamandpuddingpricecount = 0;
        
        if(itemsOrdered.size() >= 30) {
            throw new TakeAwayBillException("Numero massimo ordini superato"); 	
        }
        
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
        return tot;
    }

}
