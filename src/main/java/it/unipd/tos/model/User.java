////////////////////////////////////////////////////////////////////
// Marco Tesser 1201154
////////////////////////////////////////////////////////////////////


package it.unipd.tos.model;

public class User {

    private int id;
    private String name;
    private String surname;
    private int age;

    public User (int id , String name , String surname , int age){
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }
 
    public String getSurname(){
        return surname;
    }
        
    public int getAge(){
        return age;
    }
 
    public boolean isMinorenne(){
        return age < 18;
    }
}
