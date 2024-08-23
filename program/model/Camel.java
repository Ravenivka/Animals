package model;

import java.time.LocalDate;


public class Camel extends PackAnimal{    

    public Camel(String name){
        super(name);
    }    
    
    public Camel(String name, LocalDate birthDay, Gender sex){
        this(name);
        super.setBirthDate(birthDay);
        super.setGender(sex);
    }   

    public String toString() {
        String string = "";
        switch (super.getGender()){
            case Gender.Male:
                string = "Верблюд: Самец";
                break;
            case Gender.Female:
                string = "Верблюд: Самка";
                break;
        }
        string = string + " " + super.getName();
        return string;
    }

   

}
