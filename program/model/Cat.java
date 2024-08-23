package model;

import java.time.LocalDate;

public class Cat extends Pet{

    

    public Cat(String name){
        super(name);
    }
    public Cat(String name, LocalDate birthDay, Gender sex){
        this(name);
        super.setBirthDate(birthDay);
        super.setGender(sex);
    }    

    public String toString() {
        String string = "";
        if(super.getGender() == Gender.Female){
            string = "Кошка";
        } else {
            string = "Кот";
        }
        string = string + " " + this.getName();
        return string;
    }

    
 
    
     
   
     
 
     
 
    
     
}
