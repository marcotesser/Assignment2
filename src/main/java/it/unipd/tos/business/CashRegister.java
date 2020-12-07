package it.unipd.tos.business;

import it.unipd.tos.model.User;
import java.util.List;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Random;

public class CashRegister {

	private List<Bill> bl;
	private List<User> ul;
	private LocalTime init = LocalTime.of(18, 00);
	private LocalTime end = LocalTime.of(19, 00);
	private int giftcounter = 0;
	
	CashRegister(){
		bl = new ArrayList<Bill>();
	}
	
	public void AddBill(Bill b){
		bl.add(b);
		ul.add(b.getUser());
	}
	
	public boolean gift() {

    if(!(bl.get(bl.size()-1).getLocalTime().isAfter(init) && bl.get(bl.size()-1).getLocalTime().isBefore(end)) && !ul.get(ul.size()-1).isMinorenne()) return false;
	
    if(new Random().nextInt()%2==1 && giftcounter<10) { 
    	giftcounter++;
    	return true;
    }
	return false;
	}
}
	
