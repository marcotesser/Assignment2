////////////////////////////////////////////////////////////////////
// Marco Tesser 1201154
////////////////////////////////////////////////////////////////////




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
        ul = new ArrayList<User>();
    }

    CashRegister(List<Bill> alb,List<User> alu){
        bl = alb;
        ul = alu; 
    }

    public List<Bill> getListBill(){
        return bl;
    }

    public List<User> getListUser(){
        return ul;
    }

    public int getGiftCounter(){
    
        return giftcounter;
    }

    public void AddBill(Bill b){
        bl.add(b);
        ul.add(b.getUser());
    }

    public boolean gift(){

    if(!(bl.get(bl.size()-1).getLocalTime().isAfter(init) && bl.get(bl.size()-1).getLocalTime().isBefore(end)) || (!ul.get(ul.size()-1).isMinorenne())){ 
        return false;
    }
    for(int i = 0;i <= ul.size()-2;i++) {
        if(ul.get(i).getId()== (ul.get(ul.size()-1).getId())){
            if(ul.get(i).getName()== (ul.get(ul.size()-1).getName())) {
                if(ul.get(i).getSurname()== (ul.get(ul.size()-1).getSurname())) {
                    if(ul.get(i).getAge()== (ul.get(ul.size()-1).getAge())) {
                        return false;
                    }
                }
            }
        }
    }
        
    if(new Random().nextInt()%2==1 && giftcounter<10){ 
        giftcounter++;
        return true;
    }
    return false;
    }
}