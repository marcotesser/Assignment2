////////////////////////////////////////////////////////////////////
// Marco Tesser 1201154
////////////////////////////////////////////////////////////////////


package it.unipd.tos.model;

public class MenuItem {
    
    public enum items { Gelato, Budino, Bevanda }
    private items itemType;
    private String name;
    private double price;

    public MenuItem(String n, items t, double p){
        this.name = n;
        this.itemType = t;
        this.price = p;
    }

    public String getName(){
        return name;
    }
    
    public items getType(){
        return itemType;
    }

    public double getPrice(){
        return price;
    }
}

